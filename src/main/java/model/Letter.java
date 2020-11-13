package model;

/**
 * Representation of a morse and code corelation
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class Letter
{
    /**
     * Latin letter representation
     */
    private final String alpha;
    
    /**
     * Morse's code letter representation
     */
    private final String morse;
    
    /**
     * Creates Morse's code and Latin letter corelation
     * 
     * @param alpha Latin character
     * @param morse Morse's code
     */
    public Letter(String alpha, String morse)
    {
        this.alpha = alpha;
        this.morse = morse;
    }
    
    /**
     * Checks if given string matches morse or alpha representation
     * 
     * @param string for which representations are checked
     * @return the Boolean value if given parameter matches alpha or Morse's representation
     */
    public Boolean equals(String string)
    {
        return this.alpha.equals(string) || this.morse.equals(string);
    }
    
    /**
     * Gets Morse's code letter
     * 
     * @return the Morse's code value ex. ---
     */
    public String getMorse()
    {
        return this.morse;
    }
    
    /**
     * Gets Latin letter
     * 
     * @return the Latin letter value ex. s
     */
    public String getAlpha()
    {
        return this.alpha;
    }
}
