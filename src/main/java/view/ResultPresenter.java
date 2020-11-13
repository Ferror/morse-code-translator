package view;

/**
 * Representation of program result.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class ResultPresenter
{
    /**
     * Given message type.
     */
    private final String type;
    
    /**
     * Given message content.
     */
    private final String message;
    
    /**
     * Presents message as error.
     * 
     * @param message the error information for user.
     */
    public ResultPresenter(String message)
    {
        this.type = "";
        this.message = message;
    }
    
    /**
     * Default successful result constructor.
     * 
     * @param type of a message that was translated.
     * @param message translated to Morse's code or Latin alphabet.
     */
    public ResultPresenter(String type, String message)
    {
        this.type = type;
        this.message = message;
    }
    
    /**
     * Present error or translated message
     * 
     * ex.
     * <br>
     * Error occurred: Translator not found
     * <br>
     * Translated from alpha as: ... --- ...
     */
    public void present()
    {
        if (this.type.isBlank()) {
            System.out.println("Error occurred: " + this.message);
        } else {
            System.out.println("Translated from " + this.type + " as: " + this.message);
        }
    }
}
