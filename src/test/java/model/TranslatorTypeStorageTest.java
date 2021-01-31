package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslatorTypeStorageTest
{
    /**
     * Test whether available translators are only those used in app.
     */
    @Test
    public void testItGetsAvailableTranslatorNames()
    {
        TranslatorTypeStorage storage = new TranslatorTypeStorage();
        
        Assertions.assertArrayEquals(new String[]{"morse", "alpha"}, storage.getAvailableTranslators(), "The available translators changed!");
    }
    
    /**
     * Test if for provided string there is an associated translator.
     */
    @Test
    public void testItIsSatisfiedBy()
    {
        TranslatorTypeStorage storage = new TranslatorTypeStorage();
        
        Assertions.assertTrue(storage.isSatisfiedBy("morse"));
        Assertions.assertTrue(storage.isSatisfiedBy("alpha"));
        Assertions.assertFalse(storage.isSatisfiedBy(""));
        Assertions.assertFalse(storage.isSatisfiedBy(null));
        Assertions.assertFalse(storage.isSatisfiedBy("not-exist"));
    }
}
