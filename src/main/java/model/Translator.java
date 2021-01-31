package model;

/**
 * Generic translator interface that will give opportunity to extend this program
 * with another possible translators.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public interface Translator
{
    /**
     * Translates given string to other depending on instance.
     * In case of invalid symbol it will present ? in it's place.
     * 
     * @param code to translate
     * @return translated code
     */
    public String translate(String code);
}
