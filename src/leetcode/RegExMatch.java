package leetcode;

public class RegExMatch {

  public static void main(String[] args) {
//    System.out.println("1: " + (new RegExMatch().isMatch("baaaaaaaaaa", "ba*") == true));
//    System.out.println("2: " + (new RegExMatch().isMatch("aaaaaaaaaa", "ba*") == false));
//    System.out.println("3: " + (new RegExMatch().isMatch("a", "a*") == true));
//    System.out.println("4: " + (new RegExMatch().isMatch("", "a*") == true));
//    System.out.println("5: " + (new RegExMatch().isMatch("a", ".*") == true));
//    System.out.println("6: " + (new RegExMatch().isMatch("", ".*") == true));
    System.out.println("7: " + (new RegExMatch().isMatch("baaaaaaaaaa", "b.*") == true));
    System.out.println("8: " + (new RegExMatch().isMatch("baaaaaaaaaa", "b*.*") == true));
    System.out
        .println("9: " + (new RegExMatch().isMatch("bbbaaaaaaaaaa", "b*.*") == true));
    System.out
        .println("10: " + (new RegExMatch().isMatch("bbbaaaaaaaaaa", ".*.*") == true));
    System.out
        .println("11: " + (new RegExMatch().isMatch("aaaaaaaaaa", ".*.*") == false));

  }

  public boolean isMatch(String s, String p) {
    return backtrack(s, p, p.length() - 1, s.length() - 1, false);
  }

  public boolean backtrack(String s, String p, int i, int j, boolean splFlag) {
    if (i < 0 && j < 0)
      return true;

    if (i < 0)
      return false;

    if (j < 0) {
      return i == 1 && p.charAt(i) == '*';
    }

    //    if (j == 0 && i > 0)
    //      return false;

    if (i == 0 && j > 0)
      if (!splFlag)
        return false;

    char pc = p.charAt(i);
    char sc = s.charAt(j);

    //System.out.println(sc + " " + pc);

    if (j == 0 && i == 0)
      return (pc == sc || pc == '.');

    if (pc == '.') {
      if (splFlag) {
        boolean minimumOne = false;
        for (int jj = j; jj >= 0; j--) {
          minimumOne = minimumOne || backtrack(s, p, --i, jj, false);
        }
        return minimumOne;
      } else {
        return backtrack(s, p, --i, --j, false);
      }
    } else if (pc == '*') {
      return backtrack(s, p, --i, j, true);
    } else {
      if (splFlag) {
        int jj = j;
        while (jj >= 0 && pc == s.charAt(jj))
          jj--;
        j = jj + 1;
      } else if (pc != sc)
        return false;

      return backtrack(s, p, --i, --j, false);
    }
  }
}
