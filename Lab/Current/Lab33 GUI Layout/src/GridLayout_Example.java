/**
 * Description: Demonstrate a window with a GridLayout manager. 
 *
 * @author Dr. Brown
 *
 * @version 1.0   Fall 2008
 */

import java.awt.*;
import javax.swing.*;

public class GridLayout_Example
{
  public static void main(String[] args)
  {
    // Create the window
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(720, 100));
    frame.setTitle("GridLayout example");
    frame.setLayout( new GridLayout(3,3, 0, 0) ); // <<<<<<<<<------ GridLayout
        
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
