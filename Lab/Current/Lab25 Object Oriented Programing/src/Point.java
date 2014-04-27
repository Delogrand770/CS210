
/**
 * Point.java
 * Description: A Point object represents a pair of (x, y) coordinates.
 *
 * @author Textbook, page 514
 *
 * @version 1.0   Fall 2011
 */
public class Point {

  private int x;
  private int y;
  private String name;

  /**
  Creates a new Point and supplies the name identifier if needed
  @param data - A string that is used to identify the point
   */
  public Point(String data) {
    name = data;
  }

  /**
  Creates a new Point but does not specify any default values
   */
  public Point() {
  }

  /**
  Creates a new Point with a specific name and x and y value
  @param data - A string that is used to identify the point
  @param nx - A integer that is the new x point value
  @param ny - A integer that is the new y point value
   */
  public Point(String data, int nx, int ny) {
    name = data;
    x = nx;
    y = ny;
  }

  /**
  Creates a new Point with a specific x and y value
  @param nx - A integer that is the new x point value
  @param ny - A integer that is the new y point value
   */
  public Point(int nx, int ny) {
    x = nx;
    y = ny;
  }

  /**
  Not called directly, if a system.out of the point is called this will be sent to the console
  @return 
   */
  @Override
  public String toString() {
    String output = "[Point]";
    output += (name != null) ? "\n\tName = " + name : "";
    output += "\n\tx = " + x + "\n\ty = " + y;
    return output;
  }

  /**
  Returns the distance between this instance of a point and another point
  @param name - The variable name of the point to compare to
  @return 
   */
  public double distance(Point name) {
    return Math.sqrt(Math.pow(x - name.x, 2) + Math.pow(y - name.y, 2));
  }

  /**
  Changes the internal name of the Point
  @param data - A string that is the new name of the Point
   */
  public void setName(String data) {
    name = data;
  }

  /**
  Sets both the x and y values of the point
  @param n - A integer that is the new x point value
  @param i - A integer that is the new y point value
   */
  public void setXY(int n, int i) {
    x = n;
    y = i;
  }

  /**
  Sets the y value of the point
  @param n - A integer that is the new y point value
   */
  public void setY(int n) {
    y = n;
  }

  /**
  Sets the x value of the point
  @param n - A integer that is the new x point value
   */
  public void setX(int n) {
    x = n;
  }

  /**
  Returns the y value of the point
  @return a integer
   */
  public int getY() {
    return y;
  }

  /**
  Returns the x value of the point
  @return a integer
   */
  public int getX() {
    return x;
  }

  //-------------------------------------------------------------------
  /**
   * Return the distance the point is from the origin, (0,0)
   * 
   * @return  Return the distance the point is from the origin, (0,0)
   */
  public double distanceFromOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  //-------------------------------------------------------------------
  /**
   * Shifts this points location by the given amount.
   * 
   * @param dx How much to shift the x coordinate
   * @param dy How much to shift the y coordinate
   */
  public void translate(int dx, int dy) {
    x += dx;
    y += dy;
  }
}
