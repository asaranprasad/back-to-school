package treesADT;

import java.util.ArrayList;
import java.util.List;

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
    RedBlackTree T = new RedBlackTree();
    int[] keys = {34, 1, 32, 53, -23, 234, 32, 123, 30, 4};

    // Build tree via inserts
    for (int key : keys) {
      T.rbInsert(new RedBlackNode(key));
    }

    printList(T.rbSort(T.TRoot));

  }

  public static void printList(List<RedBlackNode> list) {
    for (RedBlackNode node : list) {
      System.out.println(node.key);
    }
  }

}
