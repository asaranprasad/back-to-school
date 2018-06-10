package leetcode;

public class Easy {

  public int lengthOfLastWord(String s) {
    int slen = s.length() - 1;
    if (slen < 0)
      return 0;

    while (slen > -1 && s.charAt(slen) == ' ')
      slen--;
    if (slen < 0)
      return 0;

    int i = slen;
    while (i > -1 && s.charAt(i) != ' ')
      i--;

    return slen - i;
  }

  public static void main(String[] args) {

  }

}
