
/**
 * PEX2 - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 8, 2011 at 11:09:23 AM
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;

public class PEX2 {

  public static int diff = 1;
  public static int winW = 500;
  public static int winH = 500;
  public static Random gen = new Random();
  public static Scanner ask = new Scanner(System.in);
  public static String name = "user";
  public static Color green = new Color(34, 139, 34);
  public static int hits = 0;
  public static int misses = 0;

  public static void main(String[] args) {
    //setup();
    DrawingPanel panel = new DrawingPanel(winW, winH); //Modified DrawingPanel.java to accept a title parameter
    BufferedImage mole = panel.loadBitmap("mole.png");
    BufferedImage rocks = panel.loadBitmap("rocks.png");
    Graphics2D g = panel.getGraphics();
    panel.setBackground(green);
    update(panel, g, mole, rocks);
  }

  public static void update(DrawingPanel panel, Graphics2D g, BufferedImage mole, BufferedImage rocks) {
    while (true) {
      panel.setBackground(green);
      //generateMole(panel, g, mole, rocks);
      scoreUpdate(panel,g);
      //checkClicks(panel, g);
    }
  }

  public static void setup() {
    System.out.print("What is your name? ");
    name = ask.next();

    do {
      System.out.print("Window Height >= 300? ");
      winH = ask.nextInt();
    } while (winH < 300);

    do {
      System.out.print("Window Width >= 300? ");
      winW = ask.nextInt();
    } while (winH < 300);

    do {
      System.out.print("What difficulty 1-3? ");
      diff = ask.nextInt();
    } while (diff < 1 || diff > 3);
  }

  public static void generateMole(DrawingPanel panel, Graphics2D g, BufferedImage mole, BufferedImage rocks) {
    int imageH = mole.getHeight() / (diff * 2);
    int imageW = mole.getWidth() / (diff * 2);
    int x1 = 0;
    int x2 = 0;
    int x3 = 0;
    int y1 = 0;
    int y2 = 0;
    int y3 = 0;

    //Generates coordinates for the image placement and ensures they do not overlap
    while (true) { //While loop replacement
      x1 = gen.nextInt(winW - imageW);
      y1 = gen.nextInt(winH - imageH - 20);
      if (diff >= 2) {
        x2 = gen.nextInt(winW - imageW);
        y2 = gen.nextInt(winH - imageH - 20);
      }
      if (diff >= 3) {
        x3 = gen.nextInt(winW - imageW);
        y3 = gen.nextInt(winH - imageH - 20);
      }

      if (diff >= 3) {
        if (Math.abs(x1 - x2) >= imageW && Math.abs(x1 - x3) >= imageW && Math.abs(x3 - x2) >= imageW) {
          if (Math.abs(y1 - y2) >= imageH && Math.abs(y1 - y3) >= imageH && Math.abs(y3 - y2) >= imageH) {
            break;
          }
        }
      } else {
        break;
      }
    }

    g.drawImage(rocks, x1, y1, imageW, imageH, null);
    if (diff >= 2) {
      g.drawImage(rocks, x2, y2, imageW, imageH, null);
    }
    if (diff >= 3) {
      g.drawImage(rocks, x3, y3, imageW, imageH, null);
    }

    panel.copyGraphicsToScreen();
    panel.sleep(300 * (gen.nextInt(diff) + 1));
    g.drawImage(mole, x1, y1, imageW, imageH, null);
    panel.copyGraphicsToScreen();
  }

  private static void scoreUpdate(DrawingPanel panel, Graphics2D g) {
    g.setColor(Color.black);
    g.drawString("User: " + name, 10, 10);
    g.drawString("Hits: " + hits, 20, 20);
    g.drawString("Misses: " + misses, 40, 40);
    panel.copyGraphicsToScreen();
  }

  private static void checkClicks(DrawingPanel panel, Graphics2D g) {
    int sleep = (1500 / diff); // need to add a random aspect
    //System.out.println(sleep);
    for (int i = 0; i < sleep; i++) {
      if (panel.mouseClickHasOccurred(DrawingPanel.LEFT_BUTTON)) {
        int mouseX = panel.getMouseClickX(DrawingPanel.LEFT_BUTTON);
        int mouseY = panel.getMouseClickY(DrawingPanel.LEFT_BUTTON);
        if (panel.getRGB(mouseX, mouseY) != -14513374) {
          System.out.println("Mole Hit");
          panel.setBackground(green);
          hits++;
        } else {
          System.out.println("Mole Miss");
          panel.setBackground(green);
          misses++;
        }
      }
      panel.sleep(1);
    }
  }
}
