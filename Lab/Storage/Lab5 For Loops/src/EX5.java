
/**
 * Prints a staircase of *
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 16, 2011 at 10:40:54 AM
 */
public class EX5 {

  public static void main(String[] args) {
    for (int a = 1; a <= 5; a++) {
      for (int b = 1; b <= a; b++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
