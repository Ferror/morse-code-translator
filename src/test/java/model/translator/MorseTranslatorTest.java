package model.translator;

import model.Translator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class MorseTranslatorTest
{
    @ParameterizedTest
    @CsvSource(value = {
        "a, .-",
        "b, -...",
        "c, -.-.",
        "d, -..",
        "e, .",
        "f, ..-."
    })
    public void testTranslateToMorceCode(String alpha, String morse)
    {
        Translator translator = new MorseTranslator();
        Assertions.assertEquals(morse + " ", translator.translate(alpha), "Invalid " + alpha + " to " + morse + " translation");
    }
}
