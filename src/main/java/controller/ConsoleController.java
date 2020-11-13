package controller;

import java.util.Scanner;
import model.NotFoundException;
import model.translator.TranslatorFactory;
import view.ConsoleView;
import view.ResultPresenter;

/**
 * Controller that handles user input arguments.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class ConsoleController
{
    /**
     * Factory required to create translator from given user message type.
     */
    private final TranslatorFactory factory;
    
    /**
     * Scanner required to get data from user.
     */
    private final Scanner scanner;
    
    /**
     * Creates the console controller instance.
     * 
     * @param factory to create translator instance.
     * @param scanner to get user parameters.
     */
    public ConsoleController(TranslatorFactory factory, Scanner scanner)
    {
        this.factory = factory;
        this.scanner = scanner;
    }
    
    /**
     * Gets message content and type from user and generate the result.
     * 
     * @return ResultPresenter instance with translated message or error message.
     */
    public ResultPresenter handle()
    {
        ConsoleView view = new ConsoleView();
        view.encourageToProvideMessageType();
        String type = this.scanner.nextLine();
        view.encourageToProvideMessage();
        String message = this.scanner.nextLine();

        try {
            return new ResultPresenter(type, this.factory.create(type).translate(message));
        } catch (NotFoundException e) {
            return new ResultPresenter(e.getMessage());
        }
    }
}
