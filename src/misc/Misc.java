package misc;

import java.util.HashMap;

public class Misc {

  HashMap<Integer, Integer> dist;

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 11, 1024, 1, 2, 3, 4, 5};
    int[] a = {6, 1, 4, 5, 7, 2, 0, 9, 8, 3};
    int[] Q = {1024, 1, 2};

    Misc m = new Misc();
    //    m.mergeSort(a, 0, a.length - 1);
    m.quickSort(a, 0, a.length - 1);
    m.printArr(a);
    System.out.println(m.binSearch(a, 5, 0, a.length - 1));
    //    int[] indices = getIndicesForSubset(A, Q);
    //    
    //    System.out
    //        .println("beginIndex: " + indices[0] + " endIndex: " + indices[1]);
    //    System.out.println("\n\n");
    //    System.out.println(swapAdjacentChars("helloWorld"));
    //    System.out.println("intDiv: " + intDiv(-2, 5));
    //    System.out.println("toChar: " + ascii(100));
    //System.out.println("totalHammingDistance: " + m.totalHammingDistance(nums));
    //    System.out.println(
    //        "longestCommonSubString: "
    //            + m.longestPalindrome("xyzabcdefedcakxyz"));
  }

  public void quickSort(int[] a, int start, int end) {
    if (start >= end)
      return;
    int q = partition(a, start, end);
    quickSort(a, start, q - 1);
    quickSort(a, q + 1, end);
  }

  public int partition(int[] a, int start, int end) {
    int pivot = a[end];
    int big = start;
    for (int i = start; i <= end; i++)
      if (a[i] <= pivot)
        swap(a, i, big++);
    return big - 1;
  }



  private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public void mergeSort(int[] a, int start, int end) {
    if (start >= end)
      return;
    int mid = (start + end) / 2;
    mergeSort(a, start, mid);
    mergeSort(a, mid + 1, end);
    merge(a, start, end, mid);
  }

  public void merge(int[] arr, int start, int end, int mid) {
    int[] a = new int[mid - start + 1];
    int[] b = new int[end - mid];

    // copy into subarrays
    int j = 0;
    for (int i = start; i <= mid; i++)
      a[j++] = arr[i];
    j = 0;
    for (int i = mid + 1; i <= end; i++)
      b[j++] = arr[i];

    // sort and insert into original array
    int i = 0, k = start;
    j = 0;

    while (i < a.length && j < b.length) {
      if (a[i] < b[j])
        arr[k++] = a[i++];
      else
        arr[k++] = b[j++];
    }

    // copy rest of a, if exists
    while (i < a.length) {
      arr[k++] = a[i++];
    }

    // copy rest of b, if exists
    while (j < b.length) {
      arr[k++] = b[j++];
    }
  }

  public void printArr(int[] a) {
    for (int i : a)
      System.out.print(i + " ");
    System.out.println();
  }

  private static char[] swapAdjacentChars(String string) {
    char[] input = string.toCharArray();
    for (int i = 0; i < input.length - 1; i += 2) {
      char temp = input[i];
      input[i] = input[i + 1];
      input[i + 1] = temp;
    }
    return input;
  }

  private static int[] getIndicesForSubset(int[] a, int[] q) {
    int[] indices = {-1, -1};
    int limit = a.length;
    int qCounter = 0;

    for (int i = 0; i < limit; i++) {
      if (a[i] == q[qCounter])
        qCounter++;
      else
        qCounter = 0;

      if (qCounter == q.length) {
        indices[0] = i - qCounter + 1;
        indices[1] = i;
        break;
      }
    }
    return indices;
  }

  private static int intDiv(int a, int b) {
    return (a / b);
  }

  private static char ascii(int i) {
    return (char) i;
  }


  public int totalHammingDistance(int[] nums) {
    dist = new HashMap<Integer, Integer>();
    int sum = 0;
    System.out.println("zeros: " + hammingDistance(4, 4));
    for (int i = 0; i < nums.length - 1; i++)
      for (int j = i + 1; j < nums.length; j++) {

        sum += hammingDistance(nums[i], nums[j]);
        System.out.println(nums[i] + " " + nums[j] + " sum: " + sum);
      }

    System.out.println(" 4^4: " + (4 ^ 4));
    return sum;
  }

  public int hammingDistance(int a, int b) {
    int c = a ^ b;
    if (dist.get(c) != null)
      return dist.get(c);
    int setBitCount = 0;
    while (c != 0) {
      setBitCount += c & 1;
      c = c >> 1;
    }
    dist.put(a ^ b, setBitCount);
    return setBitCount;
  }


  private boolean isPalindrome(String s1) {
    for (int i = 0, j = s1.length() - 1; i < j; i++, j--) {
      if (s1.charAt(i) != s1.charAt(j))
        return false;
    }
    return true;
  }

  public int binSearch(int[] a, int val, int start, int end) {
    if (start > end)
      return -1;
    int mid = (start + end) / 2;
    if (a[mid] == val)
      return mid;
    else if (a[mid] > val)
      return binSearch(a, val, start, mid - 1);
    else
      return binSearch(a, val, mid + 1, end);
  }

}
