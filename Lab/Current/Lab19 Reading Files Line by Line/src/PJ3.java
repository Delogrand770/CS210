
/**
 * PJ3 - Outputs the specified file and formats the content to match a java program
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 22, 2011 at 11:09:27 AM
 */
import java.io.*;
import java.util.*;

public class PJ3 {

  public static int indent = 0;
  public static int deltaIndent = 4;

  public static void main(String[] args) {
    //filename = "SRC/PJ3.java";
    Scanner ask = new Scanner(System.in);
    System.out.print("Enter a java filename: ");
    String filename = ask.next();
    try {
      Scanner input = new Scanner(new File(filename));
      String output = "";
      while (input.hasNextLine()) {
        String line = input.nextLine();
        Scanner parseLine = new Scanner(line);
        boolean firstInLine = true;

        while (parseLine.hasNext()) {
          String token = parseLine.next();
          if (token.equalsIgnoreCase("{")) {
            indent += deltaIndent;
          } else if (token.equalsIgnoreCase("}")) {
            indent -= deltaIndent;
          }
          if (firstInLine) {
            firstInLine = false;
            output += "\n" + indents(indent);
          }
          output += " " + token;
        }

      }
      System.out.println(output);
    } catch (IOException error) {
      System.out.println("Error in processing the file " + filename + "\n" + error);
    }
  }

  public static String indents(int num) throws IOException {
    String output = "";
    for (int i = 0; i < num; i++) {
      output += " ";
    }
    return output;
  }
}
