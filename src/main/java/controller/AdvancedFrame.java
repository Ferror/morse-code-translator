package controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import model.Dictionary;
import model.TranslatorTypeStorage;
import model.translator.TranslatorFactory;
import view.DictionaryTable;
import view.DictionaryTableScroll;
import view.ErrorModal;
import view.InfoModal;
import view.LayoutGenerator;
import view.TranslatorSelect;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class AdvancedFrame extends JFrame
{
    /**
     * Aggregates all styles and positions of layout.
     */
    private final LayoutGenerator generator;
    
    /**
     * Stores information about available translators.
     */
    private TranslatorTypeStorage storage;
    
    /**
     * Button that is responsible for triggering translation execution.
     */
    private final JButton translateActionSubmitButton;
    
    /**
     * Label that tells user to choose translator.
     */
    private final JLabel translatorSelectLabel;
    
    /**
     * GUI element that enables user to choose translator.
     */
    private final TranslatorSelect translatorSelect;
    
    /**
     * Label that tells user to provide message to translate.
     */
    private final JLabel userInputAreaLabel;
    
    /**
     * GUI element that makes userInputArea scrollable when user provide longer message.
     */
    private final JScrollPane userInputAreaScroll;
    
    /**
     * GUI element where user provides message content.
     */
    private final JTextArea userInputArea;
    
    /**
     * Label that tells user where the translation result is.
     */
    private final JLabel userOutputAreaLabel;
    
    /**
     * GUI element that makes userOutputArea scrollable when user provide longer message.
     */
    private final JScrollPane userOutputAreaScroll;
    
    /**
     * GUI element where translated message appears.
     */
    private final JTextArea userOutputArea;
    
    /**
     * Main panel where whole translation GUI is placed.
     */
    private final JPanel translatorFormPanel;
    
    /**
     * GUI element that makes tabs.
     */
    private final JTabbedPane mainTabPanel;
    
    /**
     * Creates and initializes the GUI elements. It's the main program frame.
     * 
     * @param generator to generate layout
     * @param storage to provide available translations
     */
    public AdvancedFrame(LayoutGenerator generator, TranslatorTypeStorage storage)
    {
        this.generator = generator;
        this.storage = storage;
        this.translateActionSubmitButton = new JButton("Translate");        
        
        this.mainTabPanel = new JTabbedPane();
        this.translatorFormPanel = new JPanel();
        
        this.userInputArea = new JTextArea(3, 20);
        this.userInputAreaScroll = new JScrollPane();
        this.userInputAreaScroll.setViewportView(this.userInputArea);
        this.userInputAreaLabel = new JLabel("Write your message");
        
        this.translatorSelect = new TranslatorSelect(storage);
        this.translatorSelectLabel = new JLabel("Select dictionary");
        
        this.userOutputArea = new JTextArea(3, 20);
        this.userOutputArea.setEditable(false);
        this.userOutputAreaScroll = new JScrollPane();
        this.userOutputAreaScroll.setViewportView(this.userOutputArea);
        this.userOutputAreaLabel = new JLabel("Your translated message");
     
        this.loadFormTab();
        this.loadTableTab();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.pack();
    }
    
    /**
     * The secondary constructor that creates and initializes the GUI elements.
     * It's the main program frame, but with provided arguments will choose translator
     * and fill up the text area.
     * 
     * @param generator to generate layout
     * @param storage to provide available translations
     * @param args program execution arguments
     */
    public AdvancedFrame(LayoutGenerator generator, TranslatorTypeStorage storage, List<String> args)
    {
        this(generator, storage);
        
        if (!storage.isSatisfiedBy(args.get(0))) {
            InfoModal modal = new InfoModal(this);
            
            modal.show("Invalid translator type. Set it to alpha.");
            this.translatorSelect.setSelectedItem("alpha");
        } else {
            this.translatorSelect.setSelectedItem(args.get(0));
        }
        
        this.userInputArea.setText(
            args
                .subList(1, args.size())
                .stream()
                .map(arg -> arg + " ")
                .reduce(new String(), String::concat)
        );
    }
    
    /**
     * Generates and initializes the translation form tab.
     */
    private void loadFormTab()
    {
        this.translateActionSubmitButton.addActionListener(
            new TranslateAction(
                new TranslatorFactory(),
                this.userInputArea,
                this.userOutputArea,
                this.translatorSelect,
                new ErrorModal(this)
            )
        );
        this.mainTabPanel.addTab("Translator", this.translatorFormPanel);
        this.translatorFormPanel.setLayout(
            this.generator.createTranslatorTab(
                this.translatorFormPanel,
                this.userInputArea,
                this.userInputAreaLabel,
                this.userInputAreaScroll,
                this.userOutputArea,
                this.userOutputAreaLabel,
                this.userOutputAreaScroll,
                this.translatorSelectLabel,
                this.translatorSelect,
                this.translateActionSubmitButton
            )
        );
    }
    
    /**
     * Generates and initializes the tab with dictionary table.
     */
    private void loadTableTab()
    {        
        this.mainTabPanel.addTab(
            "Dictionary",
            new DictionaryTableScroll(
                new DictionaryTable(this.storage, new Dictionary())
            )
        );
        this.getContentPane().setLayout(
            this.generator.createTableTab(
                this.getContentPane(),
                this.mainTabPanel
            )
        );
    }
}
