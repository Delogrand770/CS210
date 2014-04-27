
/**
 * A Point object represents a location in a Cartesian coordinate system.
 *
 * @author Textbook, page 514
 *
 * @version 1.0   Fall 2011
 */
public class Point {

  private double radius;
  private double angle;

  /**
   * Default constructor. Creates a point at the origin.
   */
  public Point() {
    this(0, 0);
  }

  /**
   * Constructor that creates a point at the specified location.
   * 
   * @param x The x coordinate.
   * @param y The y coordinate.
   */
  public Point(int x, int y) {
    radius = toRadius(x, y);
    angle = toAngle(x, y);
  }

  private double toAngle(int x, int y) {
    return Math.atan2(y, x);
  }

  private double toRadius(int x, int y) {
    return Math.sqrt(x * x + y * y);
  }

  /**
   * Constructor that creates a duplicate point from the specified point.
   * 
   * @param p The point to duplicate.
   */
  public Point(Point p) {
    this(p.getX(), p.getY());
  }

  /**
   * Return the current value of the x coordinate.
   * 
   * @return the x coordinate.
   */
  public int getX() {
    return (int) Math.round(radius * Math.cos(angle));
  }

  /**
   * Return the current value of the y coordinate.
   * 
   * @return the y coordinate.
   */
  public int getY() {
    return (int) Math.round(radius * Math.sin(angle));
  }

  /**
   * Change the x coordinate of the point to the specified value.
   * 
   * @param newX The new value for the x coordinate.
   */
  public void setX(int newX) {
    int y = getY();
    radius = toRadius(newX, y);
    angle = toAngle(newX, y);
  }

  /**
   * Change the y coordinate of the point to the specified value.
   * 
   * @param newY The new value for the y coordinate.
   */
  public void setY(int newY) {
    int x = getX();
    radius = toRadius(x, newY);
    angle = toAngle(x, newY);
  }

  /**
   * Change the x and y coordinates of the point to the specified values.
   * 
   * @param newX The new value for the x coordinate.
   * @param newY The new value for the y coordinate.
   */
  public void setXY(int newX, int newY) {
    radius = toRadius(newX, newY);
    angle = toAngle(newX, newY);
  }

  /**
   * Convert the Point object to a string representation.
   * 
   * @return a string representation of the Point object.
   */
  @Override
  public String toString() {
    return "(" + getX() + "," + getY() + ")";
  }

  /**
   * Calculate the distance between this Point and another Point.
   * 
   * @param other The other point used in the distance calculation.
   * 
   * @return The distance between the two points.
   */
  public double distance(Point other) {
    int x = getX();
    int y = getY();
    int dx = x - other.getX();
    int dy = y - other.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

  /**
   * Calculate the distance of the point from the origin, (0,0).
   * 
   * @return  Returns the distance from the origin, (0,0).
   */
  public double distanceFromOrigin() {
    return radius;
  }

  /**
   * Calculate the angle of the Point from the origin
   * 
   * @return  Returns the angle between of the point with the origin in
   *          the range -pi to +pi.
   */
  public double angle() {
    return angle;
  }

  /**
   * Shifts this point's location by the given amount.
   * 
   * @param dx How much to shift the x coordinate
   * @param dy How much to shift the y coordinate
   */
  public void translate(int dx, int dy) {
    int newX = getX() + dx;
    int newY = getY() + dy;
    radius = toRadius(newX, newY);
    angle = toAngle(newX, newY);
  }
}
