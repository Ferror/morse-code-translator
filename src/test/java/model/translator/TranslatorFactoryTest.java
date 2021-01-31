package model.translator;

import model.TranslatorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslatorFactoryTest
{
    /**
     * Tests that the Morse and Alpha translators are created by string.
     * Other cases will be tested below.
     */
    @Test
    public void testItCreatesTranslatorForString()
    {
        TranslatorFactory factory = new TranslatorFactory();
        
        try {
            Assertions.assertTrue(factory.create("morse") instanceof AlphaTranslator, "Should return AlphaTranslator");
            Assertions.assertTrue(factory.create("alpha") instanceof MorseTranslator, "Should return MorseTranslator");
        } catch (TranslatorException exception) {
            Assertions.fail("Translator not found");
        }
    }
    
    /**
     * Test for empty or invalid input in which the factory will throw exception.
     */
    @Test
    public void testItThrowsException()
    {
        TranslatorFactory factory = new TranslatorFactory();
        TranslatorException exception = Assertions.assertThrows(TranslatorException.class,
            () -> {
                factory.create("not specified");
            }
        );
        Assertions.assertEquals("Translator of not specified type not found", exception.getMessage(), "Expected different exception message");
        
        exception = Assertions.assertThrows(TranslatorException.class,
            () -> {
                factory.create(null);
            }
        );
        Assertions.assertEquals("Translator type cannot be null", exception.getMessage(), "Expected different exception message");
    }
}
