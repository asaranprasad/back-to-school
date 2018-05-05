package google;

public class SubStringMatching {

  /**
   * Find the number of times string A has to be repeated so that string B becomes a substring of A
   * 
   * Eg: A = "abcd" ; B = "cdabcdabc"
   * 
   * Sol: 3
   * 
   * @param A
   * @param B
   * @return
   */
  public int solution(String A, String B) {
    int n = A.length();
    int m = B.length();

    int fromIndex = findStartsWithSubStr(B, A);
    int aPtr = 0;
    int bPtr = fromIndex;
    int aRep = bPtr == 0 ? 0 : 1;
    while (bPtr < m) {
      if (B.charAt(bPtr) != A.charAt(aPtr))
        return -1;
      bPtr++;
      aPtr++;
      if (aPtr >= n) {
        aRep++;
        aPtr = 0;
      }
    }

    // if after cycling-around B, A does not continue
    // => new set of A is required
    if (B.charAt(0) != A.charAt(aPtr))
      aRep++;

    return aRep;
  }


  private int findStartsWithSubStr(String bigger, String a) {
    for (int i = 0; i < a.length(); i++) {
      String substrA = a.substring(i, a.length());
      if (bigger.startsWith(substrA))
        return i;
    }
    return -1;
  }


  private int findEndsWithSubStr(String bigger, String a) {
    for (int i = a.length(); i >= 0; i--) {
      String substrA = a.substring(0, i);
      if (bigger.endsWith(substrA))
        return bigger.length() - substrA.length();
    }
    return -1;
  }


  public static void main(String[] args) {
    SubStringMatching ssm = new SubStringMatching();
    System.out.println(ssm.solution("abcd", "cdabcdabc")); // Expecting 3
  }

}
