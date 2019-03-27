// https://leetcode.com/problems/next-closest-time/

package leetcode;

public class NextClosestTime {

    public String nextClosestTime(String time) {
        char[] nums = time.toCharArray();
        char[] sorted = {time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        Arrays.sort(sorted);
        
        char n = nums[4];
        nums[4] = findNext(sorted, nums[4], '9');
        if(n < nums[4]) return String.valueOf(nums);
        
        n = nums[3];
        nums[3] = findNext(sorted, nums[3], '5');
        if(n < nums[3]) return String.valueOf(nums);
        
        n = nums[1];
        nums[1] = nums[0] == '2' ? findNext(sorted, nums[1], '3') : findNext(sorted, nums[1], '9');
        if(n < nums[1]) return String.valueOf(nums);
        
        n = nums[0];
        nums[0] = findNext(sorted, nums[0], '2');
        return String.valueOf(nums);               
    }
    
    private char findNext(char[] sorted, char n, char limit){
        int i = Arrays.binarySearch(sorted, n);  
        
        /* skipping equal characters - corner case if duplicates present
           - otherwise this would be a simple if-else statement */
        while(i + 1 < sorted.length && sorted[i + 1] <= limit) {
            if(sorted[i + 1] == n) i++;
            else return sorted[i + 1];
        }
        return sorted[0];
    }

}
