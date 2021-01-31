package model.translator;

import java.util.Arrays;
import java.util.List;
import model.Dictionary;
import model.Translator;
import model.TranslatorFunction;

/**
 * Latin alphabet translator.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.2
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
        if (code == null) {
            return "";
        }
        
        List<String> characters = Arrays.asList(code.split("\\s+"));
        
        return characters
            .stream()
            .map(new TranslatorFunction(new Dictionary()))
            .reduce(new String(), String::concat);
    }
}
