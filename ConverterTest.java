/**
 * A Test class that tests the functionality of the Converter Class
 *
 * @author Emily Lucas (eclucas)
 *
 * @version Project 1 2015-10-08
 */

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ConverterTest
{ 
    private String expression; //the expression to be evaluated
    private String expected; //the expected result
    
    /**
     * Constructor for use with @Parameters
     * 
     * @param expression infix expression to be evaluated
     * @param expected postfix expression equivalent of expression
     */
    public ConverterTest(String expression, String expected)
    {
        this.expression = expression;
        this.expected = expected;
    }
    
    /**
     * Sets the Parameters for testing the infix to postfix method
     * 
     * @return the expression and expected data
     */
    @Parameters(name = "Testing valid infix to postfix conversion")
    public static Iterable<Object[]> data()
    {
        return Arrays.asList(new Object[][]{
                {"a", "a"},
                {"word", "word"},
                {"0", "0"},
                {"30.7", "30.7"},
                {"a + b", "a b +"},
                {"a - b", "a b -"},
                {"a * b", "a b *"},
                {"a / b", "a b /"},
                {"a + b - c + d", "a b + c - d +"},
                {"a * b / c / d", "a b * c / d /"},
                {"a + b * c - d", "a b c * + d -"},
                {"a * b / c - d", "a b * c / d -"},
                {"( a )", "a"},
                {"( a + b )", "a b +"},
                {"( a ) + b", "a b +"},
                {"a + ( b )", "a b +"},
                {"( a ) + ( b )", "a b +"},
                {"( ( a ) + ( b ) )", "a b +"},
                {"a + ( b - c ) - d", "a b c - + d -"},
                {"( a + b ) - c", "a b + c -"},
                {"a * ( b / c ) / d", "a b c / * d /"},
                {"( a * b ) / c", "a b * c /"},
                {"a * ( b + c ) - d", "a b c + * d -"},
                {"a * ( b - c ) * d", "a b c - * d *"},
                {"a - ( b * c ) * d", "a b c * d * -"},
                {"a - b + ( c * d + e / f ) - g", "a b - c d * e f / + + g -"},
                {"a - b * ( c - d * e / f - g ) * h", "a b c d e * f / - g - * h * -"}
        }
        );
    }

    /**
     * Tests the infix to postfix method
     */
    @Test
    public void testInfixToPostfix()
    {
        assertEquals(expected, Converter.infixToPostfix(expression));
    }
}

