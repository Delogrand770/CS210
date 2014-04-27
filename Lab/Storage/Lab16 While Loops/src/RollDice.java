
/**
 * Roll Dice - Rolls 2 random die until it rolls double 6
 *
 * @modified by C14Gavin.Delphia
 *
 * @version 1.0 - Sep 7, 2011 at 5:12:20 PM
 */
import java.awt.*;
import java.util.Random;

public class RollDice {

  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(400, 400);
    panel.setBackground(Color.white);
    Graphics2D g = panel.getGraphics();
    panel.setBackground(Color.white);

    Random gen = new Random();
    int rand1 = 0;
    int rand2 = 0;
    int stop = 0;
    do {
      rand1 = gen.nextInt(6) + 1;
      rand2 = gen.nextInt(6) + 1;

      panel.setBackground(Color.white);
      drawDie(g, 50, 100, 100, rand1);
      drawDie(g, 200, 100, 100, rand2);

      panel.copyGraphicsToScreen();
      panel.sleep(200);
      if (rand1 == 6 && rand2 == 6) {
        stop = 1;
      }
    } while (stop != 1);
  }

  // ------------------------------------------------------------------
  public static void drawDie(Graphics2D g, int x, int y, int rectangleSize,
                             int dieValue) {
    int spacing = rectangleSize / 14;
    int dotSize = spacing * 2;

    // Draw the die outline
    g.setColor(Color.WHITE);
    g.fillRect(x, y, rectangleSize, rectangleSize);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, rectangleSize, rectangleSize);

    // Draw the die dots
    if (dieValue == 1 || dieValue == 3 || dieValue == 5) {
      // center
      g.fillOval(x + spacing * 6, y + spacing * 6, dotSize, dotSize);
    }

    if (dieValue >= 2) {
      // upper left corner
      g.fillOval(x + spacing * 2, y + spacing * 2, dotSize, dotSize);
      // lower right corner
      g.fillOval(x + spacing * 10, y + spacing * 10, dotSize, dotSize);
    }

    if (dieValue >= 4) {
      // upper right corner
      g.fillOval(x + spacing * 10, y + spacing * 2, dotSize, dotSize);
      // lower left corner
      g.fillOval(x + spacing * 2, y + spacing * 10, dotSize, dotSize);
    }

    if (dieValue == 6) {
      // upper center
      g.fillOval(x + spacing * 6, y + spacing * 2, dotSize, dotSize);
      // lower center
      g.fillOval(x + spacing * 6, y + spacing * 10, dotSize, dotSize);
    }
  }
}
