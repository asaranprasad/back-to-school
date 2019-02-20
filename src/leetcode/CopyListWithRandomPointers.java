/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        
        // Copy Individual nodes as linked chains
        RandomListNode node = head;
        while(node != null){
            RandomListNode nodeb = new RandomListNode(node.label);
            nodeb.next = node.next;
            node.next = nodeb;
            node = nodeb.next;
        }
        
        // Copy Random Pointers for new node set
        node = head;
        while(node != null){
            if(node.random != null) node.next.random = node.random.next;
            node = node.next.next;
        }        
        
        // Restore next pointers
        RandomListNode newHead = head.next;
        node = head;
        while(node != null){
            RandomListNode nodeNext = node.next.next;
            if(nodeNext != null) node.next.next = nodeNext.next;
            node.next = nodeNext;
            node = node.next;
        }         
        
        return newHead;
    }
}