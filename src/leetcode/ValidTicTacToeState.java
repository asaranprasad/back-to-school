/*
 * https://leetcode.com/problems/valid-tic-tac-toe-state/description/
 */

package leetcode;

public class ValidTicTacToeState {
  public boolean validTicTacToe(String[] board) {
    // if board length is not == 3
    if (board.length != 3)
      return false;

    int cX = 0;
    int cO = 0;

    // if each line length is not == 3
    for (String line : board) {
      if (line.length() != 3)
        return false;
      cX += countMatches(line, "X");
      cO += countMatches(line, "O");
    }

    // !(#X == #O (or) #X - #O == 1) => false
    if (!(cX == cO || cX - cO == 1))
      return false;

    // (won(X) == true (and) won(O) == true) => false
    if (won(board, 'X') == true && won(board, 'O') == true)
      return false;

    // if X has won and then O has played another turn
    if (won(board, 'X') && (cX == cO))
      return false;

    // if O has won and then X has played another turn
    if (won(board, 'O') && (cX - cO == 1))
      return false;

    // no exceptions
    return true;
  }

  public int countMatches(String line, String c) {
    return line.length() - line.replace(c, "").length();
  }

  public boolean won(String[] board, char s) {
    boolean hasWon = true;

    // row-wise
    for (int i = 0; i < board.length; i++) {
      hasWon = true;
      for (int j = 0; j < board[i].length(); j++) {
        if (board[i].charAt(j) != s) {
          hasWon = false;
          break;
        }
      }
      if (hasWon == true)
        return true;
    }

    // column-wise
    for (int i = 0; i < board.length; i++) {
      hasWon = true;
      for (int j = 0; j < board[i].length(); j++) {
        if (board[j].charAt(i) != s) {
          hasWon = false;
          break;
        }
      }
      if (hasWon == true)
        return true;
    }

    // diagonal \
    hasWon = true;
    for (int i = 0; i < board.length; i++) {
      if (board[i].charAt(i) != s) {
        hasWon = false;
        break;
      }
    }
    if (hasWon == true)
      return true;

    // diagonal /
    hasWon = true;
    for (int i = 0; i < board.length; i++) {
      if (board[i].charAt((board.length - 1) - i) != s) {
        hasWon = false;
        break;
      }
    }
    if (hasWon == true)
      return true;

    return false;
  }
}
