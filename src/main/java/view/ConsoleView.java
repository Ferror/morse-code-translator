package view;

/**
 * Responsible for presenting encoring messages to the user.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class ConsoleView
{
    /**
     * Present message to encourage user to provide message type.
     */
    public void encourageToProvideMessageType()
    {
        System.out.println("Enter message type (morse/alpha): ");
    }
    
    /**
     * Present message to encourage user to provide message content.
     */
    public void encourageToProvideMessage()
    {
        System.out.println("Enter message: ");
    }
}
