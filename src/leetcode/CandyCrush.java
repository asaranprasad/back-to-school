package leetcode;

public class CandyCrush {

  public static void main(String[] args) {
    // int[][] b = { { 110, 5, 112, 113, 114 }, { 210, 211, 5, 213, 214 }, { 310,
    // 311, 3, 313, 314 },
    // { 410, 411, 412, 5, 414 }, { 5, 1, 512, 3, 3 }, { 610, 4, 1, 613, 614 }, {
    // 710, 1, 2, 713, 714 },
    // { 810, 1, 2, 1, 1 }, { 1, 1, 2, 2, 2 }, { 4, 1, 4, 4, 1014 } };

    int[][] b =
        {{110, 5, 112, 113, 114}, {210, 211, 5, 213, 214}, {310, 311, 3, 313, 314},
            {410, 411, 412, 5, 414}, {5, 1, 512, 3, 3}, {610, 4, 1, 613, 614},
            {710, 1, 2, 713, 714},
            {810, 1, 2, 1, 1}, {1, 1, 2, 2, 2}, {4, 1, 4, 4, 1014}};

    // int[][] b = { { 0, 1, 1 }, { 1, 1, 0 }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, 1, 0 }
    // };
    CandyCrush ap = new CandyCrush();
    printBoard(b);
    b = ap.candyCrush(b);
    printBoard(b);

    expected();
  }

  private static void expected() {
    System.out.println("Expected:");
    int[][] b = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {110, 0, 0, 0, 114},
        {210, 0, 0, 0, 214}, {310, 0, 0, 113, 314}, {410, 0, 0, 213, 414},
        {610, 211, 112, 313, 614},
        {710, 311, 412, 613, 714}, {810, 411, 512, 713, 1014}};
    printBoard(b);
  }

  private static void printBoard(int[][] b) {
    int rows = b.length;
    int cols = b[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(b[i][j] + "\t");
      }
      System.out.print("\n");
    }
    System.out.println("\n");
  }

  public int[][] candyCrush(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;

    boolean atLeastOneCrush = true;

    while (atLeastOneCrush) {
      atLeastOneCrush = false;
      invokeGravity(board);
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (board[i][j] <= 0)
            continue;
          if (checkDFS(board, board[i][j], i, j, 1) >= 3) {
            crushCandies(board);
            atLeastOneCrush = true;
          } else {
            resetFootPrint(board);
          }
        }
      }
    }
    return board;
  }

  private void crushCandies(int[][] b) {
    int rows = b.length;
    int cols = b[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (b[i][j] < 0)
          b[i][j] = 0;
      }
    }

  }

  private void invokeGravity(int[][] b) {
    printBoard(b);
    int rows = b.length;
    int cols = b[0].length;

    for (int j = 0; j < cols; j++) {
      int p = rows - 1;
      while (p >= 0) {
        if (b[p][j] == 0)
          break;
        p--;
      }
      int q = p - 1;
      while (q >= 0) {
        if (b[q][j] != 0) {
          b[p][j] = b[q][j];
          p--;
          b[q][j] = 0;
        }
        q--;
      }
    }
    printBoard(b);
  }

  private void resetFootPrint(int[][] b) {
    int rows = b.length;
    int cols = b[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (b[i][j] < 0)
          b[i][j] *= -1;
      }
    }
  }

  private int checkDFS(int[][] b, int num, int i, int j, int count) {

    /* Using Negation as a strategy to mark visited nodes */
    b[i][j] *= -1;

    if (isWithinBounds(b, i, j + 1) && b[i][j + 1] == num) {
      count++;
      count = checkDFS(b, num, i, j + 1, count);
    }

    if (isWithinBounds(b, i, j - 1) && b[i][j - 1] == num) {
      count++;
      count = checkDFS(b, num, i, j - 1, count);
    }

    if (isWithinBounds(b, i + 1, j) && b[i + 1][j] == num) {
      count++;
      count = checkDFS(b, num, i + 1, j, count);
    }

    if (isWithinBounds(b, i - 1, j) && b[i - 1][j] == num) {
      count++;
      count = checkDFS(b, num, i - 1, j, count);
    }

    return count;
  }

  private boolean isWithinBounds(int[][] b, int i, int j) {
    int rows = b.length;
    int cols = b[0].length;

    return i < rows && j < cols && i >= 0 && j >= 0;
  }
}
