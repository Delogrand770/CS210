
/**
 * Given 3 integers, find the median value. 
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 11, 2011 at 3:36:33 PM
 */
public class Median {

  public static void main(String[] args) {
    // Test cases
    System.out.println("Median of 1 2 3 is " + medianOf3(1, 2, 3));
    System.out.println("Median of 3 1 2 is " + medianOf3(3, 1, 2));
    System.out.println("Median of 2 1 3 is " + medianOf3(2, 1, 3));

    System.out.println("Median of 2 2 2 is " + medianOf3(2, 2, 2));
    System.out.println("Median of 2 2 3 is " + medianOf3(2, 2, 3));
    System.out.println("Median of 3 1 1 is " + medianOf3(3, 1, 1));

    System.out.println("Median of 3 2 1 is " + medianOf3(3, 2, 1));
    System.out.println("Median of 3 5 1 is " + medianOf3(3, 5, 1));
  }

  //-----------------------------------------------------------------
  // Preconditions: 3 integers are provided
  // Postconditions: Returns the middle integer
  public static int medianOf3(int n1, int n2, int n3) {
    int middle = 0;
    if ((n1 >= n2 && n1 <= n3) || (n1>=n3 && n1<=n2)) {
      middle = n1;
    }
    if ((n2 >= n3 && n2 <= n1) || (n2 >= n1 && n2 <= n3)) {
     middle = n2;
    }
    if ((n3 >= n1 && n3 <= n2) || (n3 >= n2 && n3 <= n1)) {
      middle = n3;
    }
    return middle;
  }
}
