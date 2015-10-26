/**
 * A class that converts arithmetic expressions
 * from infix to postfix notation.
 *
 * @author Emily Lucas (eclucas)
 *
 * @version Project 1 2015-10-08
 */

public class Converter 
{    
    /**
     * Converts a correctly formatted infix arithmetic expression into postfix notation.
     * 
     * @param expression the arithmetic expression to be converted
     * @return expression in postfix notation
     */
    public static String infixToPostfix(String expression)
    {
        MyStack<String> stack = new MyStack<String>();
        String[] input = expression.split("\\s+");
        String output = "";
        
        for(int i = 0; i < input.length; i++)
        {
            switch (input[i])
            {
                case "(": stack.push(input[i]);
                        break;
                case "*"://falls through /
                    
                case "/": if(!stack.isEmpty())
                          {
                              String[] toCheck = new String[]{"*", "/"};
                              
                              if(check(stack, toCheck))
                              {
                                  while(!stack.isEmpty() && check(stack, toCheck))
                                  {
                                      output += " " + stack.pop();
                                  }                              
                              }
                          }
                          
                          stack.push(input[i]);
                        break;
                case "+"://falls through to -
                         
                case "-": if(!stack.isEmpty())
                          {    
                              String [] toCheck = new String[]{"*", "/", "+", "-"};
                              
                              if(check(stack, toCheck))
                              {
                                  while(!stack.isEmpty() && check(stack, toCheck))
                                  {
                                      output += " " + stack.pop();
                                  }
                              }   
                          }
                          stack.push(input[i]);
                          
                        break;
                case ")":
                        break;
                default: 
                        if(output.equals(""))
                        {
                            output += input[i];
                        }
                        else
                        {
                            output += " " + input[i];
                        }
                        break;
            }//end switch
        } //end for loop
        
        
        while(!stack.isEmpty())
        {
            String[] toCheck = new String[] {"(", ")"};
            
            if(check(stack, toCheck))
            {
                stack.pop();
            }
            else
            {
                if(output.length() != 0)
                {
                    output += " ";
                }
                
                output +=  stack.pop();
            }
        }
   
        return output;
    }
    
    /**
     * Returns the value of a valid postfix arithmetic expression
     * 
     * @param valid postfix arithmetic expression to be evaluated
     * @return result of the arithmetic expression
     */
    public static double postfixValue(String expression)
    {
        return Double.NaN;
    }

    //Checks to see if any of the items in the array are at the top of the stack
    //Not sure about javadocs for private methods
    private static boolean check(MyStack<String> stack, String[] input)
    {
        boolean result = false;
        int i = 0;
        
        while(!result && i < input.length)
        {
            result = stack.peek().equals(input[i]);
            i++;
        }
        
        return result;
    }
}
