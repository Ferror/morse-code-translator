package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class stores the whole international alphabet translated to Morse's code.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class Dictionary
{
    /**
     * Collection of a letters
     */
    private final List<Letter> collection;
    
    /**
     * Dictionary constructor initialize the alphabet collection
     */
    public Dictionary()
    {
        this.collection = new ArrayList<>();
        
        this.collection.add(new Letter("a", ".-"));
        this.collection.add(new Letter("b", "-..."));
        this.collection.add(new Letter("c", "-.-."));
        this.collection.add(new Letter("d", "-.."));
        this.collection.add(new Letter("e", "."));
        this.collection.add(new Letter("f", "..-."));
        this.collection.add(new Letter("g", "--."));
        this.collection.add(new Letter("h", "...."));
        this.collection.add(new Letter("i", ".."));
        this.collection.add(new Letter("j", ".---"));
        this.collection.add(new Letter("k", "-.-"));
        this.collection.add(new Letter("l", ".-.."));
        this.collection.add(new Letter("m", "--"));
        this.collection.add(new Letter("n", "-."));
        this.collection.add(new Letter("o", "---"));
        this.collection.add(new Letter("p", ".--."));
        this.collection.add(new Letter("q", "--.-"));
        this.collection.add(new Letter("r", ".-."));
        this.collection.add(new Letter("s", "..."));
        this.collection.add(new Letter("t", "-"));
        this.collection.add(new Letter("u", "..-"));
        this.collection.add(new Letter("v", "...-"));
        this.collection.add(new Letter("w", ".--"));
        this.collection.add(new Letter("x", "-..-"));
        this.collection.add(new Letter("y", "-.--"));
        this.collection.add(new Letter("z", "--.."));
    }
    
    /**
     * Method finds Letter object for given search string. For example given "s"
     * will return Letter("s", "...")
     * 
     * @param search is a String of a letter that you want to find in the dictionary
     * @return the object of an instance Letter for given search letter.
     */
    public Letter find(String search)
    {
        List<Letter> result = this.collection
                .stream()
                .filter(letter -> letter.equals(search))
                .collect(Collectors.toList());
        
        return result.get(0);
    }
}
