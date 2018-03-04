package dp;

public class CoinChange {

  public static void main(String[] args) {
    int[] denominations = {1, 5, 10, 25};
    CoinChange c = new CoinChange();
    System.out.println(c.countWays(30, denominations));
  }

  private int countWays(int n, int[] d) {
    int k = d.length;
    int[][] C = new int[n + 1][k + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k; j++) {
        if (i - d[j] > 0)
          C[i][j] = C[i - d[j]][j - 1] + C[i][j - 1] + 1;
        else
          C[i][j] = C[i][j - 1];
      }
    }

    return C[n][k];
  }
}

