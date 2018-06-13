package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Easy {

  //---------------------------------------------------------------------------//

  public int lengthOfLastWord(String s) {
    int slen = s.length() - 1;
    if (slen < 0)
      return 0;

    while (slen > -1 && s.charAt(slen) == ' ')
      slen--;
    if (slen < 0)
      return 0;

    int i = slen;
    while (i > -1 && s.charAt(i) != ' ')
      i--;

    return slen - i;
  }

  //---------------------------------------------------------------------------//

  /* https://leetcode.com/problems/binary-tree-paths/description/ */
  /*   Definition for a binary tree node. */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new LinkedList<String>();
    if (root != null)
      allPaths(root, paths, String.valueOf(root.val));
    return paths;
  }

  private void allPaths(TreeNode root, List<String> paths, String soFar) {
    if (root.left == null && root.right == null)
      paths.add(soFar);
    if (root.right != null)
      allPaths(root.right, paths, soFar + "->" + String.valueOf(root.right.val));
    if (root.left != null)
      allPaths(root.left, paths, soFar + "->" + String.valueOf(root.left.val));
  }

  //---------------------------------------------------------------------------//

  /* https://leetcode.com/problems/path-sum-ii/description/ */

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> paths = new LinkedList<List<Integer>>();
    if (root != null) {
      List<Integer> initList = new LinkedList<Integer>();
      initList.add(root.val);
      allPathsWithSum(root, paths, initList, sum);
    }
    return paths;
  }

  private void allPathsWithSum(TreeNode root, List<List<Integer>> paths,
      List<Integer> soFar, int target) {
    if (root.left == null && root.right == null && sumSoFar == target)
      paths.add(soFar);
    if (root.right != null)
      allPathsWithSum(root.right, paths, soFar.add(root.right.val), target);
    if (root.left != null)
      allPathsWithSum(root.left, paths, soFar.add(root.left.val), target);
  }

  //---------------------------------------------------------------------------//
  /* https://leetcode.com/problems/plus-one/description/ */

  public int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] == 9 && carry == 1) {
        digits[i] = 0;
        carry = 1;
      } else {
        digits[i] += carry;
        carry = 0;
      }
    }

    if (carry == 1) {
      int[] newDigits = new int[digits.length + 1];
      newDigits[0] = 1;
      for (int i = 0; i < digits.length; i++) {
        newDigits[i + 1] = digits[i];
      }
      return newDigits;
    } else
      return digits;
  }

  //---------------------------------------------------------------------------//


  //---------------------------------------------------------------------------//


  //---------------------------------------------------------------------------//
  public static void main(String[] args) {

  }

}
