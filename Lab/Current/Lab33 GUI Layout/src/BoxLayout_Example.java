/**
 * Description: Demonstrate a window with a FlowLayout manager. 
 *
 * @author Dr. Brown
 *
 * @version 1.0   Fall 2008
 */

import java.awt.*;
import javax.swing.*;

public class BoxLayout_Example
{
  public static void main(String[] args)
  {
    // Create the window
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(720, 100));
    frame.setTitle("BoxLayout example");
    frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) ); // <<<<------ BoxLayout
    // Experiment: Try changing the option to  BoxLayout.X_AXIS
         
    String [] buttonTitles = { "a", "bb", "ccc", "dddd", "eeeee",
                               "ffffff", "gggggggg", "hhhhhhhhh", "iiiiiiiii" };
    // Create and add 9 buttons
    for (int j=0; j<9; j++)
    {
      JButton button = new JButton();
      button.setText(buttonTitles[j]);
      frame.add(button);
    }

    frame.setVisible(true);
  }
}
