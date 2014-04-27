
/**
 * StringGame - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 17, 2011 at 10:31:11 AM
 */
import java.awt.*;      // for Dimension, Point, and Color classes
import javax.swing.*;   // for GUI components
import java.awt.event.*; //For events

public class StringGame implements ActionListener {

  JFrame frame;
  JTextField field_textInput;
  JButton button_toUpper;
  JButton button_toLower;

  public StringGame() {
    frame = new JFrame();
    frame.setForeground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(10, 50);
    frame.setSize(300, 110);
    frame.setTitle("Silly String Game");
    frame.setLayout(new BorderLayout());

    JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout());
    button_toUpper = new JButton("UpperCase");
    panel1.add(button_toUpper, BorderLayout.WEST);

    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout());
    button_toLower = new JButton("LowerCase");
    panel2.add(button_toLower, BorderLayout.WEST);

    field_textInput = new JTextField(10);

    frame.add(panel1, BorderLayout.NORTH);
    frame.add(field_textInput, BorderLayout.CENTER);
    frame.add(panel2, BorderLayout.SOUTH);

    button_toUpper.addActionListener(this);
    button_toLower.addActionListener(this);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button_toUpper) {
      field_textInput.setText(field_textInput.getText().toUpperCase());
    } else if (e.getSource() == button_toLower) {
      field_textInput.setText(field_textInput.getText().toLowerCase());
    }
  }

  public static void main(String[] args) {
    StringGame game1 = new StringGame();
  }
}
