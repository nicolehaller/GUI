package Project5;
 
import java.util.Comparator;

/*
 * WordComparator compares two word objects by converting then into strings and then using the compare methods available for strings
 * @author Professor Kenneth Lord
 */
public class WordComparator implements Comparator<Word>{
    public int compare(Word word1, Word word2) {
        //convert the two words to strings so we can use compareTo function which looks like (s1).compareTo(s2)
    	String stringWord1= word1.toString();
    	String stringWord2= word2.toString();
        return stringWord1.compareToIgnoreCase(stringWord2);
    }
}
