package leetcode;


class ListNode{
  int val;
  ListNode next;
  ListNode(int val){ this.val = val; }
}

public class ZipList {
  public static void main(String args[]) {
    ListNode head = new ListNode(0);
    ListNode node = head;
    
    for(int i = 1; i < 7; i++) {
      node.next = new ListNode(i);
      node = node.next;
    }
    
    ZipList z = new ZipList();
    ListNode zipped = z.zipList(head);
    
    z.printList(zipped);
  }
  
  private ListNode zipList(ListNode head) {
    
  }
  
  private void printList(ListNode head) {
    while(head != null) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }
    System.out.println("null");
  }
}
