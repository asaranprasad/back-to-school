// https://leetcode.com/problems/product-of-array-except-self/submissions/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        
        Arrays.fill(out, 1);
        
        /* Make sure every index holds prod of all numbers */
        /* before that index */
        int prod = 1;
        for(int i = 1; i < n; i++){
            prod *= nums[i - 1];
            out[i] = prod;
        }
        
        /* Same in reverse direction - Make sure every index holds */
        /* prod of all numbers coming after that index */
        /* Avoiding another iteration by combining with prev iteration result */
        prod = 1;
        for(int i = n - 2; i >= 0; i--){
            prod *= nums[i + 1];
            out[i] *= prod;
        }
        
        return out;
    }
}
