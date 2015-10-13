/**
 * A Test class that tests the functionality of the Converter Class
 *
 * @author Emily Lucas (eclucas)
 *
 * @version Project 1 2015-10-08
 */

import static org.junit.Assert.*;

import org.junit.Test;


public class ConverterTest
{
    /**
     * Tests the infixToPostfix method using one character
     */
    @Test
    public void testInfixToPostfixOneChar() 
    {
        assertEquals("a is expected to be a", "a", Converter.infixToPostfix("a"));
    }

    /**
     * Tests the infixToPostfix method using one string of characters
     */
    @Test
    public void testInfixToPostfixOneWord()
    {
        assertEquals("word is expected to be word", "word", Converter.infixToPostfix("word"));
    }
    
    /**
     * Tests the infixToPostfix method using 0
     */
    @Test
    public void testInfixToPostfixZero()
    {
        assertEquals("0 is expected to be 0", "0", Converter.infixToPostfix("0"));
    }

    /**
     * Tests the infixToPostfix method using one double
     */
    @Test
    public void testInfixToPostfixDouble()
    {
        assertEquals("1.2 is expected to be 1.2", "1.2", Converter.infixToPostfix("1.2"));    
    }

    /**
     * Tests the infixToPostfix method with 2 operands and +
     */
    @Test
    public void testInfixToPostfixAdd()
    {
        assertEquals("a + b is expected to be a b +", "a b +", Converter.infixToPostfix("a + b"));
    }

    /**
     * Tests the infixToPostfix method with 2 operands and -
     */
    @Test
    public void testInfixToPostfixSub()
    {
        assertEquals("a - b is expected to be a b -", "a b -", Converter.infixToPostfix("a - b"));
    }

    /**
     * Tests the infixToPostfix method with 2 operands and *
     */
    @Test
    public void testInfixToPostfixMult()
    {
        assertEquals("a * b is expected to be a b *", "a b *", Converter.infixToPostfix("a * b"));
    }

    /**
     * Tests the infixToPostfix method with 2 operands and /
     */
    @Test
    public void testInfixToPostfixDiv()
    {
        assertEquals("a / b is expected to be a b /", "a b /", Converter.infixToPostfix("a / b"));
    }
    
    /**
     * Tests the infixToPostfix method with 4 operands and +'s and -'s in mixed order
     */
    @Test
    public void testInfixToPostfixAddSub()
    {
        assertEquals("a + b - c + d is expected to be a b + c - d +", "a b + c - d +",
                    Converter.infixToPostfix("a + b - c + d"));
    }

    /**
     * Tests the infixToPostfix method with 4 operands and *'s and /'s in mixed order
     */
    @Test
    public void testInfixToPostfixMultDiv()
    {
        assertEquals("a * b / c * d is expected to be a b * c / d *", "a b * c / d *",
                    Converter.infixToPostfix("a * b / c * d"));
    }
    
    
    
    
    
    @Test
    public void testPostfixValue() 
    {
        fail("Not yet implemented");
    }

}
