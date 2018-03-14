package hash;


// Node to hold keys
class KeyNode {
  public String key;
  public int count;
  public PositionNode pn;
  //  public KeyNode next;

  public KeyNode(String key) {
    this.key = key;
    count = 0;
    pn = null;
    //    next = null;
  }

  public void incrementCount() {
    count++;
  }
}


// Node to hold position
class PositionNode {
  public int position;
  //  public PositionNode next;

  public PositionNode(int position) {
    this.position = position;
    //    next = null;
  }
}


// Node to hold linked list of generic type
class LinkedList<T> {
  T node;
  LinkedList<T> next;

  public LinkedList(T node) {
    this.node = node;
    next = null;
  }


  public void push(int data) {
    if (head == null) {
      head = new SLLnode(data);
      return;
    }
    SLLnode node = new SLLnode(data);
    SLLnode curr = head;
    while (curr.next != null)
      curr = curr.next;
    curr.next = node;
  }

  private void delete(SLLnode prev, SLLnode node) {
    prev.next = node.next;
  }

  public int findIndexOf(int data) {
    SLLnode curr = head;
    int index = -1;
    int iter = -1;
    while (curr != null) {
      iter++;
      if (curr.data == data) {
        index = iter;
        break;
      }
      curr = curr.next;

    }
    return index;
  }
}


// Singly Linked List API
//class SLLapi<T> {
//  private SLLnode head;
//
//  public void push(int data) {
//    if (head == null) {
//      head = new SLLnode(data);
//      return;
//    }
//    SLLnode node = new SLLnode(data);
//    SLLnode curr = head;
//    while (curr.next != null)
//      curr = curr.next;
//    curr.next = node;
//  }
//
//  private void delete(SLLnode prev, SLLnode node) {
//    prev.next = node.next;
//  }
//
//  public void print() {
//    SLLnode curr = head;
//    while (curr != null) {
//      System.out.print(curr.data + " ");
//      curr = curr.next;
//    }
//  }
//
//  public void deleteFirstOccuranceOfData(int data) {
//    SLLnode curr = head;
//    SLLnode prev = curr;
//    while (curr.next != null) {
//      if (curr.data == data)
//        break;
//      prev = curr;
//      curr = curr.next;
//    }
//    delete(prev, curr);
//  }
//
//  public int findIndexOf(int data) {
//    SLLnode curr = head;
//    int index = -1;
//    int iter = -1;
//    while (curr != null) {
//      iter++;
//      if (curr.data == data) {
//        index = iter;
//        break;
//      }
//      curr = curr.next;
//
//    }
//    return index;
//  }
//
//}


public class HashForText {

  // size of the hash table - a prime
  private static int M = 769;

  private int hash(String s) {
    char ch[];
    ch = s.toCharArray();

    int i, sum;
    for (sum = 0, i = 0; i < s.length(); i++)
      sum += ch[i];
    return sum % M;
  }

  public static void main(String[] args) {
    LinkedList<KeyNode> ll = new LinkedList<KeyNode>(new KeyNode("pavi"));

  }

}
