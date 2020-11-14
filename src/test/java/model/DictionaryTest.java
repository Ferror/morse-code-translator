package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class DictionaryTest
{
    @Test
    public void testFind()
    {
        Dictionary dictionary = new Dictionary();
        Assertions.assertTrue(dictionary.find("a").equals("a"));
    }
}
