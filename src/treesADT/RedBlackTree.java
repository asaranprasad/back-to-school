package treesADT;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class RedBlackNode {
  public RedBlackNode p;
  public RedBlackNode left;
  public RedBlackNode right;
  public int key;
  public boolean color;

  public RedBlackNode(int key) {
    this.key = key;
  }

  public RedBlackNode() {
    color = true;
  }

  public boolean isBlack() {
    return this.color;
  }

  public boolean isRed() {
    return !this.color;
  }

  public void setRed() {
    color = false;
  }

  public void setBlack() {
    color = true;
  }

}


public class RedBlackTree {
  private RedBlackNode TNil;
  private RedBlackNode TRoot;

  public RedBlackTree() {
    TNil = new RedBlackNode();
    TRoot = TNil;
  }

  public void leftRotate(RedBlackNode x) {
    RedBlackNode y = x.right;
    x.right = y.left;
    if (y.left != TNil)
      y.left.p = x;
    y.p = x.p;
    if (x.p == TNil)
      TRoot = y;
    else if (x == x.p.left)
      x.p.left = y;
    else
      x.p.right = y;
    y.left = x;
    x.p = y;
  }

  public void rightRotate(RedBlackNode y) {
    RedBlackNode x = y.left;
    y.left = x.right;
    if (x.right != TNil)
      x.right.p = y;
    x.p = y.p;
    if (y.p == TNil)
      TRoot = x;
    else if (y == y.p.left)
      y.p.left = x;
    else
      y.p.right = x;
    x.right = y;
    y.p = x;
  }

  public void rbInsert(RedBlackNode z) {
    RedBlackNode y = TNil;
    RedBlackNode x = TRoot;
    while (x != TNil) {
      y = x;
      if (z.key < x.key)
        x = x.left;
      else
        x = x.right;
    }
    z.p = y;
    if (y == TNil)
      TRoot = z;
    else if (z.key < y.key)
      y.left = z;
    else
      y.right = z;
    z.left = TNil;
    z.right = TNil;
    z.setRed();
    rbInsertFixup(z);
  }


  private void rbInsertFixup(RedBlackNode z) {
    while (z.p.isRed()) {
      if (z.p == z.p.p.left) {
        RedBlackNode y = z.p.p.right;
        if (y.isRed()) {
          z.p.setBlack();
          y.setBlack();
          z.p.p.setRed();
          z = z.p.p;
        } else {
          if (z == z.p.right) {
            z = z.p;
            leftRotate(z);
          }
          z.p.setBlack();
          z.p.p.setRed();
          rightRotate(z.p.p);
        }
      } else {
        RedBlackNode y = z.p.p.left;
        if (y.isRed()) {
          z.p.setBlack();
          y.setBlack();
          z.p.p.setRed();
          z = z.p.p;
        } else {
          if (z == z.p.left) {
            z = z.p;
            rightRotate(z);
          }
          z.p.setBlack();
          z.p.p.setRed();
          leftRotate(z.p.p);
        }
      }
    }
    TRoot.setBlack();
  }

  private void rbTransplant(RedBlackNode u, RedBlackNode v) {
    if (u.p == TNil)
      TRoot = v;
    else if (u == u.p.left)
      u.p.left = v;
    else
      u.p.right = v;
    v.p = u.p;
  }

  public void rbDelete(RedBlackNode z) {
    RedBlackNode y = z;
    boolean yOrigColor = y.color;
    RedBlackNode x;
    if (z.left == TNil) {
      x = z.right;
      rbTransplant(z, z.right);
    } else if (z.right == TNil) {
      x = z.left;
      rbTransplant(z, z.left);
    } else {
      y = rbMin(z.right);
      yOrigColor = y.color;
      x = y.right;
      if (y.p == z)
        x.p = y;
      else {
        rbTransplant(y, y.right);
        y.right = z.right;
        y.right.p = y;
      }
      rbTransplant(z, y);
      y.left = z.left;
      y.left.p = y;
      y.color = z.color;
    }
    if (yOrigColor)
      rbDeleteFixup(x);
  }

  private RedBlackNode rbMin(RedBlackNode x) {
    while (x.left != TNil)
      x = x.left;
    return x;
  }

  private RedBlackNode rbMax(RedBlackNode x) {
    while (x.right != TNil)
      x = x.right;
    return x;
  }

  private void rbDeleteFixup(RedBlackNode x) {
    while (x != TRoot && x.isBlack()) {
      if (x == x.p.left) {
        RedBlackNode w = x.p.right;
        if (w.isRed()) {
          w.setBlack();
          x.p.setRed();
          leftRotate(x.p);
          w = x.p.right;
        }
        if (w.left.isBlack() && w.right.isBlack()) {
          w.setRed();
          x = x.p;
        } else {
          if (w.right.isBlack()) {
            w.left.setBlack();
            w.setRed();
            rightRotate(w);
            w = x.p.right;
          }
          w.color = x.p.color;
          x.p.setBlack();
          w.right.setBlack();
          leftRotate(x.p);
          x = TRoot;
        }
      } else {
        RedBlackNode w = x.p.left;
        if (w.isRed()) {
          w.setBlack();
          x.p.setRed();
          rightRotate(x.p);
          w = x.p.left;
        }
        if (w.right.isBlack() && w.left.isBlack()) {
          w.setRed();
          x = x.p;
        } else {
          if (w.left.isBlack()) {
            w.right.setBlack();
            w.setRed();
            leftRotate(w);
            w = x.p.left;
          }
          w.color = x.p.color;
          x.p.setBlack();
          w.left.setBlack();
          rightRotate(x.p);
          x = TRoot;
        }
      }
    }
    x.setBlack();
  }

  public RedBlackNode rbSearch(RedBlackNode x, int k) {
    if (x == TNil || k == x.key)
      return x;
    if (k < x.key)
      return rbSearch(x.left, k);
    else
      return rbSearch(x.right, k);
  }

  public List<RedBlackNode> rbSort(RedBlackNode x) {
    List<RedBlackNode> sortedList = new ArrayList<RedBlackNode>();
    rbInOrderWalk(x, sortedList);
    return sortedList;
  }


  private void rbInOrderWalk(RedBlackNode x, List<RedBlackNode> sortedList) {
    if (x != TNil) {
      rbInOrderWalk(x.left, sortedList);
      sortedList.add(x);
      rbInOrderWalk(x.right, sortedList);
    }
  }

  public RedBlackNode rbSuccessor(RedBlackNode x) {
    if (x.right != TNil) {
      return rbMin(x.right);
    }
    RedBlackNode y = x.p;
    while (y != TNil && x == y.right) {
      x = y;
      y = y.p;
    }
    return y;
  }

  public RedBlackNode rbPredecessor(RedBlackNode x) {
    if (x.left != TNil) {
      return rbMax(x.left);
    }
    RedBlackNode z = x.p;
    while (z != TNil && x == z.left) {
      x = z;
      z = z.p;
    }
    return z;
  }

  public static void main(String[] args) {
    String fileName = "numbers";
    RedBlackTree T = new RedBlackTree();
    List<Integer> keys = textFileToIntList("./input/" + fileName + ".txt");

    // Build tree via inserts
    for (int key : keys) {
      T.rbInsert(new RedBlackNode(key));
    }

    // print level order
    printLevelOrder(T.rbLevelOrderTraversal(T.TRoot));

    Scanner scan = new Scanner(System.in);
    int option = 0;
    do {
      System.out.println("\nPlease enter an option number");
      System.out.println("1. sort");
      System.out.println("2. search");
      System.out.println("3. min");
      System.out.println("4. max");
      System.out.println("5. successor");
      System.out.println("6. predecessor");
      System.out.println("7. insert");
      System.out.println("8. delete");
      System.out.println("9. print-tree");
      System.out.println("10. quit");
      option = scan.nextInt();

      RedBlackNode root = T.TRoot;
      switch (option) {
        case 1:
          printList(T.rbSort(root));
          break;
        case 2:
          System.out.println("Enter the integer value to search: ");
          int k = scan.nextInt();
          if (T.rbSearch(root, k) == T.TNil)
            System.out.println("Key Not Found in Tree");
          else
            System.out.println("Key Found in Tree");
          break;
        case 3:
          System.out.println(T.rbMin(root).key);
          break;
        case 4:
          System.out.println(T.rbMax(root).key);
          break;
        case 5:
          System.out.println("Enter the integer value to find successor for: ");
          int s = scan.nextInt();
          RedBlackNode node = T.rbSearch(root, s);
          if (node == T.TNil) {
            System.out.println("Node with Key " + s + " not found");
            break;
          }
          System.out.println(T.rbSuccessor(node).key);
          break;
        case 6:
          System.out.println("Enter the integer value to find predecessor for: ");
          s = scan.nextInt();
          node = T.rbSearch(root, s);
          if (node == T.TNil) {
            System.out.println("Node with Key " + s + " not found");
            break;
          }
          System.out.println(T.rbPredecessor(node).key);
          break;
        case 7:
          System.out.println("Enter the integer value to insert: ");
          s = scan.nextInt();
          T.rbInsert(new RedBlackNode(s));
          System.out.println("Done");
          break;
        case 8:
          System.out.println("Enter the key value to delete from the tree: ");
          s = scan.nextInt();
          node = T.rbSearch(root, s);
          if (node == T.TNil) {
            System.out.println("Node with Key " + s + " not found");
            break;
          }
          T.rbDelete(node);
          System.out.println("Done");
          break;
        case 9:
          printLevelOrder(T.rbLevelOrderTraversal(root));
          break;
      }
      System.out.println("tree-height: " + T.rbHeight(T.TRoot));
    } while (option != 10);
    scan.close();
  }

  public static void printLevelOrder(List<List<RedBlackNode>> lol) {
    for (List<RedBlackNode> level : lol) {
      printList(level);
      System.out.println("");
    }
  }

  public static void printList(List<RedBlackNode> list) {
    for (RedBlackNode node : list)
      System.out.print(node.key + "\t");
  }


  public List<List<RedBlackNode>> rbLevelOrderTraversal(RedBlackNode root) {
    LinkedList<RedBlackNode> frontier = new LinkedList<RedBlackNode>();
    List<List<RedBlackNode>> ret = new LinkedList<List<RedBlackNode>>();
    if (root == null)
      return ret;
    frontier.add(root);
    frontier.add(null); // marking end of first level
    return bfs(frontier, ret, new LinkedList<RedBlackNode>());
  }

  public List<List<RedBlackNode>> bfs(LinkedList<RedBlackNode> frontier,
      List<List<RedBlackNode>> ret,
      LinkedList<RedBlackNode> collectedList) {
    RedBlackNode node = frontier.removeFirst();

    if (node == null) { // if previous level end reached,
      ret.add(collectedList); // list of elements collected so far in current level
      collectedList = new LinkedList<RedBlackNode>();
      frontier.add(null); // marking end for current level in the frontier
      node = frontier.removeFirst();
      if (node == null) // if the subsequent node is also null,
        return ret; // end of tree traversal
    }

    if (node.left != null)
      frontier.add(node.left);
    if (node.right != null)
      frontier.add(node.right);

    collectedList.add(node);

    return bfs(frontier, ret, collectedList);
  }

  public int rbHeight(RedBlackNode x) {
    return dfs(x, 0);
  }


  private int dfs(RedBlackNode x, int depth) {
    if (x == null)
      return depth;

    int depth1 = dfs(x.left, depth + 1);
    int depth2 = dfs(x.right, depth + 1);

    return depth1 > depth2 ? depth1 : depth2;
  }

  public static List<Integer> textFileToIntList(String filePath) {
    List<Integer> numbers = new ArrayList<Integer>();
    try {
      Scanner sc = new Scanner(new File(filePath));
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] numStrings = line.split(" ");
        for (String numString : numStrings)
          numbers.add(Integer.parseInt(numString));
      }
      sc.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return numbers;
  }
}
