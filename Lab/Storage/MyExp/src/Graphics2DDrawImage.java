
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent {

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    Image img1 = Toolkit.getDefaultToolkit().getImage("o.png");
    Image img2 = Toolkit.getDefaultToolkit().getImage("k.png");
    Image img3 = Toolkit.getDefaultToolkit().getImage("l.png");
    Image img4 = Toolkit.getDefaultToolkit().getImage("m.png");
    Image img5 = Toolkit.getDefaultToolkit().getImage("n.png");
    g2.drawImage(img1, 10, 10, this);
    g2.drawImage(img2, 20, 20, this);
    g2.drawImage(img3, 30, 30, this);
    g2.drawImage(img4, 40, 40, this);
    g2.drawImage(img5, 50, 50, this);
    g2.finalize();
  }
}

public class Graphics2DDrawImage {

  public static void main(String[] a) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 300, 300);
    window.getContentPane().add(new MyCanvas());
    window.setVisible(true);
  }
}