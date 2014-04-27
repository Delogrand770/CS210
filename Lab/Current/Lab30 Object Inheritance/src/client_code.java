
/**
 * client_code - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Oct 31, 2011 at 10:27:05 AM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class client_code {

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(200, 200);
    Graphics2D g = panel.getGraphics();
    panel.setBackground(Color.white);
    GraphicsPoint a = new GraphicsPoint();
    a.setColor(Color.black);
    a.setX(10);
    a.setY(10);
    a.setSize(10);
    a.drawPoint(g);
    panel.copyGraphicsToScreen();
  }
}
