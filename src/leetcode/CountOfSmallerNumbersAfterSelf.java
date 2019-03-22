// https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/

package leetcode;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
	class Node{
        int val;
        int count = 1;
        Node(int val){
            this.val = val;
        }
        Node left;
        Node right;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums == null || nums.length == 0) return res;
        Node root = new Node(nums[nums.length - 1]);
        res.add(0);
        
        for(int i = nums.length - 2; i >= 0; i--){
            res.add(insertAndFindSmallerCount(root, nums[i]));
        }
        
        Collections.reverse(res);
        return res;
    }
    
    private int insertAndFindSmallerCount(Node root, int n){
        int smallerCount = 0;
        while(true){
            if(root.val < n){
                smallerCount += root.count;
                if(root.right == null){ 
                    root.right = new Node(n);
                    break;
                }
                else root = root.right;
            }
            else{
                root.count++;
                if(root.left == null){
                    root.left = new Node(n);
                    break;
                }
                else root = root.left;
            }
        }
        return smallerCount;
    }
}