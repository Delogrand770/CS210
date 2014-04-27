
/**
 * EX1 - Draws the required shape
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 30, 2011 at 10:18:47 AM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class EX1 {

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(220, 150);
    panel.setBackground(Color.yellow);
    Graphics2D g = panel.getGraphics();
    g.setColor(Color.blue);
    g.fillOval(50, 25, 40, 40);
    g.fillOval(130, 25, 40, 40);
    g.setColor(Color.red);
    g.fillRect(70, 45, 82, 82);
    g.setColor(Color.black);
    g.drawLine(70, 85, 151, 85);
    panel.copyGraphicsToScreen();
  }
}
