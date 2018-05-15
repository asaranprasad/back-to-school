//https://leetcode.com/problems/3sum/description/
// Incomplete: Doesn't return unique set of strings yet 

package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    for (int i = 0; i < nums.length; i++)
      twoSum(nums, i, result);
    return result;
  }

  private void twoSum(int[] nums, int not, List<List<Integer>> result) {
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (i == not)
        continue;
      if (hash.get(nums[i]) != null) {
        int sup = hash.get(nums[i]);
        List<Integer> res = new LinkedList<Integer>();
        res.add(nums[not]);
        res.add(nums[sup]);
        res.add(nums[i]);
        result.add(res);
      } else
        hash.put(0 - nums[not] - nums[i], i);
    }
  }

  public static void main(String[] args) {

  }

}
