package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Dictionary;
import model.TranslatorTypeStorage;

/**
 * Table that presents dictionary.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
public class DictionaryTable extends JTable
{
    /**
     * Initializes JTable with provided dictionary entries.
     *
     * @param storage to determine headers.
     * @param dictionary to provide table content.
     */
    public DictionaryTable(TranslatorTypeStorage storage, Dictionary dictionary)
    {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(storage.getAvailableTranslators());
        dictionary.getEntries().forEach(letter -> {
            model.addRow(new Object[] {letter.getMorse(), letter.getAlpha()});
        });
        
        this.setEnabled(false);
        this.setModel(model);
    }
}
