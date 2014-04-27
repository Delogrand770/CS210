
/**
 * <put a program description here>
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 2, 2011 at 1:46:55 PM
 */
import java.awt.*;
import java.awt.image.BufferedImage;

public class MoveImage {

  public static void main(String[] args) {
    int inf = 0;
    int x = 100;
    int y = 100;
    int vx = 0;
    int vy = 0;
    // Create the window
    DrawingPanel panel = new DrawingPanel(400, 400);
    panel.setBackground(Color.white);
    Graphics2D g = panel.getGraphics();

    // Read the image into memory
    BufferedImage image = panel.loadBitmap("Flower.jpg");

    while (inf == 0) {
      if (panel.keyHasBeenHit(DrawingPanel.DOWN_ARROW_KEY)) {
        vy = 1;
      }
      if (panel.keyHasBeenHit(DrawingPanel.UP_ARROW_KEY)) {
        vy = -1;
      }
      if (panel.keyHasBeenHit(DrawingPanel.LEFT_ARROW_KEY)) {
        vx = -1;
      }
      if (panel.keyHasBeenHit(DrawingPanel.RIGHT_ARROW_KEY)) {
        vx = 1;
      }
      x -= -vx;
      y -= -vy;
      if (x <= 0) {
        x = 0;
      }
      if (y <= 0) {
        y = 0;
      }
      if (x > 400 - 160) {
        x = 400 - 160;
      }
      if (y > 400 - 149) {
        y = 400 - 149;
      }
      panel.setBackground(Color.white);
      g.drawImage(image, x, y, null);
      panel.copyGraphicsToScreen();
    }
  }
}
