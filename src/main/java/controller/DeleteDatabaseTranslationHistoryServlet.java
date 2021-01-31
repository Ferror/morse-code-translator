package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import view.ExceptionResponse;

/**
 * Handles removing translation history from database.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
@WebServlet(value = "/history-database/delete")
public class DeleteDatabaseTranslationHistoryServlet extends HttpServlet
{
    /**
     * History in database.
     */
    private DatabaseTranslationHistory history;
    
    /**
     * Handles the GET and POST method to delete translation history from database.
     * 
     * @param request to handle.
     * @param response the result.
     *
     * @throws ServletException from servlet API.
     * @throws IOException from servlet API.
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.initlizeSesion(request);
        
        try {
            this.history.remove(this.getTranslationIdentifier(request));
            
            response.sendRedirect("/MorseCodeTranslator/history-database");
        } catch (NumberFormatException exception) {
            response.setContentType("text/html; charset=ISO-8859-2");
            PrintWriter out = response.getWriter();
            out.println(new ExceptionResponse("Invalid translation identifier"));
        }
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
    
    /**
     * @param request
     * @return 
     */
    private int getTranslationIdentifier(HttpServletRequest request)
    {
        return Integer.parseInt(request.getParameter("id"));
    }
}
