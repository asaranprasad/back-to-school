// https://leetcode.com/problems/diameter-of-binary-tree/submissions/

package leetcode;

import java.util.*

public class DiameterOfABinaryTree {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        longestPath(root);
        return max - 1;
    }
    
    private int longestPath(TreeNode root){
        if(root == null) return 0;       
        
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        
        max = Math.max(max, left + right + 1);
        
        return Math.max(left + 1, right + 1);
    }
}
