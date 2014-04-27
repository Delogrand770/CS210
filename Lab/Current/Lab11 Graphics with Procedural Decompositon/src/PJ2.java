
/**
 * PJ2 - Draws 3 different blocks that arranged in a certain order. Colors are determined at random since not specified
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 30, 2011 at 6:54:48 PM
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class PJ2 {

  public static int w = 200;
  public static int h = 200;
  public static Random gen = new Random();

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(w, h);
    panel.setBackground(Color.cyan);
    Graphics2D g = panel.getGraphics();
    drawEye(g, 10, 10);
    drawSwirl(g, 60, 10);
    drawText(g, 110, 10);
    drawSwirl(g, 10, 60);
    drawText(g, 60, 60);
    drawEye(g, 110, 60);
    drawText(g, 10, 110);
    drawEye(g, 60, 110);
    drawSwirl(g, 110, 110);
    panel.copyGraphicsToScreen();
  }

  private static Color randColor() {
    return new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255));
  }

  private static void drawEye(Graphics2D g, int x, int y) {
    g.setColor(Color.black);
    g.drawOval(x + 5, y + 5, 15, 40);
    g.drawOval(x + 30, y + 5, 15, 40);
    g.drawRect(x, y, 50, 50);
    g.setColor(randColor());
    g.fillOval(x + 5, y + 25, 15, 15);
    g.fillOval(x + 30, y + 25, 15, 15);
  }

  private static void drawText(Graphics2D g, int x, int y) {
    g.setColor(Color.black);
    g.drawRect(x, y, 50, 50);
    g.setColor(randColor());
    g.drawString("I", x + 25, y + 12);
    g.drawString("Love", x + 13, y + 25);
    g.drawString("Java", x + 13, y + 37);
  }

  private static void drawSwirl(Graphics2D g, int x, int y) {
    int step = 5;
    g.setColor(Color.black);
    g.drawRect(x, y, 50, 50);
    g.setColor(randColor());
    g.drawLine(x + 25, y + 20, x + 25, y + 30); //down
    g.drawLine(x + 20, y + 25, x + 30, y + 25); //right
    for (int i = 1; i <= 4; i++) {
      g.drawLine(x + step * i, y + step * i, x + 50 - step * (i - 1), y + step * i); //top
      g.drawLine(x + step * i, y + step * (i - 1), x + step * i, y + 50 - step * i); //left
      g.drawLine(x + 25 + step * i, y + 25 - (step * i), x + 25 + step * i, y + 25 + step * (i + 1)); //right
      g.drawLine(x + 20 - (step * i), y + 25 + step * i, x + 20 + step * (i + 1), y + 25 + step * i); //bottom
    }
  }
}
