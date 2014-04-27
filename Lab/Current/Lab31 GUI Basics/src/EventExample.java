/**
 * Description: Adds an action to a button click.
 *
 * @author Dr. Brown
 *
 * @version 1.0   Fall 2008
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventExample
{
  //-------------------------------------------------------------------
  public static void main(String[] args)
  {
    // Creates the window
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    frame.setSize(new Dimension(400, 200));
    frame.setTitle("A frame");
    frame.setBackground(Color.RED);
    frame.setForeground(Color.RED);

    // Creates and adds the buttons
    JButton button = new JButton("Click me");
    button.setPreferredSize( new Dimension(100,50) );
    frame.add(button);

    JButton button2 = new JButton("Or Click Me");
    button2.setPreferredSize( new Dimension(100,50) );
    frame.add(button2);

    // Establishes a "listener" to process action events on the first button
    ButtonListener listener = new ButtonListener(button);
    button.addActionListener( listener );

    frame.setVisible(true);
  }
}

// NOTE: This is a new class at the bottom of the file

//=====================================================================
// Responds to a button click event by changing the button's color to
// a random color.
class ButtonListener implements ActionListener
{
  private JButton button;
  
  // Constructor - receives which button the listener is responding to
  ButtonListener(JButton whichButton)
  {
    button = whichButton;
  }
  
  // Implements actions related to the button
  public void actionPerformed(ActionEvent event)
  {
    button.setBackground(new Color((float) Math.random(),
                                   (float) Math.random(), 
                                   (float) Math.random() ) );
  }
}
