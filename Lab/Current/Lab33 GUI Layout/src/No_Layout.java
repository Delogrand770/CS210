/**
 * Description: Demonstrate a window with no layout manager. 
 *
 * @author Dr. Brown
 *
 * @version 1.0   Fall 2008
 */

import java.awt.*;
import javax.swing.*;

public class No_Layout
{
  public static void main(String[] args)
  {
    // Create the window
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(720, 100));
    frame.setTitle("No layout example");
    frame.setLayout(null); // ****** layout set to null - means no layout manager
        
    String [] buttonTitles = { "a", "bb", "ccc", "dddd", "eeeee",
                               "ffffff", "gggggggg", "hhhhhhhhh", "iiiiiiiii" };
    // Create and add 9 buttons
    for (int j=0; j<9; j++)
    {
      JButton button = new JButton();
      button.setText(buttonTitles[j]);
      button.setSize( 80, 30 );         // MUST set size
      button.setLocation( j*80, 0);     // MUST set location
      frame.add(button);
    }

    frame.setVisible(true);
  }
}
