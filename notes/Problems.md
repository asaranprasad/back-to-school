Permutation:

With Repetition Allowed:
```
    private void permuteUtil(int[] nums, int start, List<List<Integer>> out){
        if(start == nums.length){ 
            List<Integer> entry = new LinkedList<>();
            for(int n: nums) entry.add(n);
            out.add(entry);
            return;
        }
                
        for(int i = start; i < nums.length; i++){            
            swap(nums, i, start);
            permuteUtil(nums, start + 1, out);
            swap(nums, i, start);
        }
    }
```    
Without Repetition (Unique Entries):
Add a loop-check for every iteration making sure the current number has not been seen before in the iteration.

```
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
```    