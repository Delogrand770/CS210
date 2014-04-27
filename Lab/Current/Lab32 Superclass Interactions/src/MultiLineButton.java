
/**
 * MultiLineButton - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 4, 2011 at 10:47:57 AM
 */
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MultiLineButton extends JButton {

  public MultiLineButton() {
    super();
  }

  public MultiLineButton(String line1, String line2) {
    super();
    setText(line1, line2);
  }

  public void setText(String line1, String line2) {
    JLabel label1 = new JLabel(line1);
    JLabel label2 = new JLabel(line2);
    add(label1);
    add(label2);
    GridLayout layout = new GridLayout(2, 1, 1, 1);
    setLayout(layout);
  }
}
