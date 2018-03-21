package dp;

//Incomplete
public class NumberOfWaysToGiveCoins {

  public static void main(String[] args) {
    int[] d = {1, 5, 10, 25, 50};
    int n = 100;
    NumberOfWaysToGiveCoins obj = new NumberOfWaysToGiveCoins();
    System.out.println(obj.numWaysToGiveCoins(d, n));
  }

  public int numWaysToGiveCoins(int[] d, int n) {
    int[][] C = new int[n + 1][d.length + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= d.length; j++) {
        if (i - d[j - 1] > 0)
          C[i][j] = C[i - d[j - 1]][j] + C[i][j - 1];
      }
    }

    return C[n][d.length];
  }

}
