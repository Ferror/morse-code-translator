package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.history.MemoryTranslationHistory;
import model.translator.TranslatorFactory;

/**
 * Dependency Injection based on HTTP Session.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class SessionDependency
{
    /**
     * Request to get session info.
     */
    private final HttpServletRequest request;
    
    /**
     * Creates Dependency from request session.
     * 
     * @param request required to init session.
     */
    public SessionDependency(HttpServletRequest request)
    {
        this.request = request;
    }
    
    /**
     * Initialize session with services used globally. It might be anti-pattern,
     * but solves problem with a lot of copy-paste code and improves every other request.
     * 
     * @return initialized with dependencies session.
     */
    public HttpSession initialize()
    {
        HttpSession session = this.request.getSession(false);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("morse-code-translator");
        
        if (session == null) {
            EntityManager em = emf.createEntityManager();
            
            session = this.request.getSession(true);
            session.setAttribute("history", new MemoryTranslationHistory());
            session.setAttribute("factory", new TranslatorFactory());
            session.setAttribute("emf", emf);
            session.setAttribute("em", em);
            session.setAttribute("history.database", new DatabaseTranslationHistory(em));
        } else {
            if (session.getAttribute("history") == null) {
                session.setAttribute("history", new MemoryTranslationHistory());
            }
            
            if (session.getAttribute("factory") == null) {
                session.setAttribute("factory", new TranslatorFactory());
            }
            
            if (session.getAttribute("emf") == null) {
                session.setAttribute("emf", emf);
            }
            
            if (session.getAttribute("em") == null) {
                session.setAttribute("em", emf.createEntityManager());
            }
            
            if (session.getAttribute("history.database") == null) {
                session.setAttribute("history.database", new DatabaseTranslationHistory(emf.createEntityManager()));
            }
        }
        
        return session;
    }
}
