package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class LetterTest
{
    @Test
    public void testItEquals()
    {
        Letter letter = new Letter("a", ".");
        
        Assertions.assertTrue(letter.equals("a"));
        Assertions.assertTrue(letter.equals("."));
        Assertions.assertFalse(letter.equals("not-really"));
    }
}
