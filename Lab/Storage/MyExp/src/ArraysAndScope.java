
/**
 * <put a program description here>
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 8, 2011 at 4:15:04 PM
 */
public class ArraysAndScope {

    public static void main(String[] args) {
        int[] test = {1, 2, 3}; //array int method 1
        int[] test2 = new int[2]; //array int method 2
        test2[0] = 1;
        test2[1] = 2;

        Test(); //scope test

        System.out.println(test2); //not sure what this is pringing. Maybe variable ID?
        System.out.println(test2[0]);
        System.out.println(test2[1]);
        System.out.println("");

        System.out.println(test); //not sure what this is pringing. Maybe variable ID?
        System.out.println(test[0]);
        System.out.println(test[1]);
        System.out.println(test[2]);
        System.out.println("");

        System.out.println("test length = " + test.length); //array length test

        for (int i = 0; i < test.length; i++) { //navigate array via for loop
            System.out.println(test[i]);
        }
        System.out.println("");
    }

    public static void Test() {
        int test = 20;
        System.out.println("Scope Test: " + test);
    }
}
