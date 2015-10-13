/**
 * A driver class for the MyStack class. 
 * Creates and allows for manipulation of a stack of strings.
 * 
 * @author Emily Lopez (elopez21) Emily Lucas (eclucas)
 *
 *	@version Project 1 2015-10-08
 */

import java.util.Scanner;
import java.util.EmptyStackException;

public class StackTest 
{
   /**
    * Main method that uses the MyStack class.
    */
	public static void main(String[] args)
	{
		MyStack<String> stack = new MyStack<String>(); //the stack to be tested
		Scanner in = new Scanner(System.in); //Scanner that gets input from the console
		String input; //the string inputed by the user.
		boolean quit = false; //variable used to quit the program.
      
		System.out.println("Choose one of the following operations:");
		System.out.println("\t- push/add (enter the letter a)");
		System.out.println("\t- pop/delete (enter the letter d)");
		System.out.println("\t- peek (enter the letter p)");
		System.out.println("\t- check if the list is empty (enter the letter e)");
		System.out.println("\t- Quit (enter the letter q)\n");
		
      while(!quit)
      {
         System.out.println("Please enter your menu selection: ");
         input = in.nextLine();
         
   		switch(input)
   		{
            case "a":   System.out.println("Please enter an input value:");
                        stack.push(in.nextLine());
                        System.out.println(stack.peek() + " was added");
                        break;
            
            case "d":   try
                        {
                           System.out.println(stack.pop() + " was popped");
                        }
                        catch(EmptyStackException e)
                        {
                           System.out.println("Invalid operation on an empty stack");
                        }
                        break;
   
            case "p":   try
                        {
                           System.out.println(stack.peek() + " is on top");
                        }
                        catch(EmptyStackException e)
                        {
                           System.out.println("Invalid operation on an empty stack");
                        }
                        break;
            
            case "e":   if(stack.isEmpty())
                        {
                           System.out.println("Stack is empty");
                        }
                        else
                        {
                           System.out.println("Stack is not empty");
                        }
                        break;
            
            case "q":   quit = true;
                        System.out.println("Goodbye");
                        break;   
         
            default:   
                        System.out.println("Invalid input");
                        break; 
		   } //end switch        
      }//end while loop
      in.close();
	}//end main
}//end class
