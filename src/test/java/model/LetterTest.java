package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class LetterTest
{
    /**
     * Test Letter's equals functionality if the given alpha and morse characters
     * are equal to given character.
     */
    @Test
    public void testItEquals()
    {
        Letter letter = new Letter("a", ".-");
        
        Assertions.assertTrue(letter.equals("a"), "Given character does not equals the state");
        Assertions.assertTrue(letter.equals(".-"), "Given character does not equals the state");
        Assertions.assertFalse(letter.equals("not-really"), "Not existing character equals state");
        Assertions.assertFalse(letter.equals(null), "Nullable parameter equals state");
    }
}
