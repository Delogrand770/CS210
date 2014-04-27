
/**
 * A program that deals with 2D points.
 *
 * @author Textbook, page 507
 *
 * @version 1.0   Fall 2008
 */
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;

public class Client_code {

  public static void main(String[] args) {
    Line l1 = new Line();
    Line l2 = new Line(10, 10, 20, 20);

    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);
    Line l3 = new Line(p1, p2);

    System.out.println(l1);
    System.out.println(l2);
    System.out.println(l3);
    
    l1.setP1X(10);
    l1.setP1Y(5);
    
    System.out.println(l1.getP1X());
    System.out.println(l1.getP1Y());

    DrawingPanel panel = new DrawingPanel(200, 200);
    Graphics2D g = panel.getGraphics();
    panel.setBackground(Color.white);
    g.setColor(Color.red);
    g.drawLine(l1.getP1X(), l1.getP1Y(), l1.getP2X(), l1.getP2Y());
    g.drawLine(l2.getP1X(), l2.getP1Y(), l2.getP2X(), l2.getP2Y());
    g.drawLine(l3.getP1X(), l3.getP1Y(), l3.getP2X(), l3.getP2Y());
    panel.copyGraphicsToScreen();
  }
}
