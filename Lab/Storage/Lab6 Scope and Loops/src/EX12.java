
/**
 * EX12
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 16, 2011 at 8:07:34 PM
 */
public class EX12 {

  public static void main(String[] args) {
    final int LINES = 3;
    final int MAXNUM = 9;
    final int REPNUM = 3;
    for (int i = 0; i < LINES; i++) {
      for (int j = 0; j <= MAXNUM; j++) {
        for (int k = 0; k < REPNUM; k++) {
          System.out.print(j);
        }
      }
      System.out.println();
    }
  }
}
