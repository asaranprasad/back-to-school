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
    int height = dfsForHeight(root, 0);

    // BFS and print tree
    Queue<Node> q = new LinkedList<Node>();
    q.add(null);
    q.add(root);
    int hNow = -1; // iterative height counter
    while (!q.isEmpty()) {
      Node n = q.poll();
      if (n == null) { // Level complete
        System.out.println();// empty line to print next level
        n = q.poll();
        if (n == null)
          break; // Double null => traversal complete

        q.add(null); // marking end of next level

        hNow++;
        // Spaces before level fill
        int numSpacesBefore = (int) (Math.pow(2, height - hNow) - 2);
        for (int j = 0; j < numSpacesBefore; j++)
          System.out.print(" ");
      }
      System.out.print(n.data);
      // Adding children to the frontier queue
      if (n.left != null)
        q.add(n.left);
      if (n.right != null)
        q.add(n.right);

      // Spaces mid level fill
      int numSpacesMid = (int) (Math.pow(2, height - hNow + 1) - 1);
      for (int j = 0; j < numSpacesMid; j++)
        System.out.print(" ");
    }
  }

  private int dfsForHeight(Node root, int heightNow) {
    if (root == null)
      return heightNow - 1;
    return Math.max(dfsForHeight(root.left, heightNow + 1),
        dfsForHeight(root.right, heightNow + 1));
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


  private Node bfsFillChar26() {
    int i = (int) ('a');
    Node root = new Node((char) i);
    Queue<Node> q = new LinkedList<Node>();
    i++;
    while (!q.isEmpty() && i <= (char) ('z')) {
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
    Node root = p.bfsFillChar26();
    p.prettyPrintToConsole(root);
  }



}
