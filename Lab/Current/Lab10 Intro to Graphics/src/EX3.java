
/**
 * EX3 - Draws the design required
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 30, 2011 at 10:52:07 AM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class EX3 {

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(200, 200);
    panel.setBackground(Color.white);
    Graphics2D g = panel.getGraphics();
    g.setColor(Color.black);
    ShowDesign(g);
    panel.copyGraphicsToScreen();
  }

  private static void ShowDesign(Graphics2D g) {
    int s = 0;
    for (int i = 1; i <= 4; i++) {
      s = 20 * i;
      g.drawRect(s, s, 200 - s * 2, 200 - s * 2);
    }
  }
}
