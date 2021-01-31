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
import view.ExceptionResponse;
import view.TranslationHistoryResponse;

/**
 * Handles translation history in database.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
@WebServlet(value = "/history-database")
public class DatabaseTranslationHistoryServlet extends HttpServlet
{
    /**
     * History in database.
     */
    private DatabaseTranslationHistory history;
    
    /**
     * Handles the GET method and present translation history from database.
     * 
     * @param request to handle.
     * @param response the result.
     *
     * @throws ServletException from servlet API.
     * @throws IOException from servlet API.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.initlizeSesion(request);
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        
        try {
            out.println(
                new TranslationHistoryResponse(
                    this.history,
                    new Date()
                )
            );
        } catch (Exception exception) {
            out.println(new ExceptionResponse(exception));
        }
    }
    
    /**
     * Handles the POST method and present translation history.
     * Due to specification where GET and POST should be handled the same.
     * 
     * @param request to handle.
     * @param response the result.
     *
     * @throws ServletException from servlet API.
     * @throws IOException from servlet API.
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
    
    /**
     * Initializes translation history from session or creates one.
     * 
     * @param request the servlet handles.
     */
    private void initlizeSesion(HttpServletRequest request)
    {
        SessionDependency dependency = new SessionDependency(request);
        HttpSession session = dependency.initialize();
        
        this.history = (DatabaseTranslationHistory) session.getAttribute("history.database");
    }
}
