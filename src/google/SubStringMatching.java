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
      if (bPtr < 0 || B.charAt(bPtr) != A.charAt(aPtr))
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

  // Tests
  public static void main(String[] args) {
    SubStringMatching ssm = new SubStringMatching();
    System.out.println(ssm.solution("abcd", "cdabcdabc") == 3 ? "true" : "false");
    System.out.println(ssm.solution("abcde", "cdabcdabc") == -1 ? "true" : "false");
    System.out.println(ssm.solution("eabcd", "cdabcdabc") == -1 ? "true" : "false");
    System.out.println(ssm.solution("abcd", "abcd") == 1 ? "true" : "false");
    System.out.println(ssm.solution("abcd", "abcda") == 2 ? "true" : "false");
  }

}
