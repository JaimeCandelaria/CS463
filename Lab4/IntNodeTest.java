/**
* IntNodeTest.java (Singly Linked List)
* This program contains the main method to test the IntNode java class
* Course:	CS463
*
* @author  Jaime Candelaria
* @version 1.0
* @since   2019-09-23 
*/

public class IntNodeTest {

	
	public static void main(String[] args) 
	{
		int nodeQuantity = 0;
		
		//----------------------NODE INITIALIZATION----------------------
		//Create new nodes
		System.out.println("Create a head node and refer it to a new node with default constructor.");
		IntNode head = new IntNode();
		
		System.out.println("Data from node with default constructor: " + head.GetData());
		System.out.println("Link information from node with default constructor: " + head.GetLink());
		
		System.out.println("\nAdd a node after head node with 42 as data, make node 2 refer to it.");
		head.addNodeAfterThis(42);
				
		IntNode node2;
		node2 = head.GetLink();
						
		System.out.println("\nInstantiate node #3 with 150 as data and a null link.");
		IntNode node3 = new IntNode(150,null);
		
		System.out.println("\nSet node's 2 link to node 3.");
		node2.SetLink(node3);
		
		System.out.println("Node's 3 data accessed from node2 is: " + node2.GetLink().GetData());
				
		nodeQuantity = IntNode.listLength(head);
		System.out.println("\nThis is how many nodes are currently in the list: " + nodeQuantity);		
		
		System.out.println("This is the string representation of the list viewed from the head node: " + head.toString());
				
		System.out.println("\nInstantiate node #4 with 13 as data. Set node's 3 link reference to node 4.");
		IntNode node4 = new IntNode(13,null);
		node3.SetLink(node4);
		
		System.out.println("Instantiate node #5 with 87 as data. Set node's 4 link reference to node 5.");
		IntNode node5 = new IntNode(87,null);
		node4.SetLink(node5);	
		
		System.out.println("Instantiate node #6 with 1756 as data. Set node's 5 link reference to node 6.");
		IntNode node6 = new IntNode(1756,null);
		node5.SetLink(node6);
		
		System.out.println("Instantiate node #7 with 921 as data. Set node's 6 link reference to node 7.");
		IntNode node7 = new IntNode(921,null);
		node6.SetLink(node7);
		
		System.out.println("Instantiate node #8 with 11 as data. Set node's 7 link reference to node 8.");
		IntNode node8 = new IntNode(11,null);
		node7.SetLink(node8);
		
		System.out.println("Instantiate node #9 with 8233 as data. Set node's 8 link reference to node 9.");
		IntNode node9 = new IntNode(8233,null);
		node8.SetLink(node9);
		
		System.out.println("\nAdd a node after node 9 with data = 45.");
		node9.addNodeAfterThis(45);
		System.out.println("This is the current string representation of the list viewed from the head node: " + head.toString());
		
		IntNode node10 = node9.GetLink();
		
		System.out.println("\nInstantiate node #10 with 5567 as data. Set node's 9 link reference to node 10.");
		IntNode node11 = new IntNode(5567,null);
		node10.SetLink(node11);
		
		nodeQuantity = IntNode.listLength(head);
		System.out.println("\nThis is how many nodes are currently in the list: " + nodeQuantity);		
		
		System.out.println("This is the current string representation of the list viewed from the head node, after adding the rest of the nodes: " + head.toString());
		
		System.out.println("\nModify node's 10 data to be 112233.");
		node10.SetData(112233);
		System.out.println("Node's 10 data now is: " + node10.GetData());
		System.out.println("This is the string representation of the list viewed from the head node, after adding the rest of the nodes: " + head.toString());
		
		System.out.println("\nThis is the string representation of the list viewed from node #5: " + node5.toString());
		
		System.out.println("\nProceed to remove node 3.");
		node2.removeNodeAfterThis();
		System.out.println("This is the string representation of the list viewed from the head node is: " + head.toString());
		
		head.removeNodeAfterThis();
		System.out.println("\nProceed to remove the node following the head node.");
		System.out.println("This is the string representation of the list after removing the node after the head node: " + head.toString());
		
		System.out.println("\nSearch is one of the nodes in the list contains data = 004: " + IntNode.search(head, 004));
		System.out.println("Search is one of the nodes in the list contains data = 87: " + IntNode.search(head, 87));
		
		IntNode nullHead = null;
		System.out.println("Search for an existing value with a head = null: " + IntNode.search(nullHead, 87));
		
		

	}
}
