
/**
 * A rewrite of Exercise 7 to include static methods. 
 * Since I used static methods the last time I added a for loop.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 8, 2011 at 10:38:27 AM
 */
public class EX7 {

  public static void main(String[] args) {
    Foward();
    for (int i = 0; i < 5; i++) {
      Combine();
    }
  }

  public static void Victory() {
    System.out.println("|| Victory is mine! ||");
  }

  public static void Foward() {
    System.out.println("//////////////////////");
  }

  public static void Back() {
    System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
  }

  public static void Combine() {
    Victory();
    Back();
  }
}
