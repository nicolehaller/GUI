
package Project5;

import javax.swing.*;

//import lab19.EditMenuHandler;

//sampleGUI creates a GUI with file menu
import java.awt.*;
public class MenuGUI extends JFrame { 
   
   JMenuBar menuBar  = new JMenuBar(); //creates one bar at top of frame
	
   public MenuGUI(String title, int height, int width) {
	   //creates GUI frame
	    setTitle(title);
	    setSize(height,width);
        setLocation  (100,100); //sets location to the middle of the screen
	    createFileMenu();
	    createEditMenu();
	    setDefaultCloseOperation(EXIT_ON_CLOSE); //once close window, terminates program
        setVisible(true);
   } 

   /*
    * the createFileMenu() creates a "File" dropdown option on the GUI
    * dropdown options from "File" are "Open" or "Quit"
    * 
    * @author Professor Kenneth Lord
    */
   private void createFileMenu( ) {
      JMenu       fileMenu = new JMenu("File"); //creates menu on top bar called file
      JMenuItem   item; //items in drop down menu
      FileMenuHandler fmh  = new FileMenuHandler(this); 

      //creates drop down item from "File" called "Open"
      item = new JMenuItem("Open");   
      item.addActionListener( fmh ); 
      fileMenu.add( item ); 

      fileMenu.addSeparator();    //add a horizontal separator line between items
    
      //creates another drop down menu item from "File" called "Quit"
      item = new JMenuItem("Quit");       
      item.addActionListener( fmh ); 
      fileMenu.add( item ); 

      setJMenuBar(menuBar); 
      menuBar.add(fileMenu); 
    
   } 
   
   /*
    * createEditMenu() creates an "Edit" dropdown option on the GUI
    * @author Professor Kenneth Lord
    */
   private void createEditMenu() {
	    JMenuItem   item; 
	    JMenu       editMenu = new JMenu("Edit"); 
	    EditMenuHandler emh  = new EditMenuHandler(this); 
	    
	    //creates drop down item from "Edit" called add word
	    item = new JMenuItem("Add Food");    
	    item.addActionListener( emh ); 
	    editMenu.add( item ); 

	    menuBar.add(editMenu);
  }
  
} 