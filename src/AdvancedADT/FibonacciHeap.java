package AdvancedADT;

public class FibonacciHeap {
  private DNode min;
  private int n; // nodes count

  // Factory method - Returns a new heap data structure object
  public static FibonacciHeap makeFibHeap() {
    FibonacciHeap H = new FibonacciHeap();
    H.setMin(null);
    H.setNodeCount(0);
    return H;
  }

  // Maximum possible number of degrees in the heap.
  // Known to be of O(log n)
  private int D() {
    // sufficiently large constant 10
    return 10 * (int) (Math.log(n) / Math.log(2));
  }

  public void setMin(DNode minimum) {
    this.min = minimum;
  }

  public void setNodeCount(int n) {
    this.n = n;
  }

  public int n() {
    return n;
  }

  public int size() {
    return n;
  }

  /** Insert new node x into the heap */
  public void fibHeapInsert(DNode x) {
    // init pointers of x
    x.degree = 0;
    x.parent = null;
    x.child = null;
    x.mark = false;
    // insert x into the root list of heap based on whether
    // heap is empty or not
    if (min == null) {
      createNewRootList(x);
      min = x;
    } else {
      insertIntoRootList(x, min);
      // make x min if rightly so
      if (x.key < min.key)
        min = x;
    }
    n = n + 1;
  }

  /** create new root list with only x */
  private void createNewRootList(DNode x) {
    min = x;
    min.left = x;
    min.right = x;
    min.parent = null;
  }

  /** insert x into the non-empty root list of the heap */
  private void insertIntoRootList(DNode x, DNode after) {
    if (after == null)
      after = min;
    x.right = after.right;
    after.right.left = x;
    after.right = x;
    x.left = after;
    x.parent = null;
  }

  /** remove z from the root list */
  private void removeFromRootList(DNode z) {
    // if empty heap
    if (z == null)
      return;
    // if heap has only z as its element
    if (z.left == z) {
      min = null;
      return;
    }
    // update pointers of previous and next nodes
    min = z.right;
    z.left.right = z.right;
    z.right.left = z.left;
  }

  /** make y a child of parent, incrementing parent's degree */
  private void insertToChildList(DNode parent, DNode y) {
    DNode firstChild = parent.child;
    // insert immediately after the firstChild of the parent
    if (firstChild != null) {
      y.left = firstChild;
      y.right = firstChild.right;
      y.right.left = y;
      firstChild.right = y;
    } else {
      // make y parent's first child
      parent.child = y;
      y.left = y;
      y.right = y;
    }
    y.parent = parent;
    parent.degree = parent.degree + 1;
  }

  /** remove y from the child-list of parent, decrementing parent's degree */
  private void removeFromChildList(DNode parent, DNode y) {
    DNode firstChild = parent.child;
    if (firstChild != null) {
      if (y.key == firstChild.key) {
        // y is the only child of parent
        if (firstChild.left == firstChild) {
          parent.child = null;
          return;
        }
        parent.child = firstChild.right;
      }
      y.left.right = y.right;
      y.right.left = y.left;
      parent.degree = parent.degree - 1;
    }
  }

  /** Returns the node with the minimum key in the heap */
  public DNode minimum() {
    return min;
  }

  /**
   * Creates and returns union of the given two heaps. Destroys the original heaps in the process
   */
  public static FibonacciHeap fibHeapUnion(FibonacciHeap H1, FibonacciHeap H2) {
    FibonacciHeap H = makeFibHeap();
    H.setMin(H1.minimum());
    concatenateToRootList(H, H2);
    if (H1.minimum() == null
        || (H2.minimum() != null && H2.minimum().key < H1.minimum().key))
      H.setMin(H2.minimum());
    H.setNodeCount(H1.n() + H2.n());
    return H;
  }

  /** Appends H2 to H */
  private static void concatenateToRootList(FibonacciHeap H, FibonacciHeap H2) {
    // if either of the heaps are empty
    if (H.minimum() == null) {
      H.setMin(H2.minimum());
      return;
    } else if (H2.minimum() == null)
      return;
    // update pointers of the circular doubly linked list
    DNode hRight = H.minimum().right;
    DNode h2Left = H2.minimum().left;
    H.minimum().right = H2.minimum();
    H2.minimum().left = H.minimum();
    hRight.left = h2Left;
    h2Left.right = hRight;
  }

  /** Removes and returns the node with the minimum value in the heap */
  public DNode fibHeapExtractMin() {
    DNode z = min;
    if (z != null) {
      DNode x = z.child;
      if (x != null)
        // make each child of the min node a root node
        do {
          DNode next = x.right;
          insertIntoRootList(x, min);
          x = next;
        } while (x != z.child);

      removeFromRootList(z);
      if (z == z.right)
        min = null;
      else {
        // assigning min temporarily to the next node in the root list
        min = z.right;
        consolidate();
      }
      n = n - 1;
    }
    return z;
  }

  /** Fixes the instability caused by the fibHeapExtractMin node */
  private void consolidate() {
    DNode[] A = new DNode[D()];
    for (int i = 0; i < A.length; i++)
      A[i] = null;

    DNode firstRoot = min;
    DNode x = firstRoot;
    if (firstRoot != null) {
      // Coalescing equal degree roots
      // as they form.
      do {
        x = x.right;
        int d = x.degree;
        while (d < A.length && A[d] != null) {
          DNode y = A[d];
          if (x.key > y.key) {
            // exchange x with y
            DNode temp = x;
            x = y;
            y = temp;
          }
          // making sure to maintain the firstRoot 
          // in order to break the do-while loop
          if (y == firstRoot)
            firstRoot = y.left;
          fibHeapLink(y, x);
          A[d] = null;
          d++;
        }
        A[d] = x;
      } while (x != firstRoot);
    }
    min = null;

    // build a new root list from A[]
    DNode prev = min;
    for (int i = 0; i < A.length; i++) {
      if (A[i] != null) {
        if (min == null) {
          createNewRootList(A[i]);
          min = A[i];
          prev = min;
        } else {
          insertIntoRootList(A[i], prev);
          prev = A[i];
          if (A[i].key < min.key)
            min = A[i];
        }
      }
    }
  }

  /** Link node y to the child list of x */
  private void fibHeapLink(DNode y, DNode x) {
    removeFromRootList(y);
    insertToChildList(x, y);
    y.mark = false;
  }

  /** Decrease the key of x to k and modify the heap if needed */
  public void fibHeapDecreaseKey(DNode x, int k) {
    if (k > x.key) {
      System.out.println("new key is greated than current key");
      return;
    }
    x.key = k;
    DNode y = x.parent;
    // if x not a root node and vioates heap property
    if (y != null && x.key < y.key) {
      cut(x, y);
      cascadingCut(y);
    }
    if (x.key < min.key)
      min = x;
  }

  /**
   * Cuts child x from parent y. Adds x to root list of the heap.
   */
  private void cut(DNode x, DNode y) {
    removeFromChildList(y, x);
    insertIntoRootList(x, min);
    x.parent = null;
    x.mark = false;
  }

  /**
   * Percolates cut() up the tree if necessary
   */
  private void cascadingCut(DNode y) {
    DNode z = y.parent;
    // if y is not a root node
    if (z != null) {
      // if this is the first child cut from y ever since y became z's child
      if (y.mark == false)
        y.mark = true;
      // if this is the second child cut from y ever since y became z's child
      else {
        cut(y, z);
        cascadingCut(z);
      }
    }
  }

  /**
   * Delete the given node from the heap
   */
  public void fibHeapDelete(DNode x) {
    fibHeapDecreaseKey(x, Integer.MIN_VALUE);
    fibHeapExtractMin();
  }

  /**
   * Tests
   */
  public static void main(String[] args) {
    FibonacciHeap H = makeFibHeap();
    int[] values = {18, 38, 24, 7, 17, 23, 21, 39, 41, 26, 46, 30, 52, 35};
    DNode[] nodeValues = new DNode[values.length];
    DNode[] delValues = {new DNode(34), new DNode(43), new DNode(45), new DNode(32),
        new DNode(23), new DNode(4)};

    // Insert - Set 1
    for (int i = 0; i < values.length; i++) {
      nodeValues[i] = new DNode(values[i]);
      H.fibHeapInsert(nodeValues[i]);
    }

    // Insert - Set 2
    //    for (DNode node : delValues) {
    //      H.fibHeapInsert(node);
    //
    //      System.out.println("min: " + H.key(H.minimum()));
    //      System.out.println("n: " + H.n());
    //    }
    H.printHeap();

    H.fibHeapDelete(nodeValues[0]);

    // Delete - Set 1
    //    for (DNode node : delValues) {
    //      System.out.println("Deleting key: " + H.key(node));
    //      H.fibHeapDelete(node);
    //      System.out.println("min: " + H.key(H.minimum()));
    //      System.out.println("n: " + H.n());
    //    }


    H.printHeap();

    //    // Delete - Set 2
    //    for (DNode node : nodeValues) {
    //      System.out.println("Deleting key: " + H.key(node));
    //      H.fibHeapDelete(node);
    //      //      H.printHeap();
    //      System.out.println("min: " + H.key(H.minimum()));
    //      System.out.println("n: " + H.n());
    //    }

  }

  /**
   * Prints to console the heap
   */
  public void printHeap() {
    DNode firstRoot = min;
    DNode x = firstRoot;
    System.out.println("RootList: ");
    if (firstRoot != null)
      do {
        x = x.right;
        System.out.print(x.key + "(" + x.degree + " l:" + key(x.left) + " r:"
            + key(x.right) + " p:" + key(x.parent) + " c:"
            + getChildrenStats(x) + ")" + " -> ");
      } while (x != firstRoot);
    System.out.println();
  }

  /**
   * Returns key of the node if node not null, "null" otherwise.
   */
  private String key(DNode node) {
    return (node == null) ? "null" : (node.key + "");
  }

  /**
   * Returns a string containing concatenated stats of the children of z. Returns null of z is null or
   * has no children
   */
  private String getChildrenStats(DNode z) {
    if (z != null) {
      StringBuilder b = new StringBuilder();
      DNode firstChild = z.child;
      DNode x = firstChild;
      if (firstChild != null) {
        do {
          x = x.right;
          b.append(x.key + "(" + x.degree + " l:" + key(x.left) + " r:"
              + key(x.right) + " p:" + key(x.parent) + " c:"
              + getChildrenStats(x) + ")" + " ");
        } while (x != firstChild);
      } else
        b.append("null");
      return b.toString();
    }
    return "null";
  }

}
