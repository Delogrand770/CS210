
/**
 * C4Player - A Connect 4 Player class
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 3, 2011 at 11:01:34 AM
 */
import javax.swing.JOptionPane;

public class C4Player {

  private String name;
  private int playerNum;
  private int playerType;
  //Player Types
  private final int HUMAN = 0;
  private final int COMPUTER = 1;
  private final int REMOTE = 2;

  /**
  Constructor for a new player. Sets the name and playerNum variables
  @param playerNumber - The number the player is 1 or 2
  @param playerType - The type of player modes listed as constants
   */
  public C4Player(int playerNumber, int whatType) {
    playerNum = playerNumber;
    playerType = whatType;
    if (playerType == HUMAN) {
      setName(playerNum);
    } else if (playerType == COMPUTER) {
      setName("Computer");
    } else if (playerType == REMOTE) {
      setName("Remote");
    }
  }

  /**
  Returns the player name
  @return name
   */
  public String getName() {
    return name;
  }

  /**
  Returns the player type. The types are declared as constants
  @return 
  */
  public int getType() {
    return playerType;
  }

  /**
  Sets a players name by prompting the user. Will not accept blank names
  @param num 
   */
  private void setName(int num) {
    boolean invalid = true;
    String ask = "Player" + num;
    while (invalid) {
      ask = JOptionPane.showInputDialog("What is your name player" + num + "?", ask);
      if (ask != null && ask.length() != 0) {
        invalid = false;
      }
    }
    name = ask;
  }

  /**
  Sets a players name by using the parameter defined.
  @param newName - The name of the player
   */
  private void setName(String newName) {
    name = newName;
  }
}