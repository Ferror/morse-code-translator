package model;

/**
 * Stores in memory information of available translators.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
public class TranslatorTypeStorage
{
    /**
     * Stores in memory translator names.
     */
    private final String[] translators;
    
    /**
     * Initializes in memory translator name storage.
     */
    public TranslatorTypeStorage()
    {
        this.translators = new String[]{"morse", "alpha"};
    }
    
    /**
     * Get available in program Translator names.
     * 
     * @return available to process translator names.
     */
    public String[] getAvailableTranslators()
    {
        return this.translators;
    }
    
    /**
     * Checks whether provided translator name exists in memory.
     * 
     * @param translator name to find.
     * @return Boolean value when provided name exists in memory.
     */
    public Boolean isSatisfiedBy(String translator)
    {
        if (translator == null) {
            return false;
        }
        
        for (String name : this.translators) {
            if (name.equals(translator)) {
                return true;
            }
        }
        
        return false;
    }
}
