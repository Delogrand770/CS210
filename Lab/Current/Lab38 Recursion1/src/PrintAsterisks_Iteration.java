
/**
 * Description: Prints zero of more stars on an output line.
 *
 * @author  Textbook, page 643
 *
 * @version 1.0   Fall 2008
 *
 */
public class PrintAsterisks_Iteration {
  //-------------------------------------------------------------------

  public static void main(String[] args) {
    // test cases to verify the correctness of the printAsterisks() method
    for (int j = 0; j < 10; j++) {

      System.out.printf("printAsterisks(%d): ", j);
      printAsterisks(j);
      System.out.println();
    }
  }

  //-------------------------------------------------------------------
  public static void printAsterisks(int howMany) {
    for (int j = 0; j < howMany / 2; j++) {
      System.out.print("*+");
    }
    if (howMany % 2 >= 0) {
      System.out.print("*");
    }
  }
}
