//https://leetcode.com/problems/next-permutation/description/

package leetcode;

public class NextPermutation {
  public void nextPermutation(int[] nums) {
    int i = nums.length - 1;

    while ((i > 0) && (nums[i] <= nums[i - 1]))
      i--;

    if (i > 0) {
      int immediateGreaterIndex = i - 1;
      int immediateGreater = Integer.MAX_VALUE;
      for (int j = i; j < nums.length; j++) {
        if ((nums[j] > nums[i - 1]) && nums[j] <= immediateGreater) {
          immediateGreater = nums[j];
          immediateGreaterIndex = j;
        }
      }
      //swap
      int t = nums[immediateGreaterIndex];
      nums[immediateGreaterIndex] = nums[i - 1];
      nums[i - 1] = t;
    }


    int start = i;
    int end = nums.length - 1;
    while (start < end) {
      int t = nums[end];
      nums[end] = nums[start];
      nums[start] = t;
      start++;
      end--;
    }

  }

  public static void main(String[] args) {}

}
