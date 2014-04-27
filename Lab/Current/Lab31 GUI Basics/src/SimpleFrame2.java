
/**
 * Description: Opens a window frame. (Example from textbook page 830.)
 *
 * @author Textbook
 *
 * @version 1.0   Fall 2008
 */
import java.awt.*;      // for Dimension, Point, and Color classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;   // for GUI components

public class SimpleFrame2 {
  //-------------------------------------------------------------------
  private static JButton button1;
  private static JButton button2;
  private static ButtonListener1 listener1;

  public static void main(String[] args) {
    // Step 1: Create a JFrame object
    JFrame frame = new JFrame();

    // Step 2: Set the JFrame properties (many more properties are posssible)
    frame.setForeground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(new Point(10, 50));
    frame.setSize(new Dimension(300, 120));
    frame.setTitle("Pick the honest button");
    //frame.setLayout(new FlowLayout());
    frame.setLayout(null);

    button1 = new JButton();
    button1.setText("The other button is lying");
    button1.setBackground(Color.white);
    button1.setLocation(45, 5);
    button1.setSize(200, 30);
    frame.add(button1);

    button2 = new JButton();
    button2.setText("The other button always lies");
    button2.setBackground(Color.white);
    button2.setLocation(45, 45);
    button2.setSize(200, 30);
    frame.add(button2);

    listener1 = new ButtonListener1();
    button1.addActionListener(listener1);
    button2.addActionListener(listener1);

    // Step 3: Make the JFrame visible on the screen
    frame.setVisible(true);
  }

  //=====================================================================
// Responds to a button click event by changing the button's color to
// a random color.
  static class ButtonListener1 implements ActionListener {
    // Implements actions related to the button
    @Override
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == button1) {
        JOptionPane.showMessageDialog(null, "This button is telling the truth");
      } else if (event.getSource() == button2) {
        JOptionPane.showMessageDialog(null, "This button is not telling the truth");
      }
    }
  }
}
