
/**
 * PEX2 - Whack a mole game
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

public class PEX2_2 {

  public static int diff = 1;
  public static int winW = 500;
  public static int winH = 500;
  public static Random gen = new Random();
  public static Scanner ask = new Scanner(System.in);
  public static String name = "user";
  public static Color green = new Color(34, 139, 34);
  public static int hits = 0;
  public static int misses = 0;
  public static boolean playing = true;

  public static void main(String[] args) {
    //setup(); //get user input for game setup
    DrawingPanel panel = new DrawingPanel(winW, winH);
    panel.setWindowTitle("Whack a Mole");
    BufferedImage mole = panel.loadBitmap("mole.png");
    BufferedImage rocks = panel.loadBitmap("rocks.png");
    Graphics2D g = panel.getGraphics();
    panel.setBackground(green);
    update(panel, g, mole, rocks);
  }

  public static void update(DrawingPanel panel, Graphics2D g, BufferedImage mole, BufferedImage rocks) {
    while (playing) { //main game loop
      panel.setBackground(green);
      generateMole(panel, g, mole, rocks);
      checkClicks(panel, g);
      checkState(panel, g);
    }
  }

  public static void setup() { //accepts and validates user input for setting up the game
    boolean invalid = true; //tried to minimize scope but the while exit condition doesn't like it
    
    //name
    System.out.print("What is your name? ");
    name = ask.next();
    
    //window height
    do {
      System.out.print("Window Height >= 500? ");
      if (ask.hasNextInt()) {
        winH = ask.nextInt();
        if (winH >= 500) {
          invalid = false;
        }
      } else {
        ask.next();
      }
    } while (invalid);

    //window width
    invalid = true;
    do {
      System.out.print("Window Width >= 500? ");
      if (ask.hasNextInt()) {
        winW = ask.nextInt();
        if (winW >= 500) {
          invalid = false;
        }
      } else {
        ask.next();
      }
    } while (invalid);

    //game difficulty
    invalid = true;
    do {
      System.out.print("What difficulty 1-3? ");
      if (ask.hasNextInt()) {
        diff = ask.nextInt();
        if (diff >= 1 && diff <= 3) {
          invalid = false;
        }
      } else {
        ask.next();
      }
    } while (invalid);
  }

  public static void generateMole(DrawingPanel panel, Graphics2D g, BufferedImage mole, BufferedImage rocks) {
    //imageH and imageW used to scale mole based on difficulty
    int imageH = mole.getHeight() / (diff);
    int imageW = mole.getWidth() / (diff);
    
    int x1 = gen.nextInt(winW - imageW);
    int y1 = gen.nextInt(winH - imageH - 20);
    y1 += (y1 <= 15) ? 15 : 0; // keeps the mole off the score
    
    g.drawImage(rocks, x1, y1, imageW, imageH, null);
    g.drawImage(mole, x1, y1, imageW, imageH, null);
  }

  private static void scoreUpdate(DrawingPanel panel, Graphics2D g) {
    g.setColor(Color.black);
    g.drawString("User: " + name, 0, 10);
    g.drawString("Score: " + hits, 150, 10);
    g.drawString("Misses: " + misses + "/" + (diff * 3), 300, 10);
    panel.copyGraphicsToScreen();
  }

  private static void checkClicks(DrawingPanel panel, Graphics2D g) {
    int sleep = (2000 / (diff * 2)) + gen.nextInt(1000);
    boolean hit = false;
    //System.out.println(sleep);
    for (int i = 0; i < sleep; i++) {
      if (panel.mouseClickHasOccurred(DrawingPanel.LEFT_BUTTON)) {
        int mouseX = panel.getMouseClickX(DrawingPanel.LEFT_BUTTON);
        int mouseY = panel.getMouseClickY(DrawingPanel.LEFT_BUTTON);
        int rgb = panel.getRGB(mouseX, mouseY);
        if (rgb != -14513374 && rgb != -16777216 && !hit) { //background and score colors
          //System.out.println("Mole Hit" + rgb);
          panel.setBackground(green);
          hit = true;
          hits += diff;
        } else {
          if (!hit) {
            hit = true;
            //System.out.println("Mole Miss" + rgb);
            panel.setBackground(green);
            misses++;
          }
        }
      }
      panel.sleep(1);
      scoreUpdate(panel, g);
    }
    if (!hit) {
      misses++;
    }
  }

  private static void checkState(DrawingPanel panel, Graphics2D g) {
    if (misses >= diff * 3) { //lose
      playing = false;
      panel.setBackground(green);
      String text = "Sorry " + name + " you have lost.";
      g.drawString(text, winW / 2 - text.length() * 3, winH / 2);
      scoreUpdate(panel, g);
    } else if (hits > diff * 5) { //win
      playing = false;
      panel.setBackground(green);
      String text = "Congrats " + name + " you have won.";
      g.drawString(text, winW / 2 - text.length() * 3, winH / 2);
      scoreUpdate(panel, g);
    } else if (panel.keyHasBeenHit(DrawingPanel.ESC_KEY)) { //quit
      playing = false;
      panel.setBackground(green);
      String text = "Game ended by " + name + ". Please close the window.";
      g.drawString(text, winW / 2 - text.length() * 3, winH / 2);
      panel.copyGraphicsToScreen();
    }
  }
}
