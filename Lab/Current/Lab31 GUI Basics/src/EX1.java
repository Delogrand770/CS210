
/**
 * Exercises - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 2, 2011 at 12:19:40 PM
 */
import javax.swing.*;

public class EX1 {

  public static void main(String[] args) {
    String askNumber = JOptionPane.showInputDialog(null, "What is your favorite number?");
    if (askNumber != null) {
      int number = Integer.parseInt(askNumber);
      int isBirthday = JOptionPane.showConfirmDialog(null, "Is " + number + " your birthday?");
      if (isBirthday == 0) {
        JOptionPane.showMessageDialog(null, "Happy Birthday");
      } else if (isBirthday == 1){
        JOptionPane.showMessageDialog(null, "Oh well! It must be your favorite number for some other reason.");
      }else{
        
      }
    }
  }
}
