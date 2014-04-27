
/**
 * DrawingPanelMagic - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Oct 7, 2011 at 11:18:52 AM
 */
import java.awt.Color;
import java.util.Random;

public class DrawingPanelMagic {

  public static Random gen = new Random();

  public static void main(String[] args) {
    DrawingPanel[] panels = new DrawingPanel[5];
    int panelsOpen = panels.length;
    for (int i = 0; i < panels.length; i++) {
      panels[i] = new DrawingPanel(300, 300);
      Color random = new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255));
      panels[i].setBackground(random);
      panels[i].copyGraphicsToScreen();
    }


    long time = System.currentTimeMillis();
    while (panelsOpen > 0) {
      if (time % 2 == 0) {
        int randPanel = gen.nextInt(panels.length);
        if (panels[randPanel] != null) {
          Color random = new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255));
          panels[randPanel].setBackground(random);
          panels[randPanel].copyGraphicsToScreen();
        }
      }

      time = System.currentTimeMillis();
      if (time % 2 == 0) {
        int randPanel = gen.nextInt(panels.length);
        if (panels[randPanel] != null) {
          panels[randPanel].closeWindow();
          panels[randPanel] = null;
        }
      }
    }

  }
}
