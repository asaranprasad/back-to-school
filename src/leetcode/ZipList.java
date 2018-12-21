package leetcode;


class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}


public class ZipList {
  public static void main(String args[]) {
    ListNode head = new ListNode(0);
    ListNode node = head;

    for (int i = 1; i <= 8; i++) {
      node.next = new ListNode(i);
      node = node.next;
    }

    ZipList z = new ZipList();
    z.printList(head);
    
    ListNode zipped = z.zipList(head);

    z.printList(zipped);
  }

  // 0 1 2 3 4 5 6 7 8
  private ListNode zipList(ListNode head) {
    ListNode sp = head;
    ListNode fp = head;

    // find the middle of the lsit
    while (fp.next != null && fp.next.next != null) {
      sp = sp.next;
      fp = fp.next.next;
    }

    ListNode toBeRev = sp.next;
    sp.next = null;

    // Reverse the second half of the list
    ListNode prev = null;
    while (toBeRev != null) {
      ListNode temp = toBeRev.next;
      toBeRev.next = prev;
      prev = toBeRev;
      toBeRev = temp;
    }
    
    // Begin Interleaving
    ListNode revListHead = prev;
    ListNode retList = head;
    ListNode node = retList;
    head = head.next;
    while(head != null || revListHead != null) {
      if(revListHead != null) { node.next = revListHead; revListHead = revListHead.next; node = node.next;}
      if(head != null) { node.next = head; head = head.next; node = node.next;}
    }

    return retList;
  }

  private void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }
    System.out.println("null");
  }
}
