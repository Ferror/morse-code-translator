package view;

import controller.DatabaseTranslationHistory;
import java.util.Date;
import model.history.TranslationHistory;
import model.history.TranslationEntity;

/**
 * Represents HTML user's translation history.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslationHistoryResponse
{
    /**
     * Builds HTML view.
     */
    private final StringBuilder builder;
    
    /**
     * History in memory.
     */
    private final TranslationHistory history;
    
    /**
     * Date of a last seen page.
     */
    private final Date date;
    
    /**
     * @param history the translation history.
     * @param date when user had seen history.
     */
    public TranslationHistoryResponse(TranslationHistory history, Date date)
    {
        this.builder = new StringBuilder();
        this.history = history;
        this.date = date;
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
            .append("<h1>Translation History</h1>")
            .append("<table>")
            .append("<thead>")
            .append("<tr>")
            .append("<th>Seen</th>")
            .append("<th>Message</th>")
            .append("<th>Translation</th>")
            .append("<th>Created At</th>")
            .append("<th>Action</th>")
            .append("</tr>")
            .append("</thead>")
            .append("<tbody>");
        
        if (this.history instanceof DatabaseTranslationHistory) {
            this.history
                .getHistory()
                .forEach((TranslationEntity message) -> {
                    this.builder
                        .append("<tr>")
                        .append("<td>")
                        .append(this.date.after(message.getCreatedAt()) ? "Yes" : "No")
                        .append("</td><td>")
                        .append(message.getOriginalMessage())
                        .append("</td><td>")
                        .append(message.getTranslatedMessage())
                        .append("</td><td>")
                        .append(message.getCreatedAt())
                        .append("</td><td>")
                        .append("<a href=\"/MorseCodeTranslator/history-database/delete?id=")
                        .append(message.getId())
                        .append("\">delete</a>")
                        .append("</td>")
                        .append("</tr>");
                });
        } else {
            this.history
                .getHistory()
                .forEach((TranslationEntity message) -> {
                    this.builder
                        .append("<tr>")
                        .append("<td>")
                        .append(this.date.after(message.getCreatedAt()) ? "Yes" : "No")
                        .append("</td><td>")
                        .append(message.getOriginalMessage())
                        .append("</td><td>")
                        .append(message.getTranslatedMessage())
                        .append("</td><td>")
                        .append(message.getCreatedAt())
                        .append("</td><td>")
                        .append("None")
                        .append("</td>")
                        .append("</tr>");
                });
        }
            
        this.builder.append("</tbody>")
            .append("</table>")
            .append("<nav>")
            .append("<a href=\"/MorseCodeTranslator\">Back to Translator</a>")
            .append("</nav>")
            .append("</body>")
            .append("</html>");
        
        return this.builder.toString();
    }
}
