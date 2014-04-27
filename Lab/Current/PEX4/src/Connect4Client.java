
/**
 * Connect4Client - A Connect 4 Client
 *
 * Documentation: I Googled how to create the option pane with the 3 buttons, 
 * I Googled how to get the size of the screen and I Googled how to get the
 * current time in millis.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 3, 2011 at 10:59:57 AM
 */
import java.awt.*;
import javax.swing.*;

public class Connect4Client {

  public static C4Player[] players = new C4Player[2];
  private static C4Board board = null;
  private static final int WINCOND = 4;
  private static final int PIECESIZE = 64;

  public static void main(String[] args) {
    int mode = askMode();
    if (mode != -1) {
      while (board.getWinner() == null) {
        board.waitForMove();
        board.nextPlayer();
        if (board.isFull()) {
          board.tieGame();
          break;
        }
      }
      if (!board.isTieGame()) {
        board.displayWinner();
      }
    }
  }

  /**
  Prompts the user for the number of columns and rows to play with
  Also calls board.clear()
  @param mode 
   */
  public static void boardSetup(int mode) {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    int max_columns = Math.round(screenWidth / PIECESIZE);
    int max_rows = Math.round(screenHeight / PIECESIZE) - 1;
    int rows = 0;
    int columns = 0;
    boolean invalid = true;
    String ask = null;
    
    while (invalid) {
      ask = JOptionPane.showInputDialog("How many columns should we have? Max of " + max_columns, "7");
      if (ask != null) {
        try {
          columns = Integer.parseInt(ask);
          if (columns >= WINCOND && columns <= max_columns) {
            invalid = false;
          }
        } catch (NumberFormatException error) {
          invalid = true;
        }
        
      }
    }

    invalid = true;
    while (invalid) {
      ask = JOptionPane.showInputDialog("How many rows should we have? Max of " + max_rows, "6");
      if (ask != null) {
        try {
          rows = Integer.parseInt(ask);
          if (rows >= WINCOND && rows <= max_rows) {
            invalid = false;
          }
        } catch (NumberFormatException error) {
          invalid = true;
        }
      }
    }

    board = new C4Board(columns, rows, mode);
    board.clear();
  }

  /**
  Brings up a pane with 3 buttons so the user can choose what game
  mode they would like to play
  @param mode 
   */
  public static int askMode() {
    String[] options = {"Human v. Human",
                        "Human v. Computer",
                        "Human v. Remote"};
    int mode = JOptionPane.showOptionDialog(null, "How would you like to play?",
                                            "Select a game mode", JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
    if (mode != -1) {
      boardSetup(mode);
    }
    return mode;
  }
}
