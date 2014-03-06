import java.awt.event.ActionEvent;

import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;


public class MenuAction extends AbstractCyAction {
    private final CyAppAdapter adapter;

    public MenuAction(CyAppAdapter adapter) {
        super("Hide unconnected nodes", adapter.getCyApplicationManager(),"network",adapter.getCyNetworkViewManager()); // call the AbstractCyAction method
        this.adapter = adapter; // use the passed parameter to assign to global adapter
        setPreferredMenu("Select"); // use "Select" menu option
    }
 
    public void actionPerformed(ActionEvent e) {
        final CyApplicationManager manager = adapter.getCyApplicationManager();
        final CyNetworkView networkView = manager.getCurrentNetworkView();
        final CyNetwork network = networkView.getModel();
        
        for (CyNode node : network.getNodeList()) {
            if (network.getNeighborList(node, CyEdge.Type.ANY).isEmpty()) //if no neighors (i.e. the neighborhood of a node is 0)
                networkView.getNodeView(node).setVisualProperty(BasicVisualLexicon.NODE_VISIBLE, false); // set it to not visible
        }

        networkView.updateView();
    }
}