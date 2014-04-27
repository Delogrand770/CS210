
/**
 * EX5P882 - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 8, 2011 at 10:37:37 AM
 */
import java.awt.*;
import javax.swing.*;

public class EX5P882 {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(303, 200));
    frame.setTitle("Compose Message");
    frame.setLayout(new BorderLayout());

    JLabel to_label = new JLabel("To:");
    JLabel cc_label = new JLabel("CC:");
    JTextField to_field = new JTextField(10);
    JTextField cc_field = new JTextField(10);
    
    JButton send = new JButton("Send");
    JTextArea message = new JTextArea();
    
    JPanel firstPanel = new JPanel(new BorderLayout());
    firstPanel.add(to_label, BorderLayout.WEST);
    firstPanel.add(to_field, BorderLayout.CENTER);

    JPanel secondPanel = new JPanel(new BorderLayout());
    secondPanel.add(cc_label, BorderLayout.WEST);
    secondPanel.add(cc_field, BorderLayout.CENTER);

    JPanel bothPanels = new JPanel(new GridLayout(2, 1));
    bothPanels.add(firstPanel);
    bothPanels.add(secondPanel);

    JPanel centerPanel = new JPanel(new BorderLayout());
    centerPanel.add(message, BorderLayout.CENTER);

    JPanel bottomPanel = new JPanel(new BorderLayout());
    bottomPanel.add(send, BorderLayout.EAST);

    frame.add(centerPanel, BorderLayout.CENTER);
    frame.add(bothPanels, BorderLayout.NORTH);
    frame.add(bottomPanel, BorderLayout.SOUTH);

    frame.setVisible(true);
  }
}
