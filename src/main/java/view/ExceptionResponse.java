package view;

/**
 * Represents HTML exception messages.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class ExceptionResponse
{
    /**
     * Message for user.
     */
    private final String message;
    
    /**
     * Builds HTML view.
     */
    private final StringBuilder builder;
    
    /**
     * Creates response from exception object.
     * 
     * @param exception to get message from.
     */
    public ExceptionResponse(Exception exception)
    {
        this.message = exception.getMessage();
        this.builder = new StringBuilder();
    }
    
    /**
     * Creates response from message.
     * 
     * @param message the message.
     */
    public ExceptionResponse(String message)
    {
        this.message = message;
        this.builder = new StringBuilder();
    }
    
    /**
     * Build proper HTML page.
     * 
     * @return HTML string.
     */
    @Override
    public String toString()
    {
        this.builder
            .append("<!DOCTYPE html>")
            .append("<html>")
            .append("<head>")
            .append("<link rel=\"stylesheet\" href=\"/MorseCodeTranslator/master.css\" />")
            .append("</head>")
            .append("<body>")
            .append("<h1>Could not perform action :(</h1>")
            .append("<h3>Message: ")
            .append(this.message)
            .append("</h3>")
            .append("<nav>")
            .append("<a href=\"/MorseCodeTranslator\">Back to Translator</a>")
            .append("</nav>")
            .append("</body>")
            .append("</html>");
        
        return this.builder.toString();
    }
}
