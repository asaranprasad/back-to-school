/* https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 */

package leetcode;

public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int INT_MIN = Integer.MIN_VALUE;
        int INT_MAX = Integer.MAX_VALUE;
        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 < N2) return findMedianSortedArrays(nums2, nums1);   // Make sure N2 is the shorter one.

        int lo = 0, hi = N2 * 2; // N2*2 cauz we are including the potential cut points in our both our arrays.
        while (lo <= hi) {
            int cut2 = (lo + hi) / 2;   // Assume cut2 using usual binary search technique
            int cut1 = N1 + N2 - cut2;  // Calculate cut1 accordingly

            // Calculate L1, R1, L2, R2 respectively
            int L1 = (cut1 == 0) ? INT_MIN : nums1[(cut1-1)/2]; 
            int L2 = (cut2 == 0) ? INT_MIN : nums2[(cut2-1)/2];
            int R1 = (cut1 == N1 * 2) ? INT_MAX : nums1[(cut1)/2];
            int R2 = (cut2 == N2 * 2) ? INT_MAX : nums2[(cut2)/2];

            if (L1 > R2) lo = cut2 + 1;     // N1's lower half is too big; need to move cut1 left (cut2 right)
            else if (L2 > R1) hi = cut2 - 1;    // N2's lower half too big; need to move cut2 left.
            else return (double)(Math.max(L1,L2) + Math.min(R1, R2)) / (double)2;   // Otherwise, that's the right cut.
        }
        return -1;
    }

}


