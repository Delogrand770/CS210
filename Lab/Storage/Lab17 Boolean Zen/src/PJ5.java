
/**
 * PJ5 - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 20, 2011 at 9:24:05 AM
 */
import java.util.Random;
import java.util.Scanner;

public class PJ5 {

  public static boolean playing = true;
  public static Scanner ask = new Scanner(System.in);
  public static int pwins = 0;
  public static int cwins = 0;

  public static void main(String[] args) {
    while (playAgain()) {
      int pmove = getPlayerMove();
      int cmove = getComputerMove();
      System.out.println("You throw " + convertMove(pmove) + " and the computer throws " + convertMove(cmove) + "."
                         + "\nWinner: " + getWinner(pmove, cmove)
                         + "     " + getScores());
    }
    System.out.println("Thanks for playing.\nFinal "+getScores());
  }

  public static String getScores() {
    return "Score: Computer=" + cwins + " Player=" + pwins;
  }

  public static boolean playAgain() {
    boolean invalid = true;
    String choice = "";
    do {
      System.out.print("Play? (y/n): ");
      choice = ask.next().toLowerCase();
      if (choice.compareToIgnoreCase("y") == 0 || choice.compareToIgnoreCase("n") == 0) {
        if (choice.compareToIgnoreCase("y") == 0) {
          playing = true;
        } else {
          playing = false;
        }
        invalid = false;
      }
    } while (invalid);
    return playing;
  }

  public static int getPlayerMove() {
    int pmove = 2;
    String move = "";
    boolean invalid = true;
    do {
      System.out.print("Rock, Paper, Scissors shoot: ");
      move = ask.next().toLowerCase();
      if (move.compareToIgnoreCase("rock") == 0 || move.compareToIgnoreCase("paper") == 0 || move.compareToIgnoreCase("scissors") == 0) {
        if (move.compareToIgnoreCase("rock") == 0) {
          pmove = 0;
        } else if (move.compareToIgnoreCase("paper") == 0) {
          pmove = 1;
        }
        invalid = false;
      }
    } while (invalid);
    return pmove;
  }

  public static int getComputerMove() {
    return new Random().nextInt(3);
  }

  public static String convertMove(int num) {
    String move = "scissors";
    if (num == 0) {
      move = "rock";
    } else if (num == 1) {
      move = "paper";
    }
    return move;
  }

  public static String getWinner(int pnum, int cnum) {
    String winner = "Player";
    cwins++;
    if (pnum == 0 && cnum == 1) { //paper beats rock
      winner = "Computer";
    } else if (pnum == 1 && cnum == 2) { //scissors beats paper
      winner = "Computer";
    } else if (pnum == 2 && cnum == 0) { //rock beats scissors
      winner = "Computer";
    } else if (pnum == cnum) {
      winner = "tie";
      cwins--;
    } else {
      cwins--;
      pwins++;
    }
    return winner;
  }
}
