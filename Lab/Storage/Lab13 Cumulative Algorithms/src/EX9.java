
/**
 * EX9 - Given 3 sides of a triangle it will determine the type of triangle
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 7, 2011 at 5:12:20 PM
 */
public class EX9 {

  public static void main(String[] args) {
    System.out.println(printTriangleType(5, 7, 7));
    System.out.println(printTriangleType(6, 6, 6));
    System.out.println(printTriangleType(5, 7, 8));
    System.out.println(printTriangleType(2, 18, 2));
  }

  private static String printTriangleType(int s1, int s2, int s3) {
    String type = "Side Lengths: " + s1 + "," + s2 + "," + s3 + "\nType: ";
    if (s1 + s2 < s3 || s1 + s3 < s2 || s2 + s3 < s1) {
      type += "Does not make a triangle\n";
    } else if (s1 == s2 && s2 == s3) {
      type += "Equilateral\n";
    } else if ((s1 == s2 && s2 != s3) || (s1 == s3 && s3 != s2) || (s2 == s3 && s3 != s1)) {
      type += "Isosceles\n";
    } else if (s1 != s2 && s2 != s3 && s1 != s3) {
      type += "Scalene\n";
    }
    return type;
  }
}
