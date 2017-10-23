/* https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 */

package leetcode;

public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        int[] a = new int[count];
        int m=0,n=0;
        for(int i=0;i<a.length;i++){
            if(n >= nums2.length) a[i]=nums1[m++];
            
            else if(m >= nums1.length) a[i]=nums2[n++];
            
            else if(nums1[m]<nums2[n]) a[i]=nums1[m++];
            
            else a[i]=nums2[n++];
        }
        if(count%2 ==0) return ((double)(a[count/2] + a[(count/2)-1])/(double)(2));
        else return a[count/2];
    }

}
