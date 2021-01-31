package model;

import java.util.function.Function;

/**
 * Translator Lambda Function.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
public class TranslatorFunction implements Function<String, String>
{
    /**
     * Dictionary which will be base for translations.
     */
    private final Dictionary dictionary;
    
    /**
     * Creates Lambda expression instance of translation.
     * 
     * @param dictionary that holds definitions of domain.
     */
    public TranslatorFunction(Dictionary dictionary)
    {
        this.dictionary = dictionary;
    }
    
    /**
     * Automatically triggered function by Lambda Expression. 
     * 
     * @param arg0 String that we will be looking for in dictionary.
     * @return alpha translated character.
     */
    @Override
    public String apply(String arg0)
    {
        try {
            return this.dictionary.find(arg0).getAlpha();
        } catch (TranslatorException exception) {
            return "?";
        }
    }
}
