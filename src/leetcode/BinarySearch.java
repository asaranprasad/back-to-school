package leetcode;

public class BinarySearch {

  public static void main(String[] args) {
    BinarySearch bs = new BinarySearch();
    int[] arr = {-24, -6, 1, 4, 8, 9, 10, 20, 21, 45, 58, 77, 1234};
    int target = 77;
    System.out.println(bs.binarySearch(arr, 0, arr.length, target));
  }

  private int binarySearch(int[] arr, int lo, int hi, int target) {
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

}
