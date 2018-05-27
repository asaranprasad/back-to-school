//https://leetcode.com/problems/burst-balloons/description/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloons {


  public int maxCoins(int[] ns) {
    int n = ns.length;
    int[] nums = new int[n + 2];

    nums[0] = 1;
    nums[n + 1] = 1;
    for (int i = 1; i < n + 1; i++)
      nums[i] = ns[i - 1];

    int[][] C = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        C[i][j] = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
          int thisVal = C[i][k - 1] + nums[k - 1] * nums[k] * nums[k + 1];
          if (k + 1 <= j)
            thisVal += C[k + 1][j];
          C[i][j] = Math.max(C[i][j], thisVal);
        }
      }
    }

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        System.out.print(C[i][j] + "\t");
      }
      System.out.println();
    }

    return C[1][n];
  }

  // Test
  public static void main(String[] args) {
    BurstBalloons bb = new BurstBalloons();
    System.out.println(
        bb.maxCoins(new int[] {1, 4, 6, 7, 3, 1, 5, 8}) == 976 ? "pass" : "fail");
    System.out.println(bb.maxCoins(new int[] {3, 1, 5, 8}) == 167 ? "pass" : "fail");
  }
}
