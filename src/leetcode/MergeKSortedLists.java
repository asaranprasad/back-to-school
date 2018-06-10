//https://leetcode.com/problems/merge-k-sorted-lists/description/
package leetcode;


class ListNodeN {
  int val;
  ListNodeN next;

  ListNodeN(int x) {
    val = x;
  }
}


public class MergeKSortedLists {
  public ListNodeN mergeKLists(ListNodeN[] lists) {
    if (lists == null || lists.length == 0)
      return null;
    ListNodeN n = lists[0];
    for (int i = 1; i < lists.length; i++) {
      ListNodeN m = lists[i];
      n = merge(n, m);
    }
    return n;
  }

  private ListNodeN merge(ListNodeN n, ListNodeN m) {
    ListNodeN a = new ListNodeN(Integer.MIN_VALUE);
    ListNodeN ret = a;
    while (n != null && m != null) {
      if (m.val > n.val) {
        a.next = n;
        n = n.next;
      } else {
        a.next = m;
        m = m.next;
      }
      a = a.next;
    }

    if (n == null)
      a.next = m;
    if (m == null)
      a.next = n;

    ret = ret.next;
    return ret;
  }

  public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
    int now = m + n - 1;
    m = m - 1;
    n = n - 1;
    while (m > -1 && n > -1) {
      if (nums1[m] > nums2[n]) {
        nums1[now] = nums1[m];
        m--;
      } else {
        nums1[now] = nums2[n];
        n--;
      }
      now--;
    }

    while (n > -1) {
      nums1[now] = nums2[n];
      n--;
      now--;
    }
  }

  public static void main(String[] args) {

  }

}
