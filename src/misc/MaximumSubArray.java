/* Find the maximum SubArray in a  given number collection - Kadane's  Algorithm
 * Handles full negative numbers too */

package misc;

import java.util.Arrays;

public class MaximumSubArray {

  public static void main(String[] args) {

    int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    int[] op = (new MaximumSubArray()).findMaxContinuousSum(a);
    for (int i = op[0]; i <= op[1]; i++)
      System.out.print(a[i] + " ");
    System.out.println("maxSum: " + op[2]);

  }

  // returns [start, end] and maxSum value - inclusive closed intervals
  private int[] findMaxContinuousSum(int[] a) {
    int start = -1;
    int end = -1;
    int maxSum = a[0];
    int maxSoFar = a[0];
    int inStart = -1;

    for (int i = 1; i < a.length; i++) {
      //      maxSoFar = Math.max(a[i] + maxSoFar, a[i]);
      //      maxSum = Math.max(maxSum, maxSoFar);
      if (a[i] + maxSoFar < a[i]) {
        maxSoFar = a[i];
        inStart = i;
      } else
        maxSoFar = a[i] + maxSoFar;

      if (maxSum < maxSoFar) {
        start = inStart;
        end = i;
        maxSum = maxSoFar;
      }
    }
    return new int[] {start, end, maxSum};
  }
}
