package controller;

import java.util.Scanner;
import model.translator.TranslatorFactory;
import view.ResultPresenter;

/**
 * The main program class. Contains MAIN method.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class MainController
{
    /**
     * <h1>Console Controller Description</h1>
     * 
     * If you use console execution then you should pass more than two parameters:
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
     * by default you will be able to pass this arguments via terminal.
     */
    public static void main(String[] args)
    {
        TranslatorFactory factory = new TranslatorFactory();
        ResultPresenter result;
                
        if (args.length > 2) {
            ProgramArgumentsController controller = new ProgramArgumentsController(factory);
            
            result = controller.handle(args);
        } else {
            ConsoleController controller = new ConsoleController(factory, new Scanner(System.in));
            
            result = controller.handle();
        }
        
        result.present();
    }
}
