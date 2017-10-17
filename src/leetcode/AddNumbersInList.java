/* 
 * https://leetcode.com/problems/add-two-numbers/description/
 */

package leetcode;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


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
    int carry = 0;
    ListNode l3 = new ListNode(0);
    ListNode output = l3;

    while (l1 != null || l2 != null) {
      l3.val = l1.val + l2.val + carry;

      if (l3.val >= 10) {
        l3.val %= 10;
        carry = 1;
      } else
        carry = 0;

      if (l1.next == null && l2.next == null && carry == 1)
        l3.next = new ListNode(carry);
      else if (l1.next != null || l2.next != null) {
        l3.next = new ListNode(0);

        if (l1.next == null)
          l1.next = new ListNode(0);
        if (l2.next == null)
          l2.next = new ListNode(0);
      }

      l1 = l1.next;
      l2 = l2.next;
      l3 = l3.next;
    }

    return output;
  }
}
