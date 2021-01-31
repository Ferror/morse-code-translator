package model.translator;

import model.Translator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class AlphaTranslatorTest
{
    /**
     * Test the empty and nullable parameters as special situations.
     */
    @Test
    public void testTranslateEmpty()
    {
        Translator translator = new AlphaTranslator();
        Assertions.assertEquals("", translator.translate(" "), "Translator does not trim empty spaces");
        Assertions.assertEquals("", translator.translate(null), "translator does not convert null to empty string");
    }
    
    /**
     * Test whole words translations.
     * 
     * @param alpha the expected result
     * @param morse code to translate
     */
    @ParameterizedTest
    @CsvSource(value = {
        "alamakota, .- .-.. .- -- .- -.- --- - .- ",
        "mamybardzoduzoslow, -- .- -- -.-- -... .- .-. -.. --.. --- -.. ..- --.. --- ... .-.. --- .--"
    })
    public void testTranslateToMorceCode(String alpha, String morse)
    {
        Translator translator = new AlphaTranslator();
        Assertions.assertEquals(alpha, translator.translate(morse), "Invalid " + morse + " to " + alpha + " translation");
    }
    
    /**
     * Test that translator returns an ? character when it cannot find translation. 
     * 
     * @param character to translate
     */
    @ParameterizedTest
    @ValueSource(strings = {
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
        "!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
        "_", "+", "=", "`", "~", ";", ":", "\"", "\'",
        "{", "[", "]", "}", "|", "\\", ",", "<", ">",
        "?", "/"
    })
    public void testTranslateNotExsistingCharacter(String character)
    {
        Translator translator = new AlphaTranslator();
        Assertions.assertEquals("?", translator.translate(character), "Given " + character + " should be \"?\"");
    }
}
