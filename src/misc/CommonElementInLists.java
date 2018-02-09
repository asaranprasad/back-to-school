package misc;


class Node {
  public int data;
  public Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}


public class CommonElementInLists {

  public Node findCommonNode(Node headA, Node headB) {
    Node pA = headA;
    Node pB = headB;
    int lenA = 0;
    int lenB = 0;

    while (pA != null) {
      lenA++;
      pA = pA.next;
    }

    while (pB != null) {
      lenB++;
      pB = pB.next;
    }

    pA = headA;
    pB = headB;
    int skip = 0;

    if (lenA > lenB) {
      skip = lenA - lenB;
      for (int i = 0; i < skip; i++)
        pA = pA.next;
    } else {
      skip = lenB - lenA;
      for (int i = 0; i < skip; i++)
        pB = pB.next;
    }

    while ((pA != null) || (pB != null)) {
      if (pA == pB)
        return pA;
      pA = pA.next;
      pB = pB.next;
    }

    return null;
  }

  public static void main(String[] args) {
    Node headA = new Node(1);
    Node headB = new Node(11);

    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);
    Node n10 = new Node(10);
    Node n11 = new Node(11);


    // setting the intersection node as n10
    headA.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n10;
    n10.next = n11;

    headB.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    n8.next = n9;
    n9.next = n10;

    CommonElementInLists c = new CommonElementInLists();
    if (c.findCommonNode(headA, headB) == n10)
      System.out.println("Test1 : Pass - Value at Intersection Found");
    else
      System.out.println("Test1 : Fail");


    // updating the intersection node to n11
    headB.next = n11;
    if (c.findCommonNode(headA, headB) == n11)
      System.out.println("Test2 : Pass - Value at Intersection Found");
    else
      System.out.println("Test2 : Fail");

  }

}
