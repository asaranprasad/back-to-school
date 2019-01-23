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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBSTUtil(TreeNode root, long min, long max){
        if(root == null) return true;
        
        if(root.val <= min || root.val >= max) return false;
                
        return isValidBSTUtil(root.left, min, root.val)
            && isValidBSTUtil(root.right, root.val, max);
    }
} 
