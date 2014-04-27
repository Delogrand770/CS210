
/**
 * EX5 - Method readFile accepts the string of a filename and then returns the contents of the file not white space accurate
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 22, 2011 at 10:56:45 AM
 */
import java.io.*;
import java.util.*;

public class EX5 {

  public static void main(String[] args) {
    System.out.println(readFile("spacess.txt"));
  }

  private static String readFile(String filename) {
    String contents = "";
    try {
      Scanner input = new Scanner(new File(filename));
      while (input.hasNext()) {
        contents += input.next() + " ";
      }
    } catch (IOException error) {
      System.out.println("Error in processing the file " + filename + " \n" + error);
    }
    return contents;
  }
}