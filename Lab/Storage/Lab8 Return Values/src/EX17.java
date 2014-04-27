
/**
 * Draws the pattern using procedural decomposition and parameters
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 24, 2011 at 10:22:06 AM
 */
public class EX17 {

  public static final int HEIGHT = 4;

  public static void main(String[] args) {
    PrintLines();
  }

  public static void PrintLines() {
    for (int lines = 0; lines < HEIGHT; lines++) {
      Draw(lines, "\\\\");
      Draw((HEIGHT * 2) - (2 * (lines + 1)) + 1, "!!");
      Draw(lines, "//");
      System.out.println();
    }
  }

  public static void Draw(int howmany, String text) { //Repeatedly draws a specified string
    for (int j = 0; j < howmany; j++) {
      System.out.print(text);
    }
  }
}
