package treesADT;

import java.util.LinkedList;
import java.util.Queue;

public class PrettyPrintBinaryTree {

  class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
      this.data = data;
      left = right = null;
    }
  }

  public void prettyPrintToConsole(Node root) {

  }

  private Node bfsFillChar256() {
    Node root = new Node((char) 0);
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    int i = 1;
    while (!q.isEmpty() && i < 256) {
      Node n = q.poll();
      Node left = new Node((char) (i++));
      Node right = new Node((char) (i++));
      n.left = left;
      n.right = right;
      q.add(left);
      q.add(right);
    }
    return root;
  }


  public static void main(String[] args) {
    PrettyPrintBinaryTree p = new PrettyPrintBinaryTree();
    Node root = p.bfsFillChar256();
  }



}
