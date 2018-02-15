// https://leetcode.com/problems/two-sum/description/

// Time Complexity : O(n)

package leetcode;

import java.util.HashMap;

public class TwoSum {

  /* O(n) RunTime
   * O(n) Extra Space
   */

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int rem = target - nums[i];
      if (map.containsKey(rem)) {
        return (new int[] {map.get(rem), i});
      }
      map.put(nums[i], i);
    }
    return null;
  }


  /* O(nlogn) RunTime
   * Constant Extra Space
   * Modifies the original array.
   * Returns: the actual values
   * O(n) extra space required if needed to remember the original index
   */
  //  public int[] twoSum(int[] nums, int target) {
  //    Arrays.sort(nums);
  //    int i = 0;
  //    int j = nums.length - 1;
  //    while (i < j) {
  //      int sum = nums[i] + nums[j];
  //      if (sum == target)
  //        return new int[] {nums[i], nums[j]};
  //      if (sum > target)
  //        j--;
  //      else
  //        i++;
  //    }
  //    return null;
  //  }
}

