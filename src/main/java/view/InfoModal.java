package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class InfoModal extends JOptionPane
{
    /**
     * Main frame on which modal should be presented.
     */
    private final JFrame frame;
    
    /**
     * Initializes InfoModal.
     * 
     * @param frame main program JFrame.
     */
    public InfoModal(JFrame frame)
    {
        this.frame = frame;
    }
    
    /**
     * Activates modal with information.
     * 
     * @param message String to display.
     */
    public void show(String message)
    {
        showMessageDialog(this.frame, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
