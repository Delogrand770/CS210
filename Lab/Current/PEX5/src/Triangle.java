
/**
 * Triangle - Represents a triangle object
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 17, 2011 at 4:56:55 PM
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Triangle extends Shape {

  private boolean fill;
  private int[] xCoords = new int[3];
  private int[] yCoords = new int[3];

  /**
  Constructor for a new triangle.
  @param newX - x position.
  @param newY - y position.
  @param newColor - shape color.
  @param newWidth - shape width.
  @param newHeight  - shape height.
  @param newFill  - true for fill and false for draw.
   */
  public Triangle(int newX, int newY, Color newColor, int newWidth, int newHeight, boolean newFill) {
    super(newX, newY, newColor, newWidth, newHeight);
    fill = newFill;
    setCoords();
  }

  /**
  Based off the x and y position of the shape this generates the 3 x and 3 y coordinates to create the triangle.
   */
  public final void setCoords() {
    xCoords[0] = getX();
    xCoords[1] = getX() - (int) (getWidth() / 2);
    xCoords[2] = getX() + (int) (getWidth() / 2);
    yCoords[0] = getY() - (int) (getHeight() / 2);
    yCoords[1] = getY() + (getHeight() * 2);
    yCoords[2] = getY() + (getHeight() * 2);
  }

  /**
  Draws the shape
  @param g - the Graphics2D object to send the shape data to.
   */
  @Override
  public void draw(Graphics2D g) {
    Color current = g.getColor();
    g.setColor(this.getColor());
    if (fill) {
      g.fillPolygon(xCoords, yCoords, 3);
    } else {
      g.drawPolygon(xCoords, yCoords, 3);
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
    double x = test.getX();
    double y = test.getY();

    int hits = 0;
    int lastx = xCoords[2];
    int lasty = yCoords[2];
    int curx, cury;

    for (int i = 0; i < 3; lastx = curx, lasty = cury, i++) {
      curx = xCoords[i];
      cury = yCoords[i];
      if (cury == lasty) {
        continue;
      }
      int leftx;
      if (curx < lastx) {
        if (x >= lastx) {
          continue;
        }
        leftx = curx;
      } else {
        if (x >= curx) {
          continue;
        }
        leftx = lastx;
      }
      double test1, test2;
      if (cury < lasty) {
        if (y < cury || y >= lasty) {
          continue;
        }
        if (x < leftx) {
          hits++;
          continue;
        }
        test1 = x - curx;
        test2 = y - cury;
      } else {
        if (y < lasty || y >= cury) {
          continue;
        }
        if (x < leftx) {
          hits++;
          continue;
        }
        test1 = x - lastx;
        test2 = y - lasty;
      }
      if (test1 < (test2 / (lasty - cury) * (lastx - curx))) {
        hits++;
      }
    }
    return ((hits & 1) != 0);
  }
}
