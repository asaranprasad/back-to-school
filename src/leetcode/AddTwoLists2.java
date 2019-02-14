// 1. Find diff of the list
// 2. Swap for the biggest list for ease of programming
// 3. Skip the larger list for the diff of lengths and then try adding the lists recursively
// 4. Manage carry at the end of each recursion

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

package leetcode;

import java.util.*;

public class AddTwoLists2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        /* Find diff of the lists */
        ListNode a = l1;
        ListNode b = l2;
        
        int alen = 0; int blen = 0;
        while(a != null) { a = a.next; alen++; }
        
        while(b != null) { b = b.next; blen++; }
        
        int diff = alen - blen;
        
        /* Swap the larger list to l1 for ease of programming */
        if(alen < blen){
            ListNode t = l1;
            l1 = l2;
            l2 = t;
            diff = blen - alen;
        }
                
        /* If the last node is a carry, handle with a dummy node */
        int carry = addByRecursion(l1, l2, diff);
        
        if(carry > 0){
            ListNode dummy = new ListNode(carry);
            dummy.next = l1;
            return dummy;
        }
        
        return l1;
    }
    
    private int addByRecursion(ListNode l1, ListNode l2, int diff){        
        int sum = 0;
        
        /* skip the bigger list digits till diff */
        if(diff > 0){
            int carry = addByRecursion(l1.next, l2, diff - 1); 
            sum = carry + l1.val;
        } else{
            if(l1 == null) return 0; /* Base condition check */
            int carry = addByRecursion(l1.next, l2.next, diff);             
            sum = carry + l1.val + l2.val;
        }
        
        l1.val = sum % 10;
        return sum / 10; // carry
    }

}
