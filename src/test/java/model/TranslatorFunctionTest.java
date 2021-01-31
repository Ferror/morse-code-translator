package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
public class TranslatorFunctionTest
{
    /**
     * Test lambda expression function which is based on dictionary, but when
     * character is not found in dictionary, expression returns ? character.
     * 
     * @param alpha expected character
     * @param morse input character
     */
    @ParameterizedTest
    @CsvSource(value = {
        "a, .-",
        "b, -...",
        "c, -.-.",
        "d, -..",
        "e, .",
        "f, ..-.",
        "g, --.",
        "h, ....",
        "i, ..",
        "j, .---",
        "k, -.-",
        "l, .-..",
        "m, --",
        "n, -.",
        "o, ---",
        "p, .--.",
        "q, --.-",
        "r, .-.",
        "s, ...",
        "t, -",
        "u, ..-",
        "v, ...-",
        "w, .--",
        "x, -..-",
        "y, -.--",
        "z, --..",
        "?, \\"
    })
    public void testItTranslatesMorseCode(String alpha, String morse)
    {
        TranslatorFunction expression = new TranslatorFunction(new Dictionary());
        
        Assertions.assertEquals(alpha, expression.apply(morse), "Invalid Lambda morse to alpha translation");
    }
    
    @Test
    public void testNullable()
    {
        TranslatorFunction expression = new TranslatorFunction(new Dictionary());
        
        Assertions.assertEquals("?", expression.apply(null), "Invalid Lambda nullable value translation");
    }
}
