
/**
 * PJ1 - Draws a pattern using variables instead of complex equations.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 26, 2011 at 11:38:07 AM
 */
public class PJ1 {

  public static int SIZE = 20;

  public static void main(String[] args) {
    int numfslash = SIZE * 2;
    int numbslash = 0;
    int numstar = SIZE - 1;
    int numspace = 1;
    for (int i = 1; i <= SIZE; i++) {
      Draw(numstar, "*");
      Draw(numspace, " ");
      Draw(numfslash, "/");
      Draw(numbslash, "\\");
      Draw(numspace, " ");
      Draw(numstar, "*");
      numstar--;
      numspace++;
      numbslash += 2;
      numfslash -= 2;
      System.out.println();
    }
  }

  public static void Draw(int howmany, String text) { //Repeatedly draws a specified string
    for (int j = 0; j < howmany; j++) {
      System.out.print(text);
    }
  }
}
