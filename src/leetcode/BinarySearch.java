package leetcode;

public class BinarySearch {

  public static void main(String[] args) {
    BinarySearch bs = new BinarySearch();
    int[] arr = {-24, -6, 1, 4, 8, 9, 10, 20, 21, 45, 58, 77, 1234};
    int target = 77;

    System.out.println("first occurance index: " + bs.binarySearch(arr, 0, arr.length, target));
    System.out.println("number of such occurances: " + bs.count_occurrences(arr, target));
  }

  private int binarySearch(int[] arr, int lo, int hi, int target) {
    // GIVEN: two integers lo and hi, an array of ints A, and a target tgt
    // WHERE: A is non-decreasing
    // AND 0 <= lo <= hi <= A.length
    // AND (forall j)(0 <= j < lo ==> A[j] < tgt)
    // AND (forall j)(hi <= j < A.length ==> A[j] > tgt)

    // RETURNS: a number k such that lo <= k < hi and f(k) = tgt if
    // there is such a k, otherwise -1.

    // HALTING MEASURE: hi-lo
    // JUSTIFICATION: hi-lo is guaranteed to be non-negative,
    // since the invariant tells us that lo <= hi,
    // and it decreases at every recursive call because one of the
    // following happens:
    // lo increases while hi stays the same
    // lo stays the same while hi decreases
    if (lo == hi)
      return -1;

    int mid = (hi + lo) / 2;
    if (target == arr[mid])
      return mid;
    else if (arr[mid] < target)
      return binarySearch(arr, mid + 1, hi, target);
    else
      return binarySearch(arr, lo, mid, target);
  }

  private int count_occurrences(int[] A, int tgt) {
    // GIVEN: A non-decreasing array A of integers
    // and an integer
    // target 'tgt'
    // RETURNS: the number of occurrences of tgt in A.

    int p = binarySearch(A, 0, A.length, tgt);
    if (p == -1)  // no occurrences of tgt in the array
      return 0;

    int lo = p;
    int hi = p;

    // INVARIANT: lo, hi in [0, A.length)
    // AND if j in [lo,hi], then A[j] = tgt

    // expand lo downwards -- can we safely decrement lo?
    // HALTING MEASURE: lo
    // JUSTIFICATION: the invariant says that lo is non-negative,
    // and lo decreases every time through the loop.
    while (lo > 0 && A[lo - 1] == tgt) {
      lo = lo - 1;
    }

    // expand hi upwards -- can we safely increment hi?
    // HALTING MEASURE: (A.length - hi)
    // JUSTIFICATION: the invariant hi in [0,A.length) implies
    // that hi is < A.length, hence (A.length - hi) is
    // non-negative. Furthermore, hi increases every time through
    // the loop, so (A.length - hi) decreases every time through
    // the loop.
    while (hi < A.length - 1 && A[hi + 1] == tgt) {
      hi = hi + 1;
    }
    return (hi - lo + 1);
  }

}
