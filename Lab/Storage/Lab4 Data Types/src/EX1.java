
/**
 * Calculates final speed in physics
 *
 * @author C14Gavin.Delphia / C14Kenneth.King
 *
 * @version 1.0 - Aug 12, 2011 at 11:10:34 AM
 */
public class EX1 {

  public static void main(String[] args) {

    double s_final;
    double s_int = 10;
    double v_int = 10;
    double a = .5;
    double t = 5;

    s_final = (s_int + (v_int * t) + (.5 * a * t * t));
    System.out.println(s_final);
  }
}
