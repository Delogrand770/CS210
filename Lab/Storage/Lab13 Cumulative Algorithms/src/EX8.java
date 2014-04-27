
/**
 * EX8 - Processes a students record data and reports the students gpa.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 7, 2011 at 5:12:08 PM
 */
import java.util.Scanner;

public class EX8 {

  public static void main(String[] args) {
    printGPA();
  }

  private static void printGPA() {
    Scanner ask = new Scanner(System.in);
    System.out.printf("Enter a student record: ");
    String name = ask.next();
    double total = ask.nextInt();
    double sum = 0;
    for (int i = 0; i < total; i++) {
      sum += ask.nextInt();
    }
    double gpa = sum / total;
    System.out.printf("%s's grade is %.2f\n", name, gpa);
  }
}
