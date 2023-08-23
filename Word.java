package Project5;
import java.util.regex.*;

//create a Word class
public class Word {
	//instance variables
	private String WordGiven;
	boolean validString;
	
	
	//constructor checks that the word is valid(has only letters) and throws an IllegalWordException if it is not
	public Word (String s) {
			if (isValidWord(s)) WordGiven= s;
			else 
				throw new IllegalWordException("invalid word:" + s);
	}

	/*
	 * isValidWord() checks if the word contains only alphabetical letters or 
	 * @author Professor Kenneth Lord
	 */
	public static boolean isValidWord(String s) {
		Pattern p;
		Matcher m;
		String S_PATTERN = "[a-zA-Z]+";
		p= Pattern.compile(S_PATTERN);
		m=p.matcher(s);
		return m.matches();
	}
	
	public void setWord(String s) {
		WordGiven = s;
	}
	
	public String getWord() {
		return WordGiven;
	}
	
	public int compareTo(Word other) {
			return WordGiven.compareToIgnoreCase(other.toString()); //ignore case
	}
	
	//TAKE OUT?
	public boolean equals(Object other) {
		return (other!=null 
				&& getClass()==other.getClass() 
				&& WordGiven.equalsIgnoreCase(((Word) other).WordGiven));
	}
	
	public String toString() {
		return WordGiven;
	}
}
