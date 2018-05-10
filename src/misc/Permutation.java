package misc;

public class Permutation {

  public static void main(String[] args) {
    String str = "abc";
    char[] s = str.toCharArray();
    //    System.out.println(s);
    permute(s, 0, s.length - 1);

  }



  private static void permute(char[] s, int start, int end) {
    if (start >= end)
      System.out.println(s);

    else
      for (int i = start; i <= end; i++) {
        swap(s, start, i);
        permute(s, start + 1, end);
        swap(s, start, i);
      }
  }

  private static void swap(char[] s, int index1, int index2) {
    char temp = s[index1];
    s[index1] = s[index2];
    s[index2] = temp;
  }
}
