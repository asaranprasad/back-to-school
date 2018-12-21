/* 
 * https://leetcode.com/problems/add-two-numbers/description/
 */

package leetcode;

//class ListNode {

//  int val;
//  ListNode next;
//
//  ListNode(int x) {
//    val = x;
//  }
//}


public class AddNumbersInList {
  public static void main(String[] args) {
    AddNumbersInList obj = new AddNumbersInList();

    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    obj.addTwoNumbers(l1, l2);

  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null)
      return null;

    ListNode l3 = new ListNode(0);
    ListNode output = l3;

    while (l1 != null || l2 != null) {
      int l1v = (l1 != null) ? l1.val : 0;
      int l2v = (l2 != null) ? l2.val : 0;

      l3.val = l3.val + l1v + l2v;
      l3.next = new ListNode(l3.val / 10);
      l3.val %= 10;

      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;

      if (l1 == null && l2 == null) {
        if (l3.next.val == 0)
          l3.next = null;
      } else
        l3 = l3.next;
    }

    return output;
  }
}
