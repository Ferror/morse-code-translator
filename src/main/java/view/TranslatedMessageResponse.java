package view;

/**
 * Presents HTML translated message.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslatedMessageResponse
{
    /**
     * Translated message.
     */
    private final String message;
    
    /**
     * Builds HTML view.
     */
    private final StringBuilder builder;
    
    /**
     * Create translated message response.
     * 
     * @param message that system translated.
     */
    public TranslatedMessageResponse(String message)
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
            .append("<body>");
        
        if (this.message.contains("?")) {
            this.builder
                .append("<h1>Some of the letters were unable to find :(</h1>")
                .append("<h3>Message: ")
                .append(this.message)
                .append("</h3>");
        } else if (this.message.isEmpty()) {
            this.builder.append("<h1>Message should not be empty :(</h1>");
        } else {
            this.builder
                .append("<h1>Translated message successfuly</h1>")
                .append("<h3>Message: ")
                .append(this.message)
                .append("</h3>");
        }
                    
        this.builder
            .append("<nav>")
            .append("<a href=\"/MorseCodeTranslator\">Back to Translator</a>")
            .append("</nav>")
            .append("</body>")
            .append("</html>");
        
        return this.builder.toString();
    }
}
