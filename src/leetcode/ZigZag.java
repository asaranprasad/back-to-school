package leetcode;

public class ZigZag {

  public static void main(String[] args) {
    ZigZag z = new ZigZag();
//    System.out.println(z.convert("PAYPALISHIRING", 4));
//    System.out.println(z.convert("PAYPALISHIRING", 5));
//    System.out.println(z.convert("PAY", 5));
    System.out.println(z.convert("AA", 1));
  }

  public String convert(String s, int k) {
    int r = 0;
    String ret = "";
    int i = 0;
    int m = 0;

    while (i < s.length() && r < k) {
      boolean flag = true;
      ret = ret + s.charAt(i);
      if (i == 0 || (i == (k - 1))) {
        while (i < s.length()) {
          i += (2 * k - 2);
          if (i > s.length() - 1) {
            r++;
            i = r;
            break;
          }
          ret = ret + s.charAt(i);
        }
      } else {
        while (i < s.length()) {
          if (flag) {
            i += (k - 2) * 2 - m;
            flag = false;
          } else {
            i += m + 2;
            flag = true;
          }
          if (i > s.length() - 1) {
            r++;
            i = r;
            m += 2;
            break;
          }
          ret = ret + s.charAt(i);
        }
      }
    }
    return ret;
  }

}
