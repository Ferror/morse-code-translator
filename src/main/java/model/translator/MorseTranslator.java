package model.translator;

import model.Dictionary;
import model.Translator;
import model.TranslatorException;

/**
 * Morse's code translator.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
public class MorseTranslator implements Translator
{
    /**
     * Translates given message to Morse's code.
     * 
     * {@inheritDoc}
     */
    @Override
    public String translate(String code)
    {
        if (code == null) {
            return "";
        }
        
        Dictionary dictionary = new Dictionary();
        String translated = new String();
        code = code.replaceAll("\\s+", "");
        
        for (int i = 0; i < code.length(); i++) {
            try {
                translated += dictionary.find(code.substring(i, i + 1).toLowerCase()).getMorse();
            } catch (TranslatorException exception) {
                translated += "?";
            }
            
            if (i < code.length()) {
                translated += " ";
            }
        }

        return translated;
    }    
}
