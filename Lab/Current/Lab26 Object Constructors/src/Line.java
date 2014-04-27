
/**
 * Line.java
 * Description: A Line object that represents two points
 *
 * @author Textbook, page 514
 *
 * @version 1.0   Fall 2011
 */
import java.awt.Point;

public class Line {

  private Point end1;
  private Point end2;

  public void setP1X(int x) {
    end1.x = x;
  }

  public void setP2X(int x) {
    end2.x = x;
  }

  public void setP1Y(int y) {
    end1.y = y;
  }

  public void setP2Y(int y) {
    end2.y = y;
  }

  public int getP1X() {
    return end1.x;
  }

  public int getP1Y() {
    return end1.y;
  }

  public int getP2X() {
    return end2.x;
  }

  public int getP2Y() {
    return end2.y;
  }

  public Line() {
    this(new Point(0, 0), new Point(1, 1));
  }

  public Line(int x1, int y1, int x2, int y2) {
    this(new Point(x1, y1), new Point(x2, y2));
  }

  public Line(Point p1, Point p2) {
    end1 = new Point(p1);
    end2 = new Point(p2);
  }

  @Override
  public String toString() {
    return "Line is from " + end1 + " to " + end2;
  }
}
