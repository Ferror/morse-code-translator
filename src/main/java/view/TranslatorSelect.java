package view;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.TranslatorTypeStorage;

/**
 * GUI element to choose translator.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class TranslatorSelect extends JComboBox<String>
{
    /**
     * Initializes ComboBox GUI element with available translators.
     *
     * @param storage that stores available translator names.
     */
    public TranslatorSelect(TranslatorTypeStorage storage)
    {
        this.setModel(new DefaultComboBoxModel<>(storage.getAvailableTranslators()));
    }
}
