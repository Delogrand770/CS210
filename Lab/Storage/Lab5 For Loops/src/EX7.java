
/**
 * Outputs a stair of numbers
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 16, 2011 at 10:41:00 AM
 */
public class EX7 {

  public static void main(String[] args) {
    for (int a = 1; a <= 5; a++) {
      for (int b = 4; b >= a; b--) {
        System.out.print(" ");
      }
      for (int c = 1; c <= a; c++) {
        System.out.print(a);
      }
      System.out.println();
    }
  }
}
