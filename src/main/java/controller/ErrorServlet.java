package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import view.ExceptionResponse;

/**
 * Handles database exceptions.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
@WebServlet(value = "/error")
public class ErrorServlet extends HttpServlet
{
    /**
     * Handles the ALL methods to present error page.
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
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        
        out.println(new ExceptionResponse("Database error - check logs!"));
    }
}
