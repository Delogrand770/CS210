
/**
 * ObjectTest - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 24, 2011 at 2:12:31 PM
 */
public class ObjectTest {

  public static void main(String[] args) {
    MyPoint p1 = new MyPoint(10,100);
    System.out.println(p1.height);
    MyPoint p2 = new MyPoint(10,100,5,6);
    System.out.println(p2.height);
    System.out.println(p2.Area());
    p2.Move(5,100);
    System.out.println(p2.x + " " + p2.y);
    p2.Count();
    System.out.println(p2.GetCount());
  }
}
