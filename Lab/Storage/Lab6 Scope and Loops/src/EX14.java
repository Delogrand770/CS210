
/**
 * EX14
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 16, 2011 at 8:07:34 PM
 */
public class EX14 {

  public static void main(String[] args) {
    final int LINES = 4;
    final int MAXNUM = 9;
    for (int i = 0; i < LINES; i++) {
      for (int j = MAXNUM; j >= 0; j--) {
        for (int k = 0; k < j; k++) {
          System.out.print(j);
        }
      }
      System.out.println();
    }
  }
}
