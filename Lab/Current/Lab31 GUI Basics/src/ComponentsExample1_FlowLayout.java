/**
 * Description: Opens a window and adds two buttons.
 *
 * @author Textbook page 737
 *
 * @version 1.0   Fall 2008
 */

import java.awt.*;
import javax.swing.*;

public class ComponentsExample1_FlowLayout
{
  //-------------------------------------------------------------------
  public static void main(String[] args)
  {
    // Create the window
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(300, 100));
    frame.setTitle("A frame");
    frame.setLayout(new FlowLayout()); // This will be discuss in the next lesson
        
    // Create and add the first button
    JButton button1 = new JButton();
    button1.setText("I'm a button.");
    button1.setBackground(Color.BLUE);
    frame.add(button1);
       
    // Create and add the second button
    JButton button2 = new JButton();
    button2.setText("Click me!");
    button2.setBackground(Color.RED);
    frame.add(button2);
        
    // Reset the sizes of the buttons and window
    frame.pack();
    
    // Actually put the window on the screen and draw all its components 
    frame.setVisible(true);
  }
}
