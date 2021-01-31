package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Shows box with error information
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class ErrorModal extends JOptionPane
{
    /**
     * Main frame on which modal should be presented.
     */
    private final JFrame frame;
    
    /**
     * Initializes ErrorModal.
     * 
     * @param frame main program JFrame.
     */
    public ErrorModal(JFrame frame)
    {
        this.frame = frame;
    }
    
    /**
     * Activates modal.
     * 
     * @param message String to display.
     */
    public void show(String message)
    {
        showMessageDialog(this.frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
