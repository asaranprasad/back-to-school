package leetcode;

public class AtoI {

  public static void main(String[] args) {
    AtoI z = new AtoI();
    //    System.out.println(z.convert("PAYPALISHIRING", 4));
    //    System.out.println(z.convert("PAYPALISHIRING", 5));
    //    System.out.println(z.convert("PAY", 5));
    System.out.println(z.myAtoi("    10522545459"));
  }

  public int myAtoi(String str) {
    str = str.trim();
    int mul = 0;
    int val = 0;
    int prev;
    for (int i = 0; i < str.length(); i++) {
      prev = val;
      char c = str.charAt(i);

      if (c == '-') {
        if (mul == 0)
          mul = -1;
        else
          return 0;
      } else if (c == '+') {
        if (mul == 0)
          mul = 1;
        else
          return 0;
      } else if (c >= '0' && c <= '9')
        val = val * 10 + valueOf(c);
      else
        break;

      if (valueOf(c) != -1 && val/10 != prev) {
        if (mul == -1)
          return Integer.MIN_VALUE;
        else
          return Integer.MAX_VALUE;
      }
    }

    if (mul == 0)
      mul = 1;

    return val * mul;
  }

  private int valueOf(char c) {
    switch (c) {
      case '0':
        return 0;
      case '1':
        return 1;
      case '2':
        return 2;
      case '3':
        return 3;
      case '4':
        return 4;
      case '5':
        return 5;
      case '6':
        return 6;
      case '7':
        return 7;
      case '8':
        return 8;
      case '9':
        return 9;
    }
    return -1;
  }
}
