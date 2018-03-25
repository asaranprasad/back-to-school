package leetcode;

public class isNumeric {

  static int testStat;

  public static void main(String[] args) {
    isNumeric z = new isNumeric();
    System.out.println(test(z.isNumber("    10522545459"), true));
    System.out.println(test(z.isNumber(""), false));
    System.out.println(test(z.isNumber("0"), true));
    System.out.println(test(z.isNumber("-1"), true));
    System.out.println(test(z.isNumber("+-1"), false));
    System.out.println(test(z.isNumber("a"), false));
    System.out.println(test(z.isNumber("e"), false));
    System.out.println(test(z.isNumber("1e"), false));
    System.out.println(test(z.isNumber("4."), true));
    System.out.println(test(z.isNumber("5.0"), true));
    System.out.println(test(z.isNumber("5.e5"), true));
    System.out.println(test(z.isNumber("5.3214e5"), true));
    System.out.println(test(z.isNumber(".e5"), false));
    System.out.println(test(z.isNumber(".5"), true));
    System.out.println(test(z.isNumber("."), false));
    System.out.println(test(z.isNumber("-"), false));
    System.out.println(test(z.isNumber("+"), false));
    System.out.println(test(z.isNumber("5+"), false));
    System.out.println(test(z.isNumber("0.4-"), false));
    System.out.println(test(z.isNumber("6+1"), false));
    System.out.println(test(z.isNumber("+."), false));
    System.out.println(test(z.isNumber("+.8"), true));
    System.out.println(test(z.isNumber(".e1"), false));
    System.out.println(test(z.isNumber("46.e3"), true));
    System.out.println(test(z.isNumber(".-4"), false));
    System.out.println(test(z.isNumber("6e6.5"), false));
    System.out.println(test(z.isNumber(" 005047e+6"), true));
    System.out.println(test(z.isNumber("32.e-80123"), true));
    System.out.println(test(z.isNumber("  -32.e-80123"), true));
    System.out.println(test(z.isNumber("-+4"), false));
    System.out.println(test(z.isNumber("32.e+-80"), false));
    System.out.println(test(z.isNumber("32.-e+80"), false));


    if (testStat == 0)
      System.out.println("\n\nALL TESTS PASS");
    else
      System.out.println("\n\n" + testStat + " TESTS FAIL");
  }

  public static String test(boolean val, boolean exp) {
    String ret = val + "\t";
    if (val == exp)
      ret = ret + "pass";
    else {
      ret = ret + "fail";
      testStat++;
    }

    return ret;
  }


  public boolean isNumber(String s) {
    System.out.print(s + ": ");
    s = s.trim();

    if (s.length() == 0)
      return false;
    if (s.charAt(0) == 'e')
      return false;
    if (s.charAt(s.length() - 1) == 'e')
      return false;
    if (s.charAt(s.length() - 1) == '+')
      return false;
    if (s.charAt(s.length() - 1) == '-')
      return false;
    if (occuranceOf('+', s) + occuranceOf('-', s) > 2)
      return false;
    if (occuranceOf('+', s) > 2)
      return false;
    if (occuranceOf('-', s) > 2)
      return false;
    if (occuranceOf('e', s) > 1)
      return false;
    if (occuranceOf('.', s) > 1)
      return false;
    if (s.length() == 1)
      if (occuranceOf('.', s) == 1 || occuranceOf('+', s) == 1
          || occuranceOf('-', s) == 1)
        return false;

    char prev = '0';
    boolean befDec = false;
    boolean decOccured = false;
    boolean eOccured = false;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);


      if (!isDigit(c) && c != '+' && c != '-' && c != 'e' && c != '.')
        return false;

      if (c == '+' || c == '-') {
        if (isDigit(prev))
          if (i > 0)
            return false;
        if (decOccured && !eOccured)
          return false;
      }

      if (prev == '+' || prev == '-')
        if ((!isDigit(c) && c != '.') || (c == '.' && i == s.length() - 1))
          return false;

      if (c == 'e') {
        eOccured = true;
        if (prev == '.') {
          if (!befDec)
            return false;
        } else if (!isDigit(prev))
          return false;
      }

      if (prev == 'e')
        if (!isDigit(c) && !(c == '+' || c == '-'))
          return false;

      if (c == '.') {
        decOccured = true;
        if (isDigit(prev) && i != 0)
          befDec = true;
        if (eOccured)
          return false;
      }

      prev = c;
    }

    return true;
  }

  private boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }

  private int occuranceOf(char c, String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) == c)
        count++;
    return count;
  }

}
