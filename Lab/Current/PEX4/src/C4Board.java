
/**
 * C4Board - A Connect 4 Board class
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Nov 3, 2011 at 11:01:43 AM
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;
import javax.swing.JOptionPane;

public class C4Board {
//Piece image holders

  private static BufferedImage red_image = null;
  private static BufferedImage blue_image = null;
  private static BufferedImage empty_image = null;
  private static int columnsTotal = 0;
  private static int rowsTotal = 0;
  private static final int OFFSET_Y = 30;
  private static final int PIECESIZE = 64;
  private final int WINCOND = 4;
  private final int MOVEDELAY = 250;
  private static int winWidth = 0;
  private static int winHeight = 0;
  private DrawingPanel panel;
  private Graphics2D g;
  private static int playerCount = 1;
  private static C4Player player1 = null;
  private static C4Player player2 = null;
  private int whosTurn;
  private C4Player winner;
  private C4Player[][] boardData;
  private boolean gameTied = false;
  //Game Modes
  private static final int HUMANVHUMAN = 0;
  private static final int HUMANVCOMPUTER = 1;
  private static final int HUMANVREMOTE = 2;
  //Player Types
  private static final int HUMAN = 0;
  private static final int COMPUTER = 1;
  private static final int REMOTE = 2;

  /**
  Constructor for a new board
  @param rows - number or rows on the board
  @param columns - number of columns on the board
  @param mode  - The type opponent. Listed as constants above
   */
  public C4Board(int numColumns, int numRows, int mode) {
    columnsTotal = numColumns;
    rowsTotal = numRows;
    winner = null;
    boardData = new C4Player[columnsTotal][rowsTotal];

    if (mode == HUMANVHUMAN) {
      player1 = new C4Player(playerCount, HUMAN);
      playerCount++;
      player2 = new C4Player(playerCount, HUMAN);
    } else if (mode == HUMANVCOMPUTER) {
      player1 = new C4Player(playerCount, HUMAN);
      playerCount++;
      player2 = new C4Player(playerCount, COMPUTER);
    } else if (mode == HUMANVREMOTE) {
      player1 = new C4Player(playerCount, HUMAN);
      playerCount++;
      player2 = new C4Player(playerCount, REMOTE);
    }
    whoIsFirst();
  }

  /**
  Applies the default settings the board needs such as window
  dimensions, loads images for pieces, sets the window title and draws 
  the initial board.
   */
  private void defaultSettings() {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    winWidth = PIECESIZE * boardData.length;
    winHeight = (PIECESIZE * boardData[0].length) + OFFSET_Y;
    panel = new DrawingPanel(winWidth, winHeight);
    //requres "DrawingPanel JFrame frame" to be public
    panel.frame.setLocation(new Point(screenWidth / 2 - panel.frame.getSize().width / 2,
                                      screenHeight / 2 - panel.frame.getSize().height / 2)); 
    
    //URL url = getClass().getResource("./");
    String url = "./images/";
    red_image = panel.loadBitmap(url + "red.png");
    blue_image = panel.loadBitmap(url + "blue.png");
    empty_image = panel.loadBitmap(url + "empty.png");
    
    panel.setWindowTitle("Connect 4: " + player1.getName() + " v. " + player2.getName());
    g = panel.getGraphics();
    panel.setBackground(Color.white);
    draw();
    panel.copyGraphicsToScreen();
  }

  /**
  Prompts the user to choose which player will go first
  Accepts a 1 or a 2 and offers a random valid choice
  @param mode 
   */
  private void whoIsFirst() {
    Random gen = new Random();
    boolean invalid = true;
    String ask = null;
    while (invalid) {
      ask = JOptionPane.showInputDialog("Should player 1 or 2 go first?", gen.nextInt(2) + 1);
      if (ask != null) {
        try {
          whosTurn = Integer.parseInt(ask);
          if (whosTurn == 1 || whosTurn == 2) {
            invalid = false;
          }
        } catch (NumberFormatException error) {
          invalid = true;
        }
      }
    }
    defaultSettings();
  }

  /**
  Returns the winner of the game. Defaults to null
  @return winner
   */
  public C4Player getWinner() {
    return winner;
  }

  /**
  Waits for a players move based on their type and then calls
  checkForWin() to see if that player has won
   */
  public void waitForMove() {
    boolean hasNotMoved = true;
    C4Player currentPlayer = getCurrentPlayer();
    g.drawString(getCurrentPlayer().getName() + "'s turn", 10, 20);
    panel.copyGraphicsToScreen();
    int type = currentPlayer.getType();
    if (type == HUMAN) {
      while (hasNotMoved) {
        if (panel.mouseClickHasOccurred(DrawingPanel.LEFT_BUTTON)) {
          int mouseX = panel.getMouseClickX(DrawingPanel.LEFT_BUTTON);
          int mouseY = panel.getMouseClickY(DrawingPanel.LEFT_BUTTON);
          int column = getColumnFromClick(mouseX, mouseY);
          int row = (column != -1) ? nextInColumn(column) : -1;
          if (column != -1 && row != -1) {
            if (whosTurn == 1) {
              boardData[column][row] = player1;
            } else {
              boardData[column][row] = player2;
            }
            hasNotMoved = false;
            checkForWin(column, row);
          }
        }
        delay(.01);
      }
    } else if (type == COMPUTER) {
      getAIMove();
    } else if (type == REMOTE) {
      getRemoteMove();
    }
    draw();
    panel.copyGraphicsToScreen();
  }

  /**
  Delays the program by n seconds
  @param seconds 
   */
  public void delay(double seconds) {
    long iTime, fTime;
    iTime = System.currentTimeMillis();
    do {
      fTime = System.currentTimeMillis();
    } while (fTime - iTime < seconds * 1000);
  }

  /**
  Returns the respective column the mouse has clicked
  @param x - Mouse x position
  @param y - Mouse y position
  @return 
   */
  public int getColumnFromClick(int x, int y) {
    int move = 0;
    if (y <= OFFSET_Y) {
      move = -1;
    } else {
      move = Math.round(x / PIECESIZE);
    }
    return move;
  }

  /**
  Checks to see if any on the sub win checking functions return true
  and if they do sets the winner to the current player.
  @param column - Last played
  @param row - Last played
   */
  public void checkForWin(int column, int row) {
    C4Player tokenToMatch = boardData[column][row];
    boolean winInColumn = checkForColumnWin(tokenToMatch, column);
    boolean winInRow = checkForRowWin(tokenToMatch, row);
    boolean winInDiagRight = checkForDiagRightWin(tokenToMatch, column, row);
    boolean winInDiagLeft = checkForDiagLeftWin(tokenToMatch, column, row);
    if (winInColumn || winInRow || winInDiagRight || winInDiagLeft) {
      setWinner(tokenToMatch);
    }
  }

  /**
  Checks for a win from left to right diagonally based on a column and 
  row number. Checks the win for the player passed in with token.
  @param token - C4Player to check win for
  @param column - The column last played
  @param row - The row last played
  @return 
   */
  public boolean checkForDiagRightWin(C4Player token, int column, int row) {
    while (row != 0 && row != rowsTotal - 1 && column != 0 && column != columnsTotal - 1) {
      row++;
      column--;
    }
    int max = (row >= columnsTotal - column) ? columnsTotal - column : row;
    int consecutive = 0;
    int count = 0;
    while (count < max) {
      if (boardData[column][row] == token) {
        consecutive++;
      } else {
        if (consecutive < WINCOND) {
          consecutive = 0;
        }
      }
      row--;
      column++;
      count++;
    }
    return (consecutive >= WINCOND) ? true : false;
  }

  /**
  Checks for a win from right to left diagonally based on a column and 
  row number. Checks the win for the player passed in with token.
  @param token - C4Player to check win for
  @param column - The column last played
  @param row - The row last played
  @return 
   */
  public boolean checkForDiagLeftWin(C4Player token, int column, int row) {
    while (row != 0 && row != rowsTotal - 1 && column != 0 && column != columnsTotal - 1) {
      row++;
      column++;
    }
    int max = (row >= column) ? column : row;
    int consecutive = 0;
    int count = 0;
    while (count < max) {
      if (boardData[column][row] == token) {
        consecutive++;
      } else {
        if (consecutive < WINCOND) {
          consecutive = 0;
        }
      }
      row--;
      column--;
      count++;
    }
    return (consecutive >= WINCOND) ? true : false;
  }

  /**
  Checks for a win in a column based on a column number. 
  Checks the win for the player passed in with token.
  @param token - C4Player to check win for
  @param column - The column last played
  @return 
   */
  public boolean checkForColumnWin(C4Player token, int column) {
    int consecutive = 0;
    for (int i = 0; i < rowsTotal; i++) {
      if (boardData[column][i] == token) {
        consecutive++;
      } else {
        if (consecutive < WINCOND) {
          consecutive = 0;
        }
      }
    }
    return (consecutive >= WINCOND) ? true : false;
  }

  /**
  Checks for a win in a row based on a row number. 
  Checks the win for the player passed in with token.
  @param token - C4Player to check win for
  @param column - The column last played
  @return 
   */
  public boolean checkForRowWin(C4Player token, int row) {
    int consecutive = 0;
    for (int i = 0; i < columnsTotal; i++) {
      if (boardData[i][row] == token) {
        consecutive++;
      } else {
        if (consecutive < WINCOND) {
          consecutive = 0;
        }
      }
    }
    return (consecutive >= WINCOND) ? true : false;
  }

  /**
  Draws the end game notification when a player has won
   */
  public void displayWinner() {
    draw();
    g.drawString(getWinner().getName() + " Wins!!!", 10, 20);
    panel.copyGraphicsToScreen();
  }

  /**
  Returns the next open position in the provided column and returns
  -1 if the column is full
  @param column - The column number to look in
  @return 
   */
  public int nextInColumn(int column) {
    int next = -1;
    for (int i = rowsTotal - 1; i > -1; i--) {
      if (boardData[column][i] == null) {
        next = i;
        break;
      }
    }
    return next;
  }

  /**
  Picks a random column and if it is not full places a computer piece.
  It then checks to see if the computer has won
   */
  private void getAIMove() {
    panel.sleep(MOVEDELAY);
    Random gen = new Random();
    boolean hasNotMoved = true;
    int column = gen.nextInt(columnsTotal);
    while (nextInColumn(column) == -1) {
      column = gen.nextInt(columnsTotal);
    }
    while (hasNotMoved) {
      int row = nextInColumn(column);
      if (column != -1 && row != -1) {
        if (whosTurn == 1) {
          boardData[column][row] = player1;
        } else {
          boardData[column][row] = player2;
        }
        hasNotMoved = false;
        checkForWin(column, row);
      }
      column++;
    }
  }

  /**
  Waits for the Remote players move, currently just makes a computer
  move
   */
  public void getRemoteMove() {
    getAIMove();
  }

  /**
  Changes the whosTurn variable from 1 to 2 and back
   */
  public void nextPlayer() {
    whosTurn = (whosTurn == 1) ? 2 : 1;
  }

  /**
  Returns the current player, 1 or 2
  @return 
   */
  public C4Player getCurrentPlayer() {
    return (whosTurn == 1) ? player1 : player2;
  }

  /**
  Sets the winner of the game
  @param newWinner - Name of the winner
   */
  public void setWinner(C4Player newWinner) {
    winner = newWinner;
  }

  /**
  Fills all arrays values of boardData with null
   */
  public void clear() {
    for (int i = 0; i < columnsTotal; i++) {
      for (int j = 0; j < rowsTotal; j++) {
        boardData[i][j] = null;
      }
    }
  }

  /**
  Returns a boolean that is true if the game is tied
  @return 
   */
  public boolean isTieGame() {
    return gameTied;
  }

  /**
  Displays the tie game notification when all spaces on the board are
  full and there is not a winner
   */
  public void tieGame() {
    draw();
    g.drawString("Tie Game", 10, 20);
    panel.copyGraphicsToScreen();
    gameTied = true;
  }

  /**
  Returns true if all spaces in the board are full.
  @return 
   */
  public boolean isFull() {
    boolean isFull = true;
    for (int i = 0; i < columnsTotal; i++) {
      for (int j = 0; j < rowsTotal; j++) {
        if (boardData[i][j] == null) {
          isFull = false;
          break;
        }
      }
    }
    return isFull;
  }

  /**
  Draws the game board
   */
  private void draw() {
    panel.setBackground(Color.white);
    for (int i = 0; i < columnsTotal; i++) {
      for (int j = 0; j < rowsTotal; j++) {
        if (boardData[i][j] == null) {
          g.drawImage(empty_image, i * PIECESIZE, j * PIECESIZE + OFFSET_Y, PIECESIZE, PIECESIZE, null);
        } else if (boardData[i][j] == player1) {
          g.drawImage(red_image, i * PIECESIZE, j * PIECESIZE + OFFSET_Y, PIECESIZE, PIECESIZE, null);
        } else if (boardData[i][j] == player2) {
          g.drawImage(blue_image, i * PIECESIZE, j * PIECESIZE + OFFSET_Y, PIECESIZE, PIECESIZE, null);
        }
      }
    }
  }
  //End of last method
}
