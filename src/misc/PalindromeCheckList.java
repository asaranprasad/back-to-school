package misc;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  public ListNode next() {
    // TODO Auto-generated method stub
    return null;
  }
}


public class PalindromeCheckList {

  ListNode head;

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
    rc.head = head;
    System.out.println(rc.isPalindrome(head));
  }

  private boolean isPalindrome(ListNode left) {
    boolean retVal = true;

    if (left.next != null)
      retVal = isPalindrome(left.next);

    if (!retVal)
      return false;

    retVal = (left.val == head.val);
    head = head.next;

    return retVal;
  }


}
