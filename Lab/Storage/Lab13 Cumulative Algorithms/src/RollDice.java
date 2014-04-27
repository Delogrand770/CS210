/**
 * Roll Dice - Shows a random die and keeps track of the number of times it appears.
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
    int rand = 0;
    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;
    int five = 0;
    int six = 0;
    
    String t1 = " has happened ";
    String t2 = " times";
    
    for (int i = 0; i > -1; i++) {
      
      rand = gen.nextInt(6) + 1;
      if (rand == 1) {
        one++;
      } else if (rand == 2) {
        two++;
      } else if (rand == 3) {
        three++;
      } else if (rand == 4) {
        four++;
      } else if (rand == 5) {
        five++;
      } else if (rand == 6) {
        six++;
      }
      
      panel.setBackground(Color.white);
      drawDie(g, 100, 100, 100, rand);
      
      g.drawString(1 + t1 + one + t2, 100, 300);
      g.drawString(2 + t1 + two + t2, 100, 315);
      g.drawString(3 + t1 + three + t2, 100, 330);
      g.drawString(4 + t1 + four + t2, 100, 345);
      g.drawString(5 + t1 + five + t2, 100, 360);
      g.drawString(6 + t1 + six + t2, 100, 375);
      
      panel.copyGraphicsToScreen();
      panel.sleep(500);
    }
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
