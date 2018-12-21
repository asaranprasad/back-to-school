package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSets {

  public static void main(String[] args) {
    int[] inp = {1, 2, 3};
    List<List<Integer>> res = new SubSets().subsets(inp);
    for (List<Integer> re : res) {
      System.out.println(re.toString());
    }

  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Arrays.sort(nums);
    backtrack(res, nums, 0, new ArrayList<Integer>());
    return res;
  }

  private void backtrack(List<List<Integer>> res, int[] nums, int ind,
      ArrayList<Integer> soFar) {
    res.add(new ArrayList<Integer>(soFar));
//        for (int i = ind; i < nums.length; i++) {
//          soFar.add(nums[i]);
//          backtrack(res, nums, i + 1, soFar);
//          soFar.remove(soFar.size() - 1);
//        }

    if (ind >= nums.length)
      return;
    soFar.add(nums[ind]);
    backtrack(res, nums, ind + 1, soFar);
    soFar.remove(soFar.size() - 1);
    backtrack(res, nums, ind + 1, soFar);

  }


}
