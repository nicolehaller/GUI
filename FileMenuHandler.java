package Project5;

/* File Menu Handler handles when the user clicks "Open" or "Quit" 
 * "Open"-> opens a file 
 * "quit"-> system shuts down 
 * @author Professor Kenneth Lord 
 */
import javax.swing.*;
//taken from Blackboard
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) {
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile( ); 
      else if (menuName.equals("Quit"))
         System.exit(0);
   } 

    private void openFile( ) {
       JFileChooser chooser;
       int          status;
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       if (status == JFileChooser.APPROVE_OPTION) 
          readSource(chooser.getSelectedFile());
       else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
    /*
     * @author me
     */
    private void readSource(File chosenFile) { 
       String chosenFileName = chosenFile.getAbsolutePath(); 
       //instantiate a new WordGui which takes in the file name that the user chooses to display in 6 boxes on screen 
       new AisleGUI(chosenFileName);
    }
    
} 
