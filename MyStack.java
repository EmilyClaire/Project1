/**
 * A class that provides all functionality of a stack.
 * 
 * @author Emily Lopez (elopez21) Emily Lucas (eclucas)
 *
 *	@version Project 1 2015-10-08
 */

import java.util.EmptyStackException;

public class MyStack<T> 
{
	private Node top; 		//The node at the top of the stack
	
	/**
	 * Class that holds the values in the stack
	 */
	private class Node
	{
		public T value;		//The value in the node
		public Node next;	//The next node in the stack
	}
	
	/**
	 * Constructor for MyStack Class
	 */
	public MyStack()
	{
		top = null;
	}
	
	/**
	 * Adds a value to the top of the stack
	 */
	public void push(T input)
	{
		Node node = new Node(); //node to be added to the list 
		node.value = input;
		node.next = top;
		top = node;
	}
	
	/**
	 * Returns the value at the top of the stack
	 * 
	 * @return The value at the top of the stack
	 */
	public T pop()
	{
		T temp;	//The value to be popped

		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			temp = top.value; 
			top = top.next;
		}
		
		return temp;
	}
	
	/**
	 * Shows the value at the top of the stack without removing it
	 * 
	 * @return the value at the top of the stack
	 */
	public T peek()
	{
		T temp; //The value at the top of the stack that is returned.
		
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			temp = top.value;
		}

		return temp;
	}
		
	/**
	 * Tells if the stack is empty or not.
	 * 
	 * @return true if empty, false if not empty
	 */
	public boolean isEmpty()
	{
		return top == null;
	}
}
