/* 
 https://leetcode.com/problems/add-two-numbers/submissions/
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


public class AddNumbersInListMostSigFirst_Easy {
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
        ListNode out = new ListNode(-1);
        ListNode n = out;
        int carry = 0;
        while(l1 != null || l2 != null){
            int s = carry;
            if(l1 != null){ s += l1.val; l1 = l1.next; }
            if(l2 != null){ s += l2.val; l2 = l2.next; }
            carry = s / 10;
            s %= 10;
            n.next = new ListNode(s);
            n = n.next;
        }
        if(carry != 0) n.next = new ListNode(carry);
        
        return out.next;
    }
}
