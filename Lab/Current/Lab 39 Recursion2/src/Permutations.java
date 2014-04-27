
/**
 * Given a list of items, print all possible permutations of the items.
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Dec 5, 2011 at 9:02:13 AM
 */

public class Permutations {

  public static void main(String[] args) {
    listPermutations("abc");
  }

  public static void listPermutations(String items) {
    listPermutations("", items);
  }

  public static void listPermutations(String prefix, String items) {
    if (items.length() <= 0) {
      // base case -- there are no more items to add to the permutation
      System.out.println(prefix);
    } else {
      // Using the existing prefix, add each available item, remove
      // it from the available items, and recurse.
      for (int j = 0; j < items.length(); j++) {
        listPermutations(prefix + items.charAt(j), removeCharAt(items, j));
      }
    }
  }

  private static String removeCharAt(String s, int pos) {
    return s.substring(0, pos) + s.substring(pos + 1);
  }
}
