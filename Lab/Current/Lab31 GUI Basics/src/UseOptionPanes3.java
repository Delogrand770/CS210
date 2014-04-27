/**
 * Description: Shows how to convert string input from JOptionPanes
 *              into integer values - robust programming.
 *
 * @author  Dr. Brown
 *
 * @version 1.0   Fall 2008
 */

import javax.swing.JOptionPane;

public class UseOptionPanes3
{
  //-------------------------------------------------------------------
  public static void main(String[] args)
  {
    boolean invalidInput;

    int age = -1;
    while (age < 0 || age > 120)
    {
      String ageText = JOptionPane.showInputDialog(null, "How old are you?");
      try {
        age = Integer.parseInt(ageText);
        invalidInput = false;
      }
      catch (NumberFormatException error)
      {
        JOptionPane.showMessageDialog(null, "invalid integer input");
        invalidInput = true;
      }
      if (! invalidInput && age < 0 || age > 120)
        JOptionPane.showMessageDialog(null, "That was not an appropriate age"); 
    }
    
    double money = -1.0;
    while (money < 0.0)
    {
      String moneyText = JOptionPane.showInputDialog(null, "How much money do you have?");
      try {
        money = Double.parseDouble(moneyText);
        invalidInput = false;
      }
      catch (NumberFormatException error)
      {
        JOptionPane.showMessageDialog(null, "invalid number input");
        invalidInput = true;
      }
      if (! invalidInput && money < 0.0)
        JOptionPane.showMessageDialog(null, "Please enter a positive value or zero"); 
    }
    
    JOptionPane.showMessageDialog(null,
                 "If you can double your money each year,\n" +
                 "You'll have " + (money * 32) +
                 " dollars at age " + (age + 5) + "!");
  }
}
