/**
 * Description: Shows how to convert string input from JOptionPanes
 *              into integer values.
 *
 * @author Textbook, page 730
 *
 * @version 1.0   Fall 2008
 */

import javax.swing.JOptionPane;

public class UseOptionPanes2
{
  //-------------------------------------------------------------------
  public static void main(String[] args)
  {
    String ageText = JOptionPane.showInputDialog(null, "How old are you?");
    int age = Integer.parseInt(ageText);

    String moneyText = JOptionPane.showInputDialog(null, "How much money do you have?");
    double money = Double.parseDouble(moneyText);

    JOptionPane.showMessageDialog(null,
                 "If you can double your money each year,\n" +
                 "You'll have " + (money * 32) +
                 " dollars at age " + (age + 5) + "!");
  }
}
