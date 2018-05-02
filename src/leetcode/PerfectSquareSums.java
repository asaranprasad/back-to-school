//https://leetcode.com/problems/perfect-squares/description/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquareSums {

  //Generalized solution inspired by Coin Change
  public int numSquares(int n) {
    List<Integer> sq = populateSquaresTill(n);
    int[] C = new int[n + 1];
    C[0] = 0;
    for (int i = 1; i <= n; i++) {
      C[i] = Integer.MAX_VALUE;
      for (int k = 1; k < sq.size(); k++) {
        if (i - sq.get(k) >= 0)
          if (C[i] > C[i - sq.get(k)] + 1)
            C[i] = C[i - sq.get(k)] + 1;
      }
    }
    return C[n];
  }

  private List<Integer> populateSquaresTill(int n) {
    List<Integer> ret = new ArrayList<Integer>();
    for (int i = 0; i * i <= n; i++)
      ret.add(i * i);
    return ret;
  }

  // Test
  public static void main(String[] args) {
    PerfectSquareSums pss = new PerfectSquareSums();
    System.out.println(pss.numSquares(12) == 3 ? "pass" : "fail");
    System.out.println(pss.numSquares(13) == 2 ? "pass" : "fail");
    System.out.println(pss.numSquares(4) == 1 ? "pass" : "fail");
    System.out.println(pss.numSquares(0) == 0 ? "pass" : "fail");
  }
}
