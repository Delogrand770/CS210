
/**
 * EX8 Solves a quadratic when given a,b,c
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 22, 2011 at 10:31:22 AM
 */
public class EX8 {

  public static void main(String[] args) {
    SolveQuad(1, -7, 12);
    SolveQuad(1, 3, 2);

  }

  public static void SolveQuad(int a, int b, int c) {
    double sqrt = Math.sqrt(b * b - (4 * a * c));
    double ans_plus = (-b + sqrt) / (2 * a);
    double ans_minus = (-b - sqrt) / (2 * a);
    System.out.print(a + "x^2+(" + b + ")x+(" + c + "): x = " + ans_plus + ",x = " + ans_minus);
    System.out.println();
  }
}
