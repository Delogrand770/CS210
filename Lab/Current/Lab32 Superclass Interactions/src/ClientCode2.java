
/**
 * ClientCode2 - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 4, 2011 at 10:56:02 AM
 */
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class ClientCode2 {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setForeground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Test Button");
    frame.setLayout(new FlowLayout());
    frame.setResizable(false);

    MultiLineButton button1 = new MultiLineButton();
    button1.setText("line1", "line2");
    button1.setBackground(Color.white);
    button1.setLocation(45, 5);
    button1.setSize(200, 30);
    
    frame.add(button1);
    frame.pack();
    frame.setVisible(true);
  }
}