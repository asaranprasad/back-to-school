package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Definition for singly-linked list. */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}


public class Pb2 {
  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for (int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static ListNode stringToListNode(String input) {
    // Generate array from the input
    int[] nodeValues = stringToIntegerArray(input);

    // Now convert that list into linked list
    ListNode dummyRoot = new ListNode(0);
    ListNode ptr = dummyRoot;
    for (int item : nodeValues) {
      ptr.next = new ListNode(item);
      ptr = ptr.next;
    }
    return dummyRoot.next;
  }

  public static String listNodeToString(ListNode node) {
    if (node == null) {
      return "[]";
    }

    String result = "";
    while (node != null) {
      result += Integer.toString(node.val) + ", ";
      node = node.next;
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      ListNode head = stringToListNode(line);

      ListNode ret = new Pb2().detectCycle(head);

      String out = listNodeToString(ret);

      System.out.print(out);
    }
  }

  public ListNode detectCycle(ListNode head) {
    /* Confirm is there is a cycle and */
    /* find any node within the cycle */
    ListNode lNode = getLoopNode(head);
    if (lNode == null)
      return null;

    /* Cut the loop at that point. */
    /* Just make sure that is not the intersectionPoint */
    /* which we are actually looking for */
    ListNode nh = lNode.next;
    lNode.next = null;

    /* Get intersection of two linked list */
    ListNode inter = getIntersection(head, nh);

    /* If inter == null even after we confirmed in step 1 */
    /* that there is a cycle => we 'Null'ed exactly the */
    /* inter node during our cut step in step 2 */
    if (inter == null)
      return nh;
    else
      return inter;
  }

  private ListNode getLoopNode(ListNode head) {
    if (head == null || head.next == null || head.next.next == null)
      return null;
    ListNode sp = head.next;
    ListNode dp = head.next.next;

    while (sp != null) {
      if (sp == dp)
        return sp;
      sp = sp.next;
      if (dp == null || dp.next == null)
        return null;
      dp = dp.next.next;
    }

    return null;
  }

  /* INVARIENT: The two lists terminate. */
  /* i.e. node.next==null at some point */
  private ListNode getIntersection(ListNode h1, ListNode h2) {
    int l1 = length(h1);
    int l2 = length(h2);

    ListNode longer = (l1 <= l2) ? h2 : h1;
    ListNode shorter = (l1 <= l2) ? h1 : h2;
    int skip = Math.abs(l2 - l1);

    while (skip > 0) {
      longer = longer.next;
      skip--;
    }

    while (shorter != null) {
      if (shorter == longer)
        return shorter;
      shorter = shorter.next;
      longer = longer.next;
    }

    return null;
  }

  private int length(ListNode h) {
    int length = 0;
    while (h != null) {
      length++;
      h = h.next;
    }
    return length;
  }
}
