
/**
 * EXS_3_4_11 - Converts int to binary, generates lines of x's until x's in line are > 16, flips a coin until 3 consecutive heads occur
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 15, 2011 at 4:27:47 PM
 */
import java.util.Random;

public class EXS_3_4_11 {

  public static void main(String[] args) {
    System.out.println(toBinary(44));
    randomX();
    threeHeads();
    System.out.println();
  }

  private static String toBinary(int i) {
    String binary = "";
    while (i > 0) {
      if (i % 2 == 0) {
        binary = "0" + binary;
      } else {
        binary = "1" + binary;
      }
      i = (int) (i / 2);
    }
    return binary;
  }

  private static void randomX() {
    Random gen = new Random();
    int x = 0;
    String inj = "";
    do {
      inj = "";
      x = 5 + gen.nextInt(20 - 5 + 1);
      for (int i = 0; i < x; i++) {
        inj += "x";
      }
      System.out.println(inj);
    } while (x < 17);
  }

  private static void threeHeads() {
    Random gen = new Random();
    int h = 0;
    boolean bol = true;
    while(h<3){
      bol = gen.nextBoolean();
      if (bol){
        h++;
        System.out.print("H ");
      }else{
        h=0;
        System.out.print("T ");
      }
    }
  }
}