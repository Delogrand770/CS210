
/**
 * PJ1 - Draws a pattern that scales and is able to be positioned
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 30, 2011 at 6:54:48 PM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class PJ1 {

  public static int w = 400;
  public static int h = 400;

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(w, h);
    panel.setBackground(Color.cyan);
    Graphics2D g = panel.getGraphics();
    //panel graphics, xpos, ypos, individual block width, rings, grid size
    drawPattern(g, 0, 0, 100, 5, 1);
    drawPattern(g, 10, 120, 24, 4, 5);
    drawPattern(g, 150, 20, 40, 5, 6);
    drawPattern(g, 130, 275, 36, 3, 3);
    panel.copyGraphicsToScreen();
  }

  private static void showDesign(Graphics2D g, int x, int y, int s, int num) {
    int step = s / num / 2;
    num -= 1;
    g.setColor(Color.green);
    g.fillRect(x, y, s, s);
    g.setColor(Color.yellow);
    g.fillOval(x, y, s, s);
    g.setColor(Color.black);
    g.drawOval(x, y, s, s);
    g.drawLine(x + s / 2, y, x + s / 2, y + s);
    g.drawLine(x, y + s / 2, x + s, y + s / 2);
    for (int i = 1; i <= num; i++) {
      g.drawOval(x + step * i, y + step * i, s - step * i * 2, s - step * i * 2);
    }
  }

  private static void drawPattern(Graphics2D g, int x, int y, int s, int num, int grid) {
    for (int i = 0; i < grid; i++) {
      for (int j = 0; j < grid; j++) {
        showDesign(g, x + i * s, y + j * s, s, num);
      }
    }
  }
}
