
/**
 * Create a "graphics point" using inheritance from a Point class.
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Oct 31, 2011 at 2:08:22 PM
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class GraphicsPoint extends Point {

  private int diameter; // diameter of circle used to draw the point, in pixels 
  private Color color;

  public GraphicsPoint() {
    this(0, 0, 3, Color.black);
  }

  public GraphicsPoint(int x, int y, int diameter, Color color) {
    super(x, y);
    this.diameter = diameter;
    this.color = color;
  }

  public GraphicsPoint(Point other) {
    this(other.getX(), other.getY(), 3, Color.black);
  }

  @Override
  public boolean equals(Object o) {
    boolean isSame = false;
    if (o instanceof GraphicsPoint) {
      GraphicsPoint otherPoint = (GraphicsPoint) o; // this is a cast to the correct data type
      if (this.getColor().equals(otherPoint.getColor()) && this.getSize() == otherPoint.getSize()
          && this.getX() == otherPoint.getX() && this.getY() == otherPoint.getY()) {
        isSame = true;
      }
    }
    return isSame;
  }

  @Override
  public void translate(int dx, int dy) {
    super.translate(dx, dy);
    setSize(diameter + 5);
  }

  public void drawPoint(Graphics2D g) {
    g.setColor(color);
    int circleDiameter = Math.max(1, (int) Math.round(diameter));
    int radius = circleDiameter / 2;
    g.fillOval(getX() - radius, getY() - radius, circleDiameter, circleDiameter);
    g.drawOval(getX() - radius, getY() - radius, circleDiameter, circleDiameter);
  }

  public void setColor(Color newColor) {
    color = new Color(newColor.getRGB());
  }

  public Color getColor() {
    return new Color(color.getRGB());
  }

  public void setSize(int newSize) {
    if (newSize >= 0) {
      diameter = newSize;
    }
  }

  public double getSize() {
    return diameter;
  }

  @Override
  public String toString() {
    return "GraphicsPoint (" + getX()
           + "," + getY() + ") color= "
           + color + " size= " + diameter;
  }
}
