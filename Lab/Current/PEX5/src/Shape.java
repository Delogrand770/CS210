
/**
 * Shape - Represents a Shape object. This is the parent class of Triangle, Rectangle and Ellipse.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 17, 2011 at 4:44:44 PM
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Shape {

  private int height;
  private int width;
  private int xPos;
  private int yPos;
  private Color color;

  /**
  Constructor for a new shape.
  @param newX - x position.
  @param newY - y position.
  @param newColor - shape color.
  @param newWidth - shape width.
  @param newHeight  - shape height.
   */
  public Shape(int newX, int newY, Color newColor, int newWidth, int newHeight) {
    xPos = newX;
    yPos = newY;
    color = newColor;
    height = newHeight;
    width = newWidth;
  }

  /**
  Sets the shape height.
  @param newHeight 
   */
  public void setHeight(int newHeight) {
    height = newHeight;
  }

  /**
  Sets the shape width.
  @param newWidth 
   */
  public void setWidth(int newWidth) {
    width = newWidth;
  }

  /**
  Gets the shape height.
  @return 
   */
  public int getHeight() {
    return height;
  }

  /**
  Gets the shape width.
  @return 
   */
  public int getWidth() {
    return width;
  }

  /**
  Gets the shape x position.
  @return 
   */
  public int getX() {
    return xPos;
  }

  /**
  Gets the shape y position.
  @return 
   */
  public int getY() {
    return yPos;
  }

  /**
  Sets the shape x position.
  @param newX 
   */
  public void setX(int newX) {
    xPos = newX;
  }

  /**
  Sets the shape y position.
  @param newY 
   */
  public void setY(int newY) {
    yPos = newY;
  }

  /**
  Gets the shape color.
  @return 
   */
  public Color getColor() {
    return color;
  }

  /**
  Sets the shape color.
  @param newColor 
   */
  public void setColor(Color newColor) {
    color = newColor;
  }

  /**
  Checks to see if a test point is within the bounds of this shape.
  @param test - Point to test against.
  @return true if the point is within the shape and false if not.
   */
  public abstract boolean contains(Point test);

  /**
  Draws the shape
  @param g - the Graphics2D object to send the shape data to.
   */
  public abstract void draw(Graphics2D g);
}
