package model.history;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslationTest
{
    @Test
    public void testItIsHistory()
    {
        try {
            TranslationEntity translation = new TranslationEntity("a", "b", new Date());
            
            Assertions.assertEquals("a", translation.getOriginalMessage(), "Invalid original value");
            Assertions.assertEquals("b", translation.getTranslatedMessage(), "Invalid translated value");
        } catch (TranslationHistoryException exception) {
            Assertions.fail(exception.getMessage());
        }
        
        TranslationHistoryException exception = Assertions.assertThrows(TranslationHistoryException.class,
            () -> {
                new TranslationEntity(null, "b", new Date());
                new TranslationEntity("a", null, new Date());
                new TranslationEntity("a", "b", null);
            }
        );
        Assertions.assertEquals("Nor value must be nullable", exception.getMessage(), "Expected different exception message");
    }
}
