
/**
 * EX8 Solves a quadratic when given a,b,c and returns the larger of the two roots
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 24, 2011 at 10:56:22 AM
 */
public class EX8 {

  public static void main(String[] args) {
    System.out.println(SolveQuad(1, -7, 12));
    System.out.println(SolveQuad(1, 3, 2));
  }

  public static double SolveQuad(int a, int b, int c) {
    double sqrt = Math.sqrt(b * b - (4 * a * c));
    double ans_plus = (-b + sqrt) / (2 * a);
    double ans_minus = (-b - sqrt) / (2 * a);
    return Math.max(ans_plus, ans_minus);
  }
}
