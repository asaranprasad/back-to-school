package misc;

import java.util.Random;

public class QuickSortVariants {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] a = {5, 9, 6, 8, 3, 10, 2, 7, 4, 1};
    System.out.println(kthSmallestElement(a, 0, a.length, 2));
    System.out.println(kthSmallestElement(a, 0, a.length, (a.length / 2)));
    quickSort(a, 0, a.length);
    for (int i : a)
      System.out.print(i + " ");
  }

  private static void quickSort(int[] a, int start, int end) {
    if (start >= end - 1)
      return;
    int q = randomizedPartition(a, start, end);
    quickSort(a, start, q);
    quickSort(a, q + 1, end);

  }

  public static int kthSmallestElement(int[] a, int start, int end, int k) {
    if (start >= end - 1)
      return a[start];
    int q = randomizedPartition(a, start, end);

    int i = q - start + 1;
    if (i == k)
      return a[q];
    if (k < i)
      return kthSmallestElement(a, start, q, k);
    else
      return kthSmallestElement(a, q + 1, end, k - i);

  }

  public static int randomizedPartition(int[] a, int start, int end) {
    int x = random(start, end - 1);
    swap(a, x, end - 1);
    int pivot = a[end - 1];

    int u = start - 1;
    for (int i = start; i < end - 1; i++) {
      if (a[i] <= pivot) {
        u++;
        swap(a, i, u);
      }
    }
    swap(a, u + 1, end - 1);
    return u + 1;
  }

  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static int random(int start, int end) {
    try {
      Random rand = new Random();
      return rand.nextInt(end - start + 1) + start;
    } catch (Exception e) {
    }
    return start;
  }

}
