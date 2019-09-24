/**
* IntNode.java (Singly Linked List)
* This program contains the methods and constructors to	
* build a linked list
* Course:	CS463
*
* @author  Jaime Candelaria
* @version 1.0
* @since   2019-09-23 
*/

public class IntNode {
	
//Instance variables section	
	private int 	data;
	private IntNode	link;
	
	
/**
* This is the no-argument constructor that initializes both instance variables 
* @param None
*/		
	public IntNode()
	{
		data = 0;
		link = null;
	}
	
/**
* This is the constructor that initializes data and link to the given values. 
* @param _data This is the data to be initialized
* @param _node This is the node reference to be initialized
*/			
	public IntNode(int _data, IntNode _node)
	{
		data = _data;
		link = _node;
	}

/**
* This method returns node's data value.
* @param None
* @return Integer node's data value
*/		
	public int GetData()
	{
		return data;
	}

/**
* This method replaces object's data with newData.
* @param Integer newData to be set
* @return None
*/		
	public void SetData(int newData)
	{
		data = newData;
	}

/**
* This method returns node's link reference.
* @param None
* @return IntNode node's link reference
*/	
	public IntNode GetLink()
	{
		return link;
	}

/**
* This method replaces object's link with newLink.
* @param IntNode newLink reference to be set
* @return None
*/			
	public void SetLink(IntNode newLink)
	{
		link = newLink;
	}
	
/**
* This method generates a string representation of a linked list
* starting from the node that activates the method.
* @param None
* @return String containing linked list's data values.
*/				
	public String toString()
	{
		IntNode cursor;
		String answer = "";
		
		if(link == null)
		{
			answer += "null";
			return answer;
		}
		else
		{	
			answer += Integer.toString(data);
			answer += "->";
		}
		
		for(cursor = link; cursor != null; cursor = cursor.link)
		{
			answer += Integer.toString(cursor.data);
			if(cursor.link != null)
				answer += "->";
		}
		
		return 	answer;
	}	
	
/**
* This method adds a node after the current node.
* @param Integer node's newData value
* @return None
*/		
	public void addNodeAfterThis(int newdata)
	{
		try
		{
			link = new IntNode(newdata,link);
		}		
		catch(OutOfMemoryError e)
		{
			System.out.println("There's insuficient memory to perform this action");
		}	
	}

/**
* This method removes a node after the current node.
* @param None
* @return None
*/			
	public void removeNodeAfterThis()
	{
		link = link.link;
	}
	
/**
* This static method returns the number of nodes in a list, starting from the head.
* @param IntNode head to start counting from
* @return Integer with the amount of nodes contained in the list
*/			
	public static int listLength(IntNode head)
	{
		int nodeCounter = 0;
		IntNode cursor;
		
		for(cursor = head; cursor != null; cursor = cursor.link)
			nodeCounter++;
		
		return nodeCounter;
	}	
	

/**
* This static method searches whether a node contains the given data value.
* @param IntNode head  node of a list 
* @param Integer data value to search for
* @return Boolean true if value is found, false otherwise 
*/				
	public static boolean search(IntNode head, int _data)
	{
		IntNode cursor;
		
		try
		{
			if(head == null)
				throw new Exception();
			
			for(cursor = head; cursor != null; cursor = cursor.link)
			{
				if(_data == cursor.data)
					return true;
			}
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException("Head cannot be null");
		}
		
		return false;
	}	
	
}
