// https://leetcode.com/problems/permutations-ii/submissions/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsDistinct {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> out = new LinkedList<>();
        Arrays.sort(nums);
        permuteUtil(nums, 0, out);
        return out;
    }
    
    private void permuteUtil(int[] nums, int start, List<List<Integer>> out){
        if(start == nums.length){ 
            List<Integer> entry = new LinkedList<>();
            for(int n: nums) entry.add(n);
            out.add(entry);
            return;
        }
                
        for(int i = start; i < nums.length; i++){
            /* Make sure that we have not swapped the same duplicate number before */
            boolean flag = true;
            for(int j = start; j < i; j++)
                if(nums[i] == nums[j]){
                    flag = false;
                    break;
                }
            if(!flag) continue;
            
            swap(nums, i, start);
            permuteUtil(nums, start + 1, out);
            swap(nums, i, start);
        }
    }
    
    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
