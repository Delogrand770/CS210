
/**
 * PJ5 - Draws the optical illusion based on parameters
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 30, 2011 at 6:54:48 PM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class PJ5 {

  public static int w = 650;
  public static int h = 400;

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(w, h);
    panel.setBackground(Color.gray);
    Graphics2D g = panel.getGraphics();
    drawPattern(g, 0, 0, 20, 4);
    drawPattern(g, 50, 70, 30, 5);
    //panel graphics, xpos, ypos, h/w, pairs, rows, offsetx
    drawGrid(g, 10, 150, 25, 4, 8, 0);
    drawGrid(g, 250, 200, 25, 3, 6, 10);
    drawGrid(g, 425, 180, 20, 5, 10, 10);
    drawGrid(g, 400, 20, 35, 2, 4, 35);
    panel.copyGraphicsToScreen();
  }

  private static void drawPattern(Graphics2D g, int x, int y, int s, int pairs) {
    for (int i = 0; i < pairs * 2; i++) {
      g.setColor(Color.black);
      g.fillRect(x + s * i, y, s, s);
      g.setColor(Color.blue);
      g.drawLine(x + s * i, y, x + s * i + s, y + s);
      g.drawLine(x + s * i, y + s, x + s * i + s, y);
      i++;
      g.setColor(Color.white);
      g.fillRect(x + s * i, y, s, s);
    }
  }

  private static void drawGrid(Graphics2D g, int x, int y, int s, int pairs, int rows, int offset) {
    for (int i = 0; i < rows; i++) {
      drawPattern(g, x, y + s * i + 2 * i, s, pairs);
      i++;
      drawPattern(g, x + offset, y + s * i + 2 * i, s, pairs);
    }
  }
}
