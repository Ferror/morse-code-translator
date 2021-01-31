package model.history;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class MemoryTranslationHistoryTest
{
    @Test
    public void testItAddsTranslationToHistory()
    {
        MemoryTranslationHistory history = new MemoryTranslationHistory();
        
        Assertions.assertEquals(0, history.getHistory().size());
        
        try {
            history.add(new TranslationEntity("original", "translated", new Date()));
        } catch (TranslationHistoryException exception) {
            Assertions.fail(exception.getMessage());
        }
        
        Assertions.assertEquals(1, history.getHistory().size());
        
        history.add(null);
        
        Assertions.assertEquals(1, history.getHistory().size());
    }
    
    @Test
    public void testItGetsHistory()
    {
        MemoryTranslationHistory history = new MemoryTranslationHistory();
        
        Assertions.assertIterableEquals(new ArrayList(), history.getHistory());
    }
}
