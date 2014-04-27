
/**
 * Decimal Calcs
 *
 * @author C14Gavin.Delphia / C14Kenneth.King
 *
 * @version 1.0 - Aug 12, 2011 at 11:26:19 AM
 */

public class Challenge {

  public static void main(String[] args) {
int num_int = 3747;
int place_holder  = 4;
double last_num = num_int%(Math.pow(10,place_holder));
    last_num = (last_num/(Math.pow(10,place_holder)/(10)));
    System.out.println((int) last_num);
  }
}
