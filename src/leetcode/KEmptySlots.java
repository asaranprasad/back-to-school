package leetcode;

public class KEmptySlots {

  public int kEmptySlots(int[] flowers, int k) {
    int n = flowers.length;
    boolean[] bloom = new boolean[n];
    for (int i = 0; i < n; i++) {
      bloom[flowers[i] - 1] = true;
      if (kSlotsExists(bloom, k)) {
        return i + 1;
      }
    }
    return -1;
  }

  private boolean kSlotsExists(boolean[] bloom, int k) {
    int c = 0;

    // search for first bloom
    int i = 0;
    while (i < bloom.length && !bloom[i])
      i++;

    for (; i < bloom.length; i++) {
      if (bloom[i]) {
        if (c == k)
          return true;
        c = 0;
      } else
        c++;
    }
    return false;
  }

  public static void main(String[] args) {
    KEmptySlots kem = new KEmptySlots();
    System.out.println(kem.kEmptySlots(new int[] {1, 3, 2}, 1));
    //System.out.println(kem.kEmptySlots());
  }

}
