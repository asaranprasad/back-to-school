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

  public static void main(String[] args) {

  }

}
