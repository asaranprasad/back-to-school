package misc;

import java.util.ArrayList;
import java.util.List;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class PalindromeCheckList {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(3);
    ListNode n3 = new ListNode(4);
    ListNode n4 = new ListNode(1);
    ListNode n5 = new ListNode(4);
    ListNode n6 = new ListNode(3);
    ListNode n7 = new ListNode(2);
    ListNode n8 = new ListNode(1);

    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;

    PalindromeCheckList rc = new PalindromeCheckList();
    System.out.println(rc.isPalindrome(head));
  }

  // linked lists
  public boolean isPalindrome(ListNode head) {
    return (head == null) ? true : isPalindrome(head, head) != null;
  }

  // linked lists palindrome helper
  private ListNode isPalindrome(ListNode left, ListNode head) {
    if (left.next != null)
      head = isPalindrome(left.next, head);

    return (head == null) ? null
        : (left.val == head.val) ? (head.next == null) ? head : head.next : null;
  }

  // Is the integer palindrome.
  // Solution via not converting into String
  public boolean isPalindrome(int x) {
    if (x < 0)
      return false;
    List<Integer> num = new ArrayList<Integer>();

    while (x > 0) {
      num.add(x % 10);
      x = x / 10;
    }

    for (int i = 0, j = num.size() - 1; i < j; i++, j--)
      if (num.get(i) != num.get(j))
        return false;

    return true;
  }


}
