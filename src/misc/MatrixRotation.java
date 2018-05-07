package misc;

public class MatrixRotation {

  public static void main(String[] args) {
    int[][] mat = {{8, 9, 0, 1}, {1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 0}};
    printMatrix(mat);
    rotateMatrix90Degrees(mat);
    printMatrix(mat);
  }

  private static void printMatrix(int[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++)
        System.out.print(mat[i][j] + " ");
      System.out.println();
    }
    System.out.println();
  }

  // In-place matrix rotation
  private static void rotateMatrix90Degrees(int[][] mat) {
    int n = mat.length;
    for (int start = 0; start < mat.length / 2; start++) {
      int end = n - 1 - start;
      for (int i = start; i < end; i++) {
        int offset = i - start;
        int top = mat[start][i]; // top to temp
        mat[start][i] = mat[end - offset][start]; // left to top
        mat[end - offset][start] = mat[end][end - offset]; // bottom to left
        mat[end][end - offset] = mat[i][end]; // right to bottom
        mat[i][end] = top; // top to right
      }
    }
  }
}
