package model.history;

import java.util.List;

/**
 * Interface to translation history to later move functionality to database.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public interface TranslationHistory
{
    /**
     * Adds translation to history.
     *
     * @param translation to add to collection.
     */
    public void add(TranslationEntity translation);
    
    /**
     * Gets translation history entries.
     * 
     * @return translation history
     */
    public List<TranslationEntity> getHistory();
}
