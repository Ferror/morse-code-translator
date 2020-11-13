package model.translator;

import model.Dictionary;
import model.Translator;

/**
 * Latin alphabet translator.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class AlphaTranslator implements Translator
{
    /**
     * Translates given message to Latin alphabet.
     * 
     * {@inheritDoc}
     */
    @Override
    public String translate(String code)
    {
        Dictionary dictionary = new Dictionary();
        String translated = new String();
        
        String[] characters = code.split("\\s+");
        
        for (String symbol : characters) {
            translated += dictionary.find(symbol).getAlpha();
        }

        return translated;
    }
}
