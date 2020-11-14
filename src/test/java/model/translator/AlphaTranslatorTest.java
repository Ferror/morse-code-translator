package model.translator;

import model.Translator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class AlphaTranslatorTest
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
        Translator translator = new AlphaTranslator();
        Assertions.assertEquals(alpha, translator.translate(morse), "Invalid " + morse + " to " + alpha + " translation");
    }
}
