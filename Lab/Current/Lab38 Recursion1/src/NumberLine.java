
/**
 * NumberLine - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Dec 2, 2011 at 10:28:48 AM
 */
public class NumberLine {

  public static void main(String[] args) {
    for (int j = 0; j <= 10; j++) {
      System.out.printf("numbersIterative(%d,10): ", j);
      numbersIterative(j, 10);
    }
    
    System.out.println();
    for (int j = 0; j <= 10; j++) {
      System.out.printf("numbersRecursive(%d,10): ", j);
      numbersRecursive(j, 10);
    }
  }

  public static void numbersIterative(int start, int end) {
    for (int i = start; i <= end; i++) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void numbersRecursive(int start, int end) {
    System.out.print(start + " ");
    if (start < end) {
      start++;
      numbersRecursive(start, end);
    }else{
      System.out.println();
    }
  }
}
