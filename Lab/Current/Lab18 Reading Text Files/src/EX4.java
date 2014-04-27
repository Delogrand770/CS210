
/**
 * EX4 - Reads the file spaces.txt and displays its contents with extra white space removed
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 22, 2011 at 10:53:32 AM
 */
import java.io.*;
import java.util.*;

public class EX4 {

  public static void main(String[] args) {
    try {
      String nospaces = "";
      Scanner input = new Scanner(new File("spaces.txt"));
      while (input.hasNext()) {
        nospaces += input.next() + " ";
      }
      System.out.println(nospaces);

    } catch (IOException error) {
      System.out.println("Error in processing the file hamlet.txt" + error);
    }
  }
}
