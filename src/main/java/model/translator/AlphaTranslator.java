package model.translator;

import java.util.Arrays;
import java.util.List;
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
        List<String> characters = Arrays.asList(code.split("\\s+"));
        
        return characters
            .stream()
            .map(symbol -> dictionary.find(symbol).getAlpha())
            .reduce(translated, String::concat);
    }
}
