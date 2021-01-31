package controller;

import view.LayoutGenerator;
import java.util.Arrays;
import javax.swing.JFrame;
import model.TranslatorTypeStorage;

/**
 * Custom class that implements Runnable interface and decides whether load arguments.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class Application implements Runnable
{
    /**
     * Program execution arguments.
     */
    private final String[] args;
    
    /**
     * Constructs object with program arguments that are described in main execution class.
     * 
     * @param args execution arguments.
     */
    public Application(String[] args)
    {
        this.args = args;
    }
    
    /**
     * Implementation of Runnable interface which start whole GUI application.
     */
    @Override
    public void run()
    {
        JFrame view;
        
        if (this.args.length > 1) {
            view = new AdvancedFrame(
                new LayoutGenerator(),
                new TranslatorTypeStorage(),
                Arrays.asList(this.args)
            );
        } else {
            view = new AdvancedFrame(
                new LayoutGenerator(),
                new TranslatorTypeStorage()
            );
        }

        view.setVisible(true);
    }
}
