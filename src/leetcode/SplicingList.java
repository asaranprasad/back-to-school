package leetcode;


//class ListNode {
//  int val;
//  ListNode next;
//
//  ListNode(int x) {
//    val = x;
//  }
//}
public class SplicingList {
  public static void main(String[] args) {
    SplicingList sl = new SplicingList();

    ListNode l = new ListNode(1);
    ListNode l1 = l;
    l.next = new ListNode(2);
    l = l.next;
    l.next = new ListNode(4);

    l = new ListNode(1);
    ListNode l2 = l;
    l.next = new ListNode(3);
    l = l.next;
    l.next = new ListNode(4);


    ListNode n = sl.mergeTwoLists(l1, l2);
    while (n != null) {
      System.out.print(n.val + " ");
      n = n.next;
    }
  }


  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;

    ListNode n;
    if (l1.val <= l2.val) {
      n = new ListNode(l1.val);
      l1 = l1.next;
    } else {
      n = new ListNode(l2.val);
      l2 = l2.next;
    }

    ListNode l3 = n;
    ListNode node;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        node = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        node = new ListNode(l2.val);
        l2 = l2.next;
      }
      n.next = node;
      n = n.next;
    }

    if (l1 == null)
      n.next = l2;
    if (l2 == null)
      n.next = l1;

    return l3;
  }


}
