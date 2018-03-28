package AdvancedADT;


class DNode {
  public int key;
  public DNode left;
  public DNode right;
  public DNode child;
  public DNode parent;
  public int degree;
  public boolean mark;

  public DNode(int key) {
    this.key = key;
    left = null;
    right = null;
    child = null;
    parent = null;
    degree = 0;
    mark = false;
  }
}


public class FibonacciHeap {
  private DNode min;
  private int n; // nodes count

  public static FibonacciHeap makeFibHeap() {
    FibonacciHeap H = new FibonacciHeap();
    H.setMin(null);
    H.setNodeCount(0);
    return H;
  }

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

  public void fibHeapInsert(DNode x) {
    x.degree = 0;
    x.parent = null;
    x.child = null;
    x.mark = false;
    if (min == null) {
      insertIntoRootList(x);
      min = x;
    } else {
      insertIntoRootList(x);
      if (x.key < min.key)
        min = x;
    }
    n = n + 1;
  }

  private void insertIntoRootList(DNode x) {}

  private void removeFromRootList(DNode z) {}

  public DNode minimum() {
    return min;
  }

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

  private static void concatenateToRootList(FibonacciHeap H, FibonacciHeap H2) {}

  public DNode fibHeapExtractMin() {
    DNode z = min;
    if (z != null) {
      DNode firstChild = z.child;
      DNode x = firstChild;
      do {
        x = x.right;
        if (x == null)
          break;
        insertIntoRootList(x);
        x.parent = null;
      } while (x != firstChild);
      removeFromRootList(z);
      if (z == z.right) {
        min = null;
      } else {
        min = z.right;
        consolidate();
      }
      n = n - 1;
    }
    return z;
  }



  private void consolidate() {


  }

  public static void main(String[] args) {

  }

}
