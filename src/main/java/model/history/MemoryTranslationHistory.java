package model.history;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores translation history in memory.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class MemoryTranslationHistory implements TranslationHistory
{
    /**
     * Collection of translations.
     */
    private final List<TranslationEntity> history;
    
    /**
     * Initializes empty translation history.
     */
    public MemoryTranslationHistory()
    {
        this.history = new ArrayList<>();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(TranslationEntity translation)
    {
        if (translation != null) {
            this.history.add(translation);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TranslationEntity> getHistory()
    {
        return this.history;
    }
}
