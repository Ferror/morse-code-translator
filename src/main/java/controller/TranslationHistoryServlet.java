package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.history.MemoryTranslationHistory;
import view.ExceptionResponse;
import view.TranslationHistoryResponse;

/**
 * Handles translation history.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.2
 */
@WebServlet(value = "/history")
public class TranslationHistoryServlet extends HttpServlet
{
    /**
     * History in memory.
     */
    private MemoryTranslationHistory history;
    
    /**
     * Date format that is stored in cookie.
     */
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    
    /**
     * Handles the GET method and present translation history.
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
                    this.dateFormat.parse(
                        this.getCookie(request, response).getValue()
                    )
                )
            );
        } catch (ParseException exception) {
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
        
        this.history = (MemoryTranslationHistory) session.getAttribute("history");
    }
    
    /**
     * Looks for a cookie in request, but if it not exists then creates one.
     * 
     * @param request the servlet handles.
     * @param response the servlet returns.
     *
     * @return the cookie which tells when user seen the history.
     */
    private Cookie getCookie(HttpServletRequest request, HttpServletResponse response)
    {
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        
        try {
            //findFirst() throws NullPointerException when filtered value not exists.
            //get() throws NoSuchElementException when element has no value.
            return cookies.stream()
                .filter((item) -> item.getName().equals("last-seen"))
                .findFirst()
                .get();
        } catch (NullPointerException | NoSuchElementException exception) {
            Cookie cookie = new Cookie("last-seen", this.dateFormat.format(new Date()));
            response.addCookie(cookie);
            
            return cookie;
        }
    }
}
