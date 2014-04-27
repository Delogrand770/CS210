
/**
 * EX4 - Draws the required design based on the console input of height and width
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 30, 2011 at 10:52:07 AM
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Scanner;

public class EX4 {

  public static int h = 0;
  public static int w = 0;

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Window Width: ");
    w = s.nextInt();
    System.out.println("Window Height: ");
    h = s.nextInt();
    DrawingPanel panel = new DrawingPanel(w, h);
    panel.setBackground(Color.white);
    Graphics2D g = panel.getGraphics();
    g.setColor(Color.black);
    ShowDesign(g);
    panel.copyGraphicsToScreen();
  }

  private static void ShowDesign(Graphics2D g) {
    int spacex = w / 10;
    int spacey = h / 10;
    System.out.println(spacex + "," + spacey);
    for (int i = 1; i <= 4; i++) {
      g.drawRect(spacex * i, spacey * i, w - spacex * i * 2, h - spacey * 2 * i);
    }
  }
}
