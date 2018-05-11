package misc;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

  public static void main(String[] args) {
    String str = "abc";
    char[] s = str.toCharArray();
    //    System.out.println(s);
    permute(s, 0, s.length - 1);

  }

  // Return all possible permutations
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    permuteUtil(nums, 0, nums.length - 1, result);
    return result;
  }

  public void permuteUtil(int[] nums, int start, int end, List<List<Integer>> result) {
    if (start > end) {
      List<Integer> r = new ArrayList<Integer>();
      for (int i : nums)
        r.add(i);
      result.add(r);
    }
    for (int i = start; i <= end; i++) {
      swap(nums, start, i);
      permuteUtil(nums, start + 1, end, result);
      swap(nums, start, i);
    }
  }


  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  // Print all possible permutations
  private static void permute(char[] s, int start, int end) {
    if (start >= end)
      System.out.println(s);

    else
      for (int i = start; i <= end; i++) {
        swap(s, start, i);
        permute(s, start + 1, end);
        swap(s, start, i);
      }
  }

  private static void swap(char[] s, int index1, int index2) {
    char temp = s[index1];
    s[index1] = s[index2];
    s[index2] = temp;
  }
}
