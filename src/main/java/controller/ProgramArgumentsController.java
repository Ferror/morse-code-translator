package controller;

import java.util.List;
import model.NotFoundException;
import model.Translator;
import model.translator.TranslatorFactory;
import view.ResultPresenter;

/**
 * Controller that handles execution arguments.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class ProgramArgumentsController
{
    /**
     * Factory required to create translator from given user message type.
     */
    private final TranslatorFactory factory;
    
    /**
     * Initialize controller that will handle translation from the execution
     * arguments.
     * 
     * @param factory that will provide translator for given message type.
     */
    public ProgramArgumentsController(TranslatorFactory factory)
    {
        this.factory = factory;
    }
    
    /**
     * Will translate the message for given program arguments or return error
     * presenter.
     * 
     * @param args list of arguments the program is executed with.
     * @return ResultPresenter that will present the translated message or an
     * error message.
     */
    public ResultPresenter handle(List args)
    {
        try {
            Translator translator = this.factory.create((String) args.get(0));
            String phrase = "";

            for (int i = 1; i < args.size(); i++) {
                phrase += translator.translate((String) args.get(i));
            }

            return new ResultPresenter((String) args.get(0), phrase);
        } catch (NotFoundException e) {
            return new ResultPresenter(e.getMessage());
        }
    }
}
