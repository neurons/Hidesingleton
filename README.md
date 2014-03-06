Hidesingleton
=============

menu option to remove nodes without edges

In the "Select" menu, an option "Hide unconnected nodes" will appear. Selecting this will cause all singleton nodes to
disapper. 

A CyNetwork object is used. The app interates through each of the nodes in the list (getNodeList() method) and if the 
neighborlist is empty, the visual property of the network is updated so that the nodes without a edge/connection is set to
invisible. 

