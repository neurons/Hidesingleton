import org.cytoscape.app.swing.AbstractCySwingApp;
import org.cytoscape.app.swing.CySwingAppAdapter;

public class HideSingletonNodesApp extends AbstractCySwingApp 
{
	public HideSingletonNodesApp(CySwingAppAdapter adapter)
	{
		super(adapter);//call AbstractCySwingApp method 
        adapter.getCySwingApplication().addAction(new MenuAction(adapter)); // call the MenuAction on Adapter to hide singletons
	}
}