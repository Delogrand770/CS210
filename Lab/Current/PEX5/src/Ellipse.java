
/**
 * Ellipse - Represents a ellipse or circle object
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 17, 2011 at 4:52:33 PM
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Ellipse extends Shape {

  private boolean fill;

  /**
  Constructor for a new ellipse and circle.
  @param newX - x position.
  @param newY - y position.
  @param newColor - shape color.
  @param newWidth - shape width.
  @param newHeight  - shape height.
  @param newFill  - true for fill and false for draw.
   */
  public Ellipse(int newX, int newY, Color newColor, int newHeight, int newWidth, boolean newFill) {
    super(newX, newY, newColor, newWidth, newHeight);
    fill = newFill;
  }

  /**
  Draws the shape
  @param g - the Graphics2D object to send the shape data to.
   */
  @Override
  public void draw(Graphics2D g) {
    Color current = g.getColor();
    g.setColor(this.getColor());
    int w = getWidth();
    int h = getHeight();
    if (fill) {
      g.fillOval(this.getX(), this.getY(), w, h);
    } else {
      g.drawOval(this.getX(), this.getY(), w, h);
    }
    g.setColor(current);
  }

  /**
  Checks to see if a test point is within the bounds of this shape.
  @param test - Point to test against.
  @return true if the point is within the shape and false if not.
   */
  @Override
  public boolean contains(Point test) {
    double testX = test.getX();
    double testY = test.getY();
    double normx = (testX - getX()) / getWidth() - 0.5;
    double normy = (testY - getY()) / getHeight() - 0.5;
    return (normx * normx + normy * normy) < 0.25;
  }
}
