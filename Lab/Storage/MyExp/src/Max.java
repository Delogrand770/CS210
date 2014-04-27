
/**
 * Max - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 12, 2011 at 10:48:57 AM
 */
public class Max {

  public static void main(String[] args) {
    System.out.println(maxNum(5,10));
    System.out.println(maxNum(10,5));
  }

  public static int maxNum(int n1, int n2) {
    int test = (n1>n2)?n1:n2;
    return test;
  }
}
