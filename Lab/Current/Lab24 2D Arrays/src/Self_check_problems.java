
/**
 * Self_check_problems - 27,28,29,30
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Oct 12, 2011 at 10:09:48 AM
 */
import java.util.Random;

public class Self_check_problems {

  //ex27
  public static void main(String[] args) {
    Random gen = new Random();
    int[][] data = new int[4][7];
    for (int i = 0; i < data[3].length; i++) {
      data[3][i] = i + 1;
    }

    //ex28
    int[][] data2 = new int[5][10];
    for (int i = 0; i < data2.length; i++) {
      for (int j = 0; j < data2[i].length; j++) {
        data2[i][j] = i * j;
      }
    }

    //Random array data for ex29
    int[][] matrix = new int[6][8];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = gen.nextInt(100);
      }
    }


    //ex29
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][5] = matrix[i][2];
    }

    //ex30
    int jagged[][] = new int[5][];
    int index = 1;
    for (int i = 0; i < jagged.length; i++) {
      jagged[i] = new int[i + 1];
      for (int j = 0; j < jagged[i].length; j++) {
        jagged[i][j] = index;
        index++;
      }
    }
  }
}
