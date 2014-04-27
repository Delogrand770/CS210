
/**
 * MegaCalc - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 17, 2011 at 10:31:11 AM
 */
import java.awt.*;      // for Dimension, Point, and Color classes
import javax.swing.*;   // for GUI components
import java.awt.event.*; //For events

public class MegaCalc implements ActionListener {

  JFrame frame;
  JTextField field_number1;
  JTextField field_number2;
  JButton button_equals;
  JButton button_clear;
  JComboBox box_operation;
  JLabel label_result;

  public MegaCalc() {
    frame = new JFrame();
    frame.setForeground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(10, 50);
    frame.setSize(400, 130);
    frame.setTitle("MegaCalc");
    frame.setLayout(new BorderLayout());

    field_number1 = new JTextField(10);
    field_number2 = new JTextField(10);
    button_equals = new JButton(" = ");
    button_clear = new JButton("Clear");
    label_result = new JLabel();
    String[] options = {" + ", " - ", " * ", " / ", " ^ ", " % "};
    box_operation = new JComboBox(options);

    JPanel panel1 = new JPanel();
    panel1.add(field_number1);
    panel1.add(box_operation);
    panel1.add(field_number2);
    panel1.add(button_equals);

    frame.add(panel1, BorderLayout.NORTH);
    frame.add(label_result, BorderLayout.CENTER);
    frame.add(button_clear, BorderLayout.SOUTH);

    button_equals.addActionListener(this);
    button_clear.addActionListener(this);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button_equals) {
      int operation = box_operation.getSelectedIndex();
      try {
        int num1 = Integer.parseInt(field_number1.getText());
        int num2 = Integer.parseInt(field_number2.getText());
        double answer = 0;
        if (operation == 0) {
          answer = num1 + num2;
        } else if (operation == 1) {
          answer = num1 - num2;
        } else if (operation == 2) {
          answer = num1 * num2;
        } else if (operation == 3) {
          answer = num1 / num2;
        } else if (operation == 4) {
          answer = Math.pow(num1, num2);
        } else if (operation == 5) {
          answer = num1 % num2;
        }
        label_result.setText(Double.toString(answer));
      } catch (NumberFormatException error) {
        label_result.setText("You must enter valid numbers");
      }
    } else if (e.getSource() == button_clear) {
      field_number1.setText("");
      field_number2.setText("");
      label_result.setText("");
      box_operation.setSelectedIndex(0);
    }
  }

  public static void main(String[] args) {
    MegaCalc calc1 = new MegaCalc();
  }
}
