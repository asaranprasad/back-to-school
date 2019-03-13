/* https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 */

package leetcode;

public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = a.length;
        int n2 = b.length;
        if(n1 < n2) return findMedianSortedArrays(b, a);
        
        int lo = 0, hi = n2 * 2;
        while(lo <= hi){
            int cut2 = (lo + hi) / 2;
            int cut1 = n1 + n2 - cut2;
            
            int l1 = (cut1 <= 0) ? Integer.MIN_VALUE : a[(cut1 - 1) / 2];
            int l2 = (cut2 <= 0) ? Integer.MIN_VALUE : b[(cut2 - 1) / 2];
            int r1 = (cut1 >= n1 * 2) ? Integer.MAX_VALUE : a[cut1 / 2];
            int r2 = (cut2 >= n2 * 2) ? Integer.MAX_VALUE : b[cut2 / 2];
            
            if(l1 > r2) lo = cut2 + 1;
            else if(l2 > r1) hi = cut2 - 1;
            else return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / (double) 2;
        }
        return -1;
    }

}


// Consider L/R to be the two elements lying on either side of the center-cut of the array. The average of L and R is obviously the median. (For even length array, we can make sure that L and R are pointing to the same element, in which case the answer is still correct)

// N        Index of L / R
// 1               0 / 0
// 2               0 / 1
// 3               1 / 1  
// 4               1 / 2      
// 5               2 / 2
// 6               2 / 3
// 7               3 / 3
// 8               3 / 4

// Thus, Median of a single sorted array (irrespective of length being even or odd):
// Median = (L + R) / 2 = (A[(N - 1)/2] + A[N / 2]) / 2
// ---------------------------------------------------------
// Now, for two sorted arrays, we would get our median answer by creating the **perfect inter-array partition** between the two arrays, where 
// 1. No. of elements on either side of this inter-array partition are **exactly equal**, and
// 2. L1 <= R2 && L2 <= R1. 
// These above two conditions make sure that we find our median - because, once these 2 conditions are true, our median is a simple formula:
// **combined_median = (max(L1, L2) + min(R1, R2)) / 2**
// Thus, we just need to do binary search hereafter to determine the exact partition satisfying both conditions 1 and 2.

// What do we mean by **exactly equal** in our previous condition 1? Won't this be false if we have odd number of elements?
// Since our main  idea is to give a generic (simple) solution for both even and odd cases, we shall introduce imaginary partition points in between every element of the arrays. This would give us **exactly equal** number of elements on either side of the inter-array partition. For example, 
// A1: [# 1 # 2 # 3 # 4 # 5 #]    (N1 = 5, N1_positions = 11)
// A2: [# 1 # 1 # 1 # 1 #]     (N2 = 4, N2_positions = 9)
// The **exactly equal** number of elements will now **always** be = **(N1 + N2)**
// (since, the total no. of elements now is 2(N1 + N2) + 2, where the constant +2 are those elements over which the inter-array partition runs)

// Note: Even with these imaginary partition positions in place, we can see that the formula for finding actual L1, L2, R1 and R2 still remain the same (just having to be done using the measured cuts - cut1 and cut2 instead of length of the arrays).

// Note: The corner cases where L1, L2, R1 and R2 can fall beyond array-limit can be handled by introducing dummy-values int_max and int_min

// Now take a look at the submitted answer for a better understanding.


// detailed explanation: https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation