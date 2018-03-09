/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */

package leetcode;

import java.util.LinkedList;
import java.util.List;

public class BFS {
  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public List<List<Integer>> levelOrder(TreeNode root) {
    LinkedList<TreeNode> frontier = new LinkedList<TreeNode>();
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    if (root == null)
      return ret;
    frontier.add(root);
    frontier.add(null); // marking end of first level
    return bfs(frontier, ret, new LinkedList<Integer>());
  }

  public List<List<Integer>> bfs(LinkedList<TreeNode> frontier, List<List<Integer>> ret,
      LinkedList<Integer> collectedList) {
    TreeNode node = frontier.removeFirst();

    if (node == null) { // if previous level end reached,
      ret.add(collectedList); // list of elements collected so far in current level
      collectedList = new LinkedList<Integer>();
      frontier.add(null); // marking end for current level in the frontier
      node = frontier.removeFirst();
      if (node == null) // if the subsequent node is also null,
        return ret; // end of tree traversal
    }

    if (node.left != null)
      frontier.add(node.left);
    if (node.right != null)
      frontier.add(node.right);

    collectedList.add(node.val);

    return bfs(frontier, ret, collectedList);
  }
}
