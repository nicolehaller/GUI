package Project5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* Edit Menu Handler handles when the user clicks "Add Word" 
 * -> a JPane shows up asking the user to enter an additional word
 * -> and a new GUI is created with that new word added to it
 * @author Professor Kenneth Lord 
 */
public class EditMenuHandler implements ActionListener{
	   JFrame jframe;
	   String input;
	   int placeHolder=0;
	   public EditMenuHandler (JFrame jf) {
	      jframe = jf;
	   }
	   
	   public void actionPerformed(ActionEvent event) {
	      String menuName = event.getActionCommand(); //sets menuName to be the command the user chose
	      if (menuName.equals("Add Food")) //if user clicks add word...
	    	 //JPane pops up asking user to enter a word
	         input= JOptionPane.showInputDialog(null,"enter the food you want to add:");
	      	 //calls WordGUI constructor which will add the word to the GUI
	      	 new AisleGUI(input, placeHolder);
	   } 
	 
}
