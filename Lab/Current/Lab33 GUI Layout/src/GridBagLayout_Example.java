/**
 * Description: Demonstrate a window with a GridBagLayout manager. 
 *
 * @author Dr. Brown
 *
 * @version 1.0   Fall 2008
 */

import java.awt.*;
import javax.swing.*;

public class GridBagLayout_Example
{
  public static void main(String[] args)
  {
    // Create the window
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(720, 100));
    frame.setTitle("GridBagLayout example");
    frame.setLayout( new GridBagLayout() ); // <<<<<<<<<------ GridBagLayout
        
    String [] buttonTitles = { "a", "bb", "ccc", "dddd", "eeeee",
                               "ffffff", "gggggggg", "hhhhhhhhh", "iiiiiiiii" };
    // Create and add 9 buttons
    for (int j=0; j<9; j++)
    {
      JButton button = new JButton();
      button.setText(buttonTitles[j]);
      frame.add(button);  // <<<<<<< --- typically add Layout constraints (not shown here) 
    }

    frame.setVisible(true);
  }
}
