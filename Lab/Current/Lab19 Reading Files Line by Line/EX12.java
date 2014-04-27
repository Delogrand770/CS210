
/**
 * EX12 - Detects how many consecutive repeats of a word in a line exist
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 26, 2011 at 2:51:37 PM
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EX12 {

  public static void main(String[] args) {
    try {
      Scanner input = new Scanner(new File("Exercise12_data.txt"));

      while (input.hasNextLine()) {
        Scanner parser = new Scanner(input.nextLine());
        String oldToken = "";
        String newToken = "";
        boolean hit = false;
        int count = 0;
        while (parser.hasNext()) {
          if (count == 0) {
            newToken = parser.next();
            count = 1;
          } else {
            oldToken = newToken;
            newToken = parser.next();
            if (areSame(oldToken, newToken)) {
              count++;
            } else {
              if (count > 1) {
                hit = true;
                System.out.print(oldToken + "*" + count + " ");
              }
              count = 1;
            }
            //System.out.println("oldToken = "+oldToken+"\nnewToken = "+newToken+"\ncount = "+count);
          }
        }
        if (areSame(oldToken, newToken)) {
          if (count > 1) {
            hit = true;
            System.out.print(oldToken + "*" + count + " ");
          }
        }
        if (hit) {
          System.out.println();
        }
      }

    } catch (IOException error) {
      System.out.println("Error in processing the file hamlet.txt" + error);
    }
  }

  public static boolean areSame(String a, String b) {
    return (a.equalsIgnoreCase(b));
  }
}
