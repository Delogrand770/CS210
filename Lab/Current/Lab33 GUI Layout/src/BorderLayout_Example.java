/**
 * Description: Demonstrate a window with a BorderLayout manager. 
 *
 * @author Textbook, page 742-743.
 *
 * @version 1.0   Fall 2008
 */

import java.awt.*;
import javax.swing.*;

public class BorderLayout_Example
{
  public static void main(String[] args)
  {
    // Create the window
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize( new Dimension(720, 100) );
    frame.setTitle("BorderLayout example");
    frame.setLayout( new BorderLayout() ); // <<<<<<<<<------ BorderLayout Manager
        
    JButton button = new JButton();
    button.setText("North Button");
    frame.add(button, BorderLayout.NORTH);
    
//     button = new JButton();
//     button.setText("South Button");
//     frame.add(button, BorderLayout.SOUTH);
    
    button = new JButton();
    button.setText("West Button");
    frame.add(button, BorderLayout.WEST);
    
    button = new JButton();
    button.setText("Center Button");
    frame.add(button, BorderLayout.CENTER);
    
    button = new JButton();
    button.setText("East Button");
    frame.add(button, BorderLayout.EAST);
    
    frame.setVisible(true);
  }
}
