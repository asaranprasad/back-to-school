/* Find both the minimum and maximum element in an array in O(logn) time */

package misc;

public class MiniMax {

  public static void main(String[] args) {

    int[] a = {3, 21, 4, 47, 3, 3, 6, 23, 7, 43, -23, 6, 5, 3, 4};
    int[] op = (new MiniMax()).minimax(a, 0, a.length - 1);
    System.out.println("min: " + op[0]);
    System.out.println("max: " + op[1]);
  }

  // start and end - inclusive closed intervals
  private int[] minimax(int[] a, int start, int end) {
    int[] op = new int[2];
    if (start == end) {
      op[0] = a[start];
      op[1] = a[start];
      return op;
    }

    int mid = (end - start) / 2;

    int[] o1 = minimax(a, start, start + mid);
    int[] o2 = minimax(a, start + mid + 1, end);

    op[0] = (o1[0] < o2[0]) ? o1[0] : o2[0];
    op[1] = (o1[1] > o2[1]) ? o1[1] : o2[1];

    return op;
  }


}
