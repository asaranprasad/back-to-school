// 1. BFS
// 2. Keep adding null to queue at current level when previous level's null is reached
// 3. Peek for null in the queue and print the current polled value

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> out = new LinkedList<>();
        
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n == null) continue;
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
            if(q.peek() == null){ 
                out.add(n.val);
                q.add(null);                
            }                                        
        }
        return out;
    }
}