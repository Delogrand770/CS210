
/**
 * EX567 - Draws a shape using a method that accepts x,y,s for xpos, ypos, scale
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 30, 2011 at 11:35:03 AM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class EX567 {

  public static int w = 400;
  public static int h = 300;

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(w, h);
    panel.setBackground(Color.cyan);
    Graphics2D g = panel.getGraphics();
    ShowDesign(g, 50, 50, 100);
    ShowDesign(g, 250, 10, 50);
    ShowDesign(g, 180, 115, 180);
    panel.copyGraphicsToScreen();
  }

  private static void ShowDesign(Graphics2D g, int x, int y, int s) {
    s /= 5;
    for (int i = 1; i <= 5; i++) {
      g.setColor(Color.red);
      g.drawRect(x, y, s * i, s * i);
    }
    g.setColor(Color.black);
    g.drawLine(x, y, x + s * 5, y + s * 5);
  }
}
