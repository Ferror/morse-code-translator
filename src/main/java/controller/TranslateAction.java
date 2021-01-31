package controller;

import view.TranslatorSelect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import model.TranslatorException;
import model.translator.TranslatorFactory;
import view.ErrorModal;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslateAction implements ActionListener
{
    /**
     * TranslatorFactory that creates Translator from selected string.
     */
    private final TranslatorFactory factory;
    
    /**
     * Area where user provide input message to translate.
     */
    private final JTextArea input;
    
    /**
     * Area where user will see translation result.
     */
    private final JTextArea output;
    
    /**
     * Select element where user chooses translator.
     */
    private final TranslatorSelect select;
    
    /**
     * Modal to show in case of exception incident.
     */
    private final ErrorModal modal;
    
    /**
     * Creates action that implements ActionListener interface to run it in event.
     * 
     * @param factory to create Translator.
     * @param input GUI element that user provided.
     * @param output GUI element where to write result.
     * @param select GUI element to choose Translator.
     * @param modal to show in case of incident.
     */
    public TranslateAction(
        TranslatorFactory factory,
        JTextArea input,
        JTextArea output,
        TranslatorSelect select,
        ErrorModal modal
    ) {
        this.factory = factory;
        this.input = input;
        this.output = output;
        this.select = select;
        this.modal = modal;
    }
    
    /**
     * Chooses the translator selected by user and runs translation of a message
     * that user provided, and writes the result to the other text area output.
     * 
     * In case of translation error will show ErrorModal and clear input/output.
     * 
     * @param e event that occurs on element 
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String textToTranslate = this.input.getText();
        String translatorName = this.select.getSelectedItem().toString().toLowerCase();
        
        try {
            String translatedMessage = this.factory.create(translatorName).translate(textToTranslate);
            this.output.setText(translatedMessage);
            
            if (translatedMessage.contains("?")) {
                this.modal.show("Some of the characters were invalid. We changed it to \"?\"");
            }
        } catch (TranslatorException exception) {
            this.modal.show(exception.getMessage());
            this.select.setSelectedIndex(0);
            this.output.setText("");
            this.input.setText("");
        }
    }
}
