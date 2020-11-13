package model.translator;

import model.NotFoundException;
import model.Translator;

/**
 * Chooses the translator for given message type.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslatorFactory
{
    /**
     * Creates translator depending on message type.
     * 
     * @param type of a message for which the translator should be created.
     * @return Translator instance depending on given type.
     * @throws NotFoundException when given type message is not handled.
     */
    public Translator create(String type) throws NotFoundException
    {
        if (type.equals("alpha")) {
            return new MorseTranslator();
        }

        if (type.equals("morse")) {
            return new AlphaTranslator();
        }
        
        throw new NotFoundException("Translator of " + type + " type not found");
    }
}
