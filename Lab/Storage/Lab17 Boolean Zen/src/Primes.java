
/**
 * Checks if a number is prime or not
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 19, 2011 at 3:14:40 PM
 */
public class Primes {

  public static void main(String[] args) {
    // test the isPrime method
    for (int j = 2; j <= 20; j++) {
      System.out.printf("Is %d prime?  %b\n", j, isPrime(j));
    }
  }

  //-------------------------------------------------------------------
  public static boolean isPrime(int n) {
    boolean prime = true;
    if (n % 2 == 0 && n!=2) { //Is the number even
      return false;
    }
    for (int i = 3; i < n; i++) { //Now only check odd numbers
      if (n % i == 0) {
        prime = false;
        break;
      } else {
        prime = true;
      }
      i++; //skips the even numbers
    }
    return prime;
  }
}
