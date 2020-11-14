package model.translator;

import model.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslatorFactoryTest
{
    @Test
    public void testItCreatesTranslatorForString()
    {
        TranslatorFactory factory = new TranslatorFactory();
        
        try {
            Assertions.assertTrue(factory.create("morse") instanceof AlphaTranslator, "Should return AlphaTranslator");
            Assertions.assertTrue(factory.create("alpha") instanceof MorseTranslator, "Should return MorseTranslator");
        } catch (NotFoundException exception) {
            Assertions.fail("Translator not found");
        }
    }
    
    @Test
    public void testItThrowsException()
    {
        TranslatorFactory factory = new TranslatorFactory();
        NotFoundException exception = Assertions.assertThrows(
            NotFoundException.class,
            () -> factory.create("not specified")
        );
        Assertions.assertEquals("Translator of not specified type not found", exception.getMessage());
    }
}
