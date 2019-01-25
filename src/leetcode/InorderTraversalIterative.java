// 1. Keep pushing root and its left children to the stack.
// 2. Keep making root = root.left during this process.
// 3. If no more left child, add root to output and make new root = root.right
// 4. Break the loop if root is null and if there are no more elements in the stack.

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
       
        while(root != null || !stack.empty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            } 
            else{
                TreeNode n = stack.pop();
                out.add(n.val);
                root = n.right;
            }
        }        
        return out;
    }    
}