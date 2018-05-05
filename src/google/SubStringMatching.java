package google;

public class SubStringMatching {

  /**
   * Find the number of times string A has to be repeated so that string B becomes a substring of A
   * 
   * @param A
   * @param B
   * @return
   */
  public int solution(String A, String B) {
    int n = A.length();
    int m = B.length();
    int i = 0;
    int j = 0;
    int rem = 0;
    while (j < m) {
      while (A.charAt(i) != B.charAt(j) && j < m) {
        j++;
      }
      rem = j;

      // first half
      boolean flag = true;
      while (i < n && j < m) {
        if (A.charAt(i) == B.charAt(j)) {
          i++;
          j++;
          continue;
        } else {
          flag = false;
          break;
        }
      }

      if (flag == false) {
        j = (m + rem + 1) % m;
        continue;
      }

      // second half



    }
    if (A.charAt(i) != B.charAt(j)) {
      i = 0;
      j = rem + 1;
      //      continue;
    }


    return -1;

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
