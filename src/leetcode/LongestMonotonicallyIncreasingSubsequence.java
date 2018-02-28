// Incomplete

package leetcode;

//Give an algorithm to find the longest monotonically increasing subsequence
//of a sequence of n numbers. (Hint: Observe that the last element of a
//candidate subsequence of length i is at least as large as the last element of a candidate
//subsequence of length i  1. Maintain candidate subsequences by linking
//them through the input sequence.)

public class LongestMonotonicallyIncreasingSubsequence {
  public static void main(String[] args) {
    LongestMonotonicallyIncreasingSubsequence obj =
        new LongestMonotonicallyIncreasingSubsequence();
    int[] a = {1, 3, 2, -5, 4, -6, 2, 3};

    System.out.println(obj.longestMonotonicallyIncreasingSubsequence(a));
  }


  private int longestMonotonicallyIncreasingSubsequence(int[] a) {
    int[] trace = new int[a.length + 1];
    int[] C = new int[a.length + 1];

    for (int i = 1; i <= a.length; i++) {
      C[i] = Integer.MIN_VALUE;
      for (int j = i - 1; j > 0; j--) {
        if (a[j] <= a[i])
          if (C[i] < C[i - 1] + 1) {
            C[i] = C[i - 1] + 1;
            trace[i] = j;
          }
      }
    }
    printTrace(a, trace);
    return C[a.length];
  }


  private void printTrace(int[] a, int[] trace) {
    System.out.println();
    int i = trace[trace.length - 1];
    while (i > 0) {
      System.out.print(a[i] + " ");
      i = trace[i];
    }

  }



}
