/**
 * EXS - EX 6, 7, 8, 12
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Oct 5, 2011 at 9:50:20 AM
 */
import java.util.Arrays;
import java.util.Random;

public class EXS {

  public static void main(String[] args) {
    Random gen = new Random();
    int[] testdata = {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
//    //Exercise 6 Test Case
//    for (int i = 0; i < 5; i++) {
//      printArray("testdata", testdata);
//      System.out.println("stdev for above array: " + stdev(testdata));
//      System.out.println();
//      testdata = createRandomArray(10, -100, 100);
//    }

//    //Exercise 7 Test Case
//    for (int i = 0; i < 5; i++) {
//      testdata = createRandomArray(10, -100, 100);
//      Arrays.sort(testdata);
//      printArray("testdata", testdata);
//      System.out.println("k="+i+"; " + kthLargest(testdata,i));
//      System.out.println();
//    }

//    //Exercise 8 Test Case
//    for (int i = 0; i < 5; i++) {
//      testdata = createRandomArray(11, -100, 100);
//      Arrays.sort(testdata);
//      printArray("testdata", testdata);
//      System.out.println("median is "+ median(testdata));
//      System.out.println();
//    }

//    //Exercise 12 Test Case
//    for (int i = 0; i < 5; i++) {
//      int price = gen.nextInt(80);
//      testdata = createRandomArray(3, 1, 100);
//      printArray("bids", testdata);
//      System.out.println("The best bid is " + priceIsRight(testdata, price) + " when the price is " + price);
//      System.out.println();
//    }

  }

  /**
  Determines the closest bid to the price that doesn't go over.
  Returns -1 if all bids are over price.
  
  @param bids an array of integers that are the contestant bids.
  @param price an integer that is the actual price
  @return an integer that is either the closest bid or -1 if all bids are over price
   */
  public static int priceIsRight(int[] bids, int price) {
    int bestbid = -1;
    for (int i = 0; i < bids.length; i++) {
      bestbid = (bids[i] <= price && bids[i] > bestbid) ? bids[i] : bestbid;
    }
    return bestbid;
  }

  /**
  Determines the median out of an array of integers.
  
  @param data an array of integers
  @return the median integer
   */
  public static int median(int data[]) { //assumes the array has an odd number of elements. Even length.
    return data[data.length / 2];
  }

  /**
  Determines the kth largest integer in an array of integers.
  
  @param data an array of integers
  @param k an integer of what # highest value in the array you want. k=0 is 1st highest
  @return the kth largest integer
   */
  public static int kthLargest(int[] data, int k) {
    Arrays.sort(data);
    return data[data.length - k - 1];
  }

  /**
  Determines the standard deviation of an array of integers.
  
  @param data an array of integers
  @return a double that is the standard deviation of the array.
   */
  public static double stdev(int[] data) {
    double stdev = 0.0;
    double average = average(data);
    for (int i = 0; i < data.length; i++) {
      stdev += (double) Math.pow(data[i] - average, 2) / (double) (data.length - 1);
    }
    return Math.sqrt(stdev);
  }

  /**
  Determines the average value of an array of integers.
  
  @param data an array of integers
  @return a double that is the average value of the array
   */
  public static double average(int[] data) {
    double average = 0;
    for (int i = 0; i < data.length; i++) {
      average += (double) data[i];
    }
    average /= (double) data.length;
    return average;
  }

  /**
  Creates an integer array of the specified size and fills it with 
  random values in the range [minValue, maxValue] inclusive.
  
  @param size The desired size of the integer array
  @param minValue The minimum value of any element in the array.
  @param maxValue The maximum value of any element in the array.
  @return The array that was created.
   */
  public static int[] createRandomArray(int size, int minValue, int maxValue) {
    int[] array = new int[size];

    for (int j = 0; j < size; j++) {
      array[j] = minValue + (int) (Math.random() * (maxValue - minValue + 1));
    }

    return array;
  }

  /**
  Prints all the elements of an integer array on a single line. The
  array is labeled using the specified name. A line above the array
  elements is printed to show the index/location of each element.
  
  @param name A string to display that labels the array.
  @param a The integer array to be printed.
   */
  public static void printArray(String name, int[] a) {

    if (a.length > 0) {
      // Print the indexes so that the position of an element is easy determined.
      System.out.printf("%" + name.length() + "s   ", " ");
      for (int j = 0; j < a.length; j++) {
        System.out.printf("%6d", j);
      }
      System.out.println();

      // Print the element values
      System.out.printf("%s : ", name);
      System.out.printf("  %4d", a[0]);
      for (int j = 1; j < a.length; j++) {
        System.out.printf(", %4d", a[j]);
      }
    }
    System.out.println();
  }
}