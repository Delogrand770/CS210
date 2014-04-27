
/**
 * GraphicPoint - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Oct 31, 2011 at 10:16:36 AM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class GraphicsPoint extends Point {

  private int size;
  private Color color;

  public void drawPoint(Graphics2D g) {
    g.setColor(color);
    g.fillOval(getX(), getY(), size, size);
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public int getSize() {
    return size;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "Size: " + size + "\nColor: " + color + "\nx: " + getX() + "\ny:" + getY();
  }
}
