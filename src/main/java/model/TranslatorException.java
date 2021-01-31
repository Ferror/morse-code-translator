package model;

/**
 * Represents state where something was not found in the program.
 * Like translation, translator or letter.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslatorException extends Exception
{
    /**
     * Generic constructor used to create TranslatorException
     * 
     * @param message that will be presented to the user
     */
    public TranslatorException(String message)
    {
        super(message);
    }
}
