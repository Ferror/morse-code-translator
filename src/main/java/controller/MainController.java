package controller;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 2.0
 */
public class MainController
{
    /**
     * <h1>Graphic Controller Description</h1>
     * 
     * The program arguments if passed should be as presented below:
     * 
     * <ol>
     *     <li>The type of code you are passing</li>
     *     <li>The message that you want to translate</li>
     * </ol>
     * 
     * <h2>Example input parameters</h2>
     * <ul>
     *     <li>input: morse ... --- ...</li>
     *     <li>output: sos</li>
     * </ul>
     * <br>
     * <ul>
     *     <li>input: alpha s o s</li>
     *     <li>output: ... --- ...</li>
     * </ul>
     * <br>
     * <ul>
     *     <li>input: alpha sos</li>
     *     <li>output: ... --- ...</li>
     * </ul>
     * 
     * @param args program arguments.
     * 
     * First is described above in 1 point and every other argument will be treated
     * as message.
     * 
     * Available characters are presented in resource directory which contains
     * international dictionary image.
     * 
     * When you will define less than two parameters (just like in example) you
     * by default you will see GUI program where you will have to type arguments manually.
     */
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Application(args));
    }
}
