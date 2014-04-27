
/**
 * PEX1: Draws a rocket that scales based on the SIZE integer. DOC: I received
 * no help on this assignment
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 22, 2011 at 8:48:11 PM
 */
public class PEX1 {

    public static int SIZE = 1; //Not final so DrawRockets method works

    public static void main(String[] args) {
        DrawRocket();
        //DrawRockets(1, 6); //Uncomment to draw rockets scaled from 1 to 6
    }

    public static void DrawRocket() { //Draws a complete rocket
        Cone();
        Line();
        BoxA();
        BoxB();
        Line();
        BoxB();
        BoxA();
        Line();
        Cone();
        System.out.println();
    }

    public static void Cone() { //Draws the cone shape
        for (int line = 1; line <= SIZE * 2 - 1; line++) {
            Draw(SIZE * 2 - line, " ");
            Draw(line, "/");
            System.out.print("**");
            Draw(line, "\\");
            System.out.println();
        }
    }

    public static void Line() { //Draws the +=*+ line
        System.out.print("+");
        Draw(SIZE * 2, "=*");
        System.out.print("+");
        System.out.println();
    }

    public static void BoxA() { //Draws the Teepee half of the box
        for (int line = 1; line <= SIZE; line++) {
            System.out.print("|");
            Draw(SIZE - line, ".");
            Draw(line, "/\\");
            Draw(SIZE - line, "..");
            Draw(line, "/\\");
            Draw(SIZE - line, ".");
            System.out.print("|");
            System.out.println();
        }
    }

    public static void BoxB() { //Draws the V half of the box
        for (int line = 1; line <= SIZE; line++) {
            System.out.print("|");
            Draw(line - 1, ".");
            Draw(SIZE - line + 1, "\\/");
            Draw(line - 1, "..");
            Draw(SIZE - line + 1, "\\/");
            Draw(line - 1, ".");
            System.out.print("|");
            System.out.println();
        }
    }

    public static void Draw(int howmany, String text) { //Repeatedly draws a specified string
        for (int count = 0; count < howmany; count++) {
            System.out.print(text);
        }
    }

    public static void DrawRockets(int low, int high) { //Draws scaled rockets from the low to high param
        for (int i = low; i <= high; i++) {
            System.out.println("SIZE = " + i);
            System.out.println();
            SIZE = i;
            DrawRocket();
        }
    }
}
