package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
public class DictionaryTest
{    
    /**
     * Test that the dictionary finds empty space. It's a special situation, when
     * the dictionary will provide empty space for given empty space. It is required
     * because traditional space in Morse code is much more complex.
     */
    @Test
    public void testItFindsEmptySpace()
    {
        Dictionary dictionary = new Dictionary();
        
        try {
            Assertions.assertTrue(dictionary.find(" ").equals(" "), "Two empty spaces are not equal!");
        } catch(TranslatorException exception) {
            Assertions.fail(exception.getMessage());
        }
    }
    
    /**
     * Test every character available in dictionary.
     * 
     * @param alpha character variation
     * @param morse characters version of alpha code
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
        "z, --.."
    })
    public void testItFindsCharacter(String alpha, String morse)
    {
        Dictionary dictionary = new Dictionary();
        
        try {
            Assertions.assertTrue(dictionary.find(alpha).equals(alpha), "Two Alpha characters are not equal");
            Assertions.assertTrue(dictionary.find(alpha).equals(morse), "Morse and Alpha character are not equal");
            Assertions.assertTrue(dictionary.find(morse).equals(morse), "Two Morse characters are not equal");
        } catch(TranslatorException exception) {
            Assertions.fail(exception.getMessage());
        }
    }
    
    /**
     * Test every other character on standard EU keyboard that don't exist in dictionary.
     * 
     * @param character that we will be looking for in dictionary.
     */
    @ParameterizedTest
    @ValueSource(strings = {
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
        "!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
        "_", "+", "=", "`", "~", ";", ":", "\"", "\'",
        "{", "[", "]", "}", "|", "\\", ",", "<", ">",
        "?", "/"
    })
    public void testItThrowsException(String character)
    {
        Dictionary dictionary = new Dictionary();
        
        TranslatorException exception = Assertions.assertThrows(
            TranslatorException.class,
            () -> dictionary.find(character)
        );
        Assertions.assertEquals("Character not found in dictionary: " + character, exception.getMessage(), "Exception message is not as expected");
    }
    
    @Test
    public void testNullable()
    {
        Dictionary dictionary = new Dictionary();
         
        TranslatorException exception = Assertions.assertThrows(
            TranslatorException.class,
            () -> dictionary.find(null)
        );
        Assertions.assertEquals("Search character cannot be null", exception.getMessage(), "Exception message is not as expected");
    }
}
