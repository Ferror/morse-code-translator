package model.translator;

import model.Translator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class MorseTranslatorTest
{
    /**
     * Test special nullable and empty input.
     */
    @Test
    public void testTranslateEmpty()
    {
        Translator translator = new MorseTranslator();
        Assertions.assertEquals("", translator.translate(" "), "Translator does not trim empty spaces");
        Assertions.assertEquals("", translator.translate(null), "translator does not convert null to empty string");
    }
    
    /**
     * Test capital letters and full words with spaces and without.
     * 
     * @param alpha the input to translate
     * @param morse the expected result
     */
    @ParameterizedTest
    @CsvSource(value = {
        "A, .-",
        "B, -...",
        "C, -.-.",
        "D, -..",
        "E, .",
        "F, ..-.",
        "G, --.",
        "H, ....",
        "I, ..",
        "J, .---",
        "K, -.-",
        "L, .-..",
        "M, --",
        "N, -.",
        "O, ---",
        "P, .--.",
        "Q, --.-",
        "R, .-.",
        "S, ...",
        "T, -",
        "U, ..-",
        "V, ...-",
        "W, .--",
        "X, -..-",
        "Y, -.--",
        "Z, --..",
        "alamakota, .- .-.. .- -- .- -.- --- - .- ",
        "ALamAKoTa, .- .-.. .- -- .- -.- --- - .- ",
        "ala ma kota, .- .-.. .- -- .- -.- --- - .- ",
        "ALa mA KoTa, .- .-.. .- -- .- -.- --- - .- "
    })
    public void testTranslateToMorceCode(String alpha, String morse)
    {
        Translator translator = new MorseTranslator();
        Assertions.assertEquals(morse + " ", translator.translate(alpha), "Invalid " + alpha + " to " + morse + " translation");
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
        Translator translator = new MorseTranslator();
        Assertions.assertEquals("? ", translator.translate(character), "Given " + character + " should be \"?\"");
    }
}
