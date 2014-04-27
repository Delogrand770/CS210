
/**
 * An example program that writes data to a file.
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 27, 2011 at 12:53:06 PM
 */
import java.io.*;

public class Multiply2 {

  public static void main(String[] args) {
    try {
      PrintStream output = new PrintStream(new File("MultiplicationTable.txt"));
      multTable(output);
      multTable(System.out);
    } catch (IOException error) {
      System.out.println("An I/O error occurred: " + error);
    }
  }

  public static void multTable(PrintStream output) {
    output.print("    ");
    for (int i = 0; i <= 10; i++) {
      output.printf("%5d:", i);
    }
    output.print("\r\n");
    for (int j = 0; j <= 100; j++) {
      output.printf("%2d:", j);
      for (int i = 0; i <= 20; i++) {
        output.printf("%6d", (i * j));
      }
      output.printf("\r\n");
    }
  }
}
