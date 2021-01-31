package view;

import javax.swing.JScrollPane;

/**
 * GUI decorator for DictionaryTable to make it scrollable.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
public class DictionaryTableScroll extends JScrollPane
{
    /**
     * Makes DictionaryTable scrollable table.
     * 
     * @param table to make scrollable.
     */
    public DictionaryTableScroll(DictionaryTable table)
    {
        this.setViewportView(table);
    }
}
