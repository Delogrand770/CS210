
/**
 * EX1 - Reads a file that has names and ages and finds the total boys/girls and the abs difference in the sum of their ages
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 22, 2011 at 10:34:59 AM
 */
import java.io.*;
import java.util.*;

public class EX1 {

  public static void main(String[] args) {
    try {
      Scanner file = new Scanner(new File("names.txt"));
      boyGirl(file);
    } catch (IOException error) {
      System.out.println("Error in processing the file names.txt" + error);
    }
  }

  private static void boyGirl(Scanner file) {
    boolean isboy = true;
    int boys_sum = 0;
    int girls_sum = 0;
    int boy_count = 0;
    int girl_count = 0;
    while (file.hasNext()) {
      file.next();
      if (isboy) {
        boy_count++;
        boys_sum += file.nextInt();
      } else {
        girl_count++;
        girls_sum += file.nextInt();
      }
      isboy = !isboy;
    }
    System.out.println(boy_count + " boys, " + girl_count + " girls");
    System.out.println("Difference between boys' and girls' sums: " + Math.abs(boys_sum - girls_sum));
  }
}