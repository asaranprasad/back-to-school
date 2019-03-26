/* 
  https://leetcode.com/problems/alien-dictionary/submissions/

1. Compare consecutive words and generate graph
2.  The idea is skip equal chars and break soon after finding unequal chars and adding it to the graph.
3. This ideally is our single unit of comparison. i.e. the only way to find out which char comes first in this Alien language's alphabetical order.
4. Perform TopoSort and output the sort result as the final answer.
5. It is best to apply Kahn's TopoSort algorithm which is way easier than DFS.
6. Its best to use char manipulation and maintain the graph and indgree structures as arrays rather than HashMaps.

Kahn's TopoSort:
1. Track the indegrees of all nodes.
2. Add to queue those indegrees which are equal to zero.
3. In the queue loop (just like bfs), decrement neighbors' indegrees and add them to queue if they become zero.
4. Output of the topo sort is the queue order.

*/

package leetcode;


public class AlienDictionary {
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
