package Project5;

import javax.swing.*;
import java.util.NoSuchElementException.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.File;
import javax.swing.*;

public final class AisleGUI extends JFrame {
	  //JFrame variables
	  static JFrame myFrame;
	  static AisleGUI gui;
	  static Container cPane;
	  static public TextArea aisleOne, aisleTwo, aisleThree, aisleFour, aisleFive, aisleUnknown;
	   
	  //stringTokenizer variables
	  static StringTokenizer myTokens; //StringTokenizer is a predefined class in java as part of util package  
	  public static String line;
  
	   
	 //contructor of WordGUI that takes in file name that the user selected 
	 public AisleGUI(String chosenFileName) {
		 initialize();
		 readWordsFromFile(chosenFileName);
	 }
	 
	 //contructor of WordGUI that adds one word entered into the GUI .
	 public AisleGUI(String inputWord, int a) {
		 // reset all the boxes of the GUI so that it doesnt print the same words again 
		 aisleOne.setText("AISLE 1\n\n");
		 aisleTwo.setText("AISLE 2\n\n");
		 aisleThree.setText("AISLE 3\n\n");
		 aisleFour.setText("AISLE 4\n\n");
		 aisleFive.setText("AISLE 5\n\n");
		 aisleUnknown.setText("OUT OF STOCK:\n\n");
		 //after everything is cleared from first GUI, add the new word in
		 addWord(inputWord);
	 }
	 
	//initializes what the Aisles GUI looks like 
	public static void initialize() {	
	    myFrame = new JFrame(); 
	    myFrame.setSize(800,400);
		myFrame.setLocation(100,150); 
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set to close when click x
		myFrame.setVisible(true);
	}

    /* creates TreeMap called name which takes two Words: the keys are the word, and the values are null
     * TreeMap is sorted alphabetically by the WordComparator class
	  TreeMap is used to sort the foods alphabetically */ 
	static TreeMap <Word, Word> foodItems= new TreeMap<Word, Word>(new WordComparator());
	

	 // aisle HashMap maps foods to what aisles they are in in this store
	static HashMap<String, Integer> aisle = new HashMap<>();
    
	//insert your specific food and aisles into the HashMap
	public static void mapItemToAisle() {
		aisle.put("apple", 1);
	    aisle.put("banana", 1);
	    aisle.put("pear", 1);
	    aisle.put("cheese", 2);
	    aisle.put("yogurt", 2);
	    aisle.put("milk", 2);
	    aisle.put("egg", 2);
	    aisle.put("chicken", 3);
	    aisle.put("meat", 3);
	    aisle.put("turkey", 3);
	    aisle.put("deli", 3);
	    aisle.put("chocolate", 4);
	    aisle.put("twizzler", 4);
	    aisle.put("candy", 4);
	    aisle.put("donut", 4);
	    aisle.put("bread", 5);
	    aisle.put("muffin", 5);
	    aisle.put("cake", 5);
	}
	
	//takes words from file and adds them to the treemap which alphabetizes them
	public static void readWordsFromFile(String chosenFileName){ 
		   //creates GUI box layout which will contain 6 columns 
		   myFrame.setLayout(new GridLayout());
		   cPane = myFrame.getContentPane();
		   //sets TextAreas for the aisles
		   aisleOne = new TextArea(); 
		   aisleTwo = new TextArea();
		   aisleThree = new TextArea();
		   aisleFour = new TextArea();
		   aisleFive = new TextArea();
		   aisleUnknown = new TextArea();
		   
		   cPane.add(aisleOne); 
		   cPane.add(aisleTwo); 
		   cPane.add(aisleThree); 
		   cPane.add(aisleFour); 
		   cPane.add(aisleFive); 
		   cPane.add(aisleUnknown); 
		   
		   //set titles for each aisle 
		   aisleOne.append("AISLE 1\n\n");
		   aisleTwo.append("AISLE 2\n\n");
		   aisleThree.append("AISLE 3\n\n");
		   aisleFour.append("AISLE 4\n\n");
		   aisleFive.append("AISLE 5\n\n");
		   aisleUnknown.append("OUT OF STOCK:\n\n");
		   
		  TextFileInput tfi = new TextFileInput(chosenFileName);
		  
		  String line; 
	      line = tfi.readLine(); 
	      while (line!=null) { 
	    	  myTokens = new StringTokenizer(line," ,. "); //create a stringTokenizer that will separate the words in the line by spaces, commas, or periods
	    		  while (myTokens.hasMoreTokens()) {
	    			  try {
	    				//make each separate string of the line into Word objects and add each valid word to the tree map 
	    				  Word b= new Word(myTokens.nextToken());
	    				  foodItems.put(b, null);
	    			  }
	    			  catch (IllegalWordException e) {
	    				  //catches the word if its not valid and prints "invalid word:" + invalid word
	    				  System.out.println(e.getMessage());
	    			
	    			  }
	    		  }
	    		  line=tfi.readLine(); //read next line
	    		  
	      }
	      treeIntoGUI(foodItems); //calls method to add the words to the aisle GUI
	}
	   
	
	   // adds users additional word to the GUI by adding it into tree map and then sorts into GUI alphabetically
	   public static void addWord(String inputWord) {	   
		   Word c;
		   try {
   			  //makes users input into a word type
   			  c= new Word(inputWord);
   			  //if valid, adds word to tree map 
   			  foodItems.put(c, null);
   			}
   			catch (IllegalWordException e) {
				System.out.println(e.getMessage());
   			}
		   treeIntoGUI(foodItems); //calls method to add the words to the aisle GUI
	   }
	   
	   public static void treeIntoGUI(TreeMap<Word, Word> map) {
			mapItemToAisle();
			//iterates through all the foods and places them in the correct aisle based on the HashMap 
			Set set = foodItems.entrySet();
			Iterator i = set.iterator();
			Map.Entry<Word, Word> me;
			while (i.hasNext()) {
				me= (Map.Entry)i.next(); 
				//converts the Word object into a string
				String a= me.getKey().toString().toLowerCase();
				//places the food in the correct aisle based on the value mapped to that food in the HashMap
				if(aisle.get(a) == null) {
					aisleUnknown.append(a + "\n");
				}
				else if (aisle.get(a) == 1) {
					  aisleOne.append(a + "\n");
				}
				else if (aisle.get(a) == 2) {
					  aisleTwo.append(a + "\n");
				}
				else if (aisle.get(a) == 3) {
					  aisleThree.append(a + "\n");
				}
				else if (aisle.get(a) == 4) {
					  aisleFour.append(a + "\n");
				}
				else if (aisle.get(a) == 5) {
					  aisleFive.append(a + "\n");
				}
		     }
		  
			  myFrame.setVisible(true);
		}
}
