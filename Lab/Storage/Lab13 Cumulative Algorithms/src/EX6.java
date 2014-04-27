
/**
 * EX6 - Asks for x numbers based on users initial input then reports the largest and smallest numbers.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 7, 2011 at 5:11:59 PM
 */
import java.util.Scanner;

public class EX6 {

  public static void main(String[] args) {
    smallestLargest();
  }

  public static void smallestLargest() {
    Scanner ask = new Scanner(System.in);
    System.out.printf("How many numbers do you want to enter? ");
    int total = ask.nextInt();
    int min = 0;
    int max = 0;
    int current = 0;
    for (int i = 1; i <= total; i++) {
      System.out.printf("Number %d: ", i);
      current = ask.nextInt();
      if (current > max || i == 1) {
        max = current;
      }
      if (current < min || i == 1) {
        min = current;
      }
    }
    System.out.printf("Smallest = %d\n", min);
    System.out.printf("Largest = %d\n", max);
  }
}
