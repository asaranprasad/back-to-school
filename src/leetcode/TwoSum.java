// https://leetcode.com/problems/two-sum/description/

// Time Complexity : O(n)

package leetcode;

import java.util.HashMap;

public class TwoSum {
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
}

