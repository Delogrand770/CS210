
/**
 * EX2 - Draws multiples of the figure in EX1 based on a x,y parameter in the method
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 30, 2011 at 10:38:01 AM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class EX2 {

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(450, 150);
    panel.setBackground(Color.yellow);
    Graphics2D g = panel.getGraphics();
    DrawFigure(g, 50, 25);
    DrawFigure(g, 250, 45);
    panel.copyGraphicsToScreen();
  }

  public static void DrawFigure(Graphics2D g, int x, int y) {
    g.setColor(Color.blue);
    g.fillOval(x, y, 40, 40);
    g.fillOval(x + 80, y, 40, 40);
    g.setColor(Color.red);
    g.fillRect(x + 20, y + 20, 82, 82);
    g.setColor(Color.black);
    g.drawLine(x + 20, y + 60, x + 101, y + 60);
  }
}
