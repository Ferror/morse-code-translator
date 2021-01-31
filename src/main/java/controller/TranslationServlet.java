package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TranslatorException;
import model.history.MemoryTranslationHistory;
import model.history.TranslationEntity;
import model.history.TranslationHistoryException;
import model.translator.TranslatorFactory;
import view.ExceptionResponse;
import view.TranslatedMessageResponse;

/**
 * Handles translations.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
@WebServlet(value = "/translate")
public class TranslationServlet extends HttpServlet
{
    /**
     * Creates translator from provided data.
     */
    private TranslatorFactory factory;
    
    /**
     * Translation history in memory.
     */
    private MemoryTranslationHistory memoryHistory;
    
    /**
     * Translation history in database.
     */
    private DatabaseTranslationHistory databaseHistory;
    
    /**
     * Handles every HTTP method that comes to /translate.
     * 
     * Requires parameters:
     * 1. message - string to translate
     * 2. translator - the type: morse or alpha
     * 
     * @param request to handle.
     * @param response the servlet generates.
     * 
     * @throws ServletException from servlet API.
     * @throws IOException from servlet API.
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.initlizeSesion(request);
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        String messageParameter = request.getParameter("message");
        
        try {
            String translatedMessage = this.factory
                .create(request.getParameter("translator"))
                .translate(messageParameter);

            TranslationEntity entity = new TranslationEntity(messageParameter, translatedMessage, new Date());
            
            this.databaseHistory.add(entity);
            this.memoryHistory.add(entity);
            out.println(new TranslatedMessageResponse(translatedMessage));
        } catch (TranslatorException|TranslationHistoryException exception) {
            out.println(new ExceptionResponse(exception));
        }
    }
    
    /**
     * Initializes translation history and factory from session or creates one.
     * 
     * @param request the servlet handles.
     */
    private void initlizeSesion(HttpServletRequest request)
    {
        SessionDependency dependency = new SessionDependency(request);
        HttpSession session = dependency.initialize();
        
        this.memoryHistory = (MemoryTranslationHistory) session.getAttribute("history");
        this.databaseHistory = (DatabaseTranslationHistory) session.getAttribute("history.database");
        this.factory = (TranslatorFactory) session.getAttribute("factory");
    }
}
