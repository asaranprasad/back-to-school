//https://leetcode.com/problems/word-break-ii/description/
package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {


  // checks if word break is possible
  public boolean wordBreak1(String s, List<String> wordDict) {
    int n = s.length();
    s = " " + s;
    boolean[] C = new boolean[n + 1];
    C[0] = true;

    for (int j = 1; j <= n; j++) {
      for (String wordk : wordDict) {
        int k = wordk.length();
        if (j - k >= 0) {
          String sub = s.substring(j - k + 1, j + 1);
          if (sub.equals(wordk) && !C[j]) {
            C[j] = C[j - sub.length()] && true;
          }
        }
      }
    }
    return C[n];
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    s = " " + s;
    boolean[] C = new boolean[n + 1];
    C[0] = true;
    List[] S = new List[n + 1];
    for (int i = 0; i <= n; i++)
      S[i] = new ArrayList<Integer>();

    for (int j = 1; j <= n; j++) {
      for (int i = 0; i < wordDict.size(); i++) {
        String wordk = wordDict.get(i);
        int k = wordk.length();
        if (j - k >= 0) {
          String sub = s.substring(j - k + 1, j + 1);
          if (sub.equals(wordk)) {
            //            System.out.println(sub + " : " + j);
            if (C[j - sub.length()])
              C[j] = true;
            S[j].add(j - k);
          }
        }
      }
    }

    List<String> trace = new ArrayList<String>();


    //    for (int i = 0; i < S.length; i++) {
    //      for (int j = n; j > 0;) {
    //        int k = (int) S[i].get(j);
    //        System.out.print(s.substring(j - k + 1, j + 1) + " ");
    //        j = j - k;
    //      }
    //      System.out.println();
    //    }
    return traceOutput(trace, s, S, n);
  }


  private List<String> traceOutput(List<String> trace, String str, List[] s, int n) {
    if (n < 1)
      return trace;
    List<String> gathered = new ArrayList<String>();
    for (int j = 0; j < s[n].size(); j++) {
      int ind = (int) s[n].get(j);
      String sub = str.substring(ind + 1, n + 1);
      gathered = new ArrayList<String>();
      for (int i = 0; i < trace.size(); i++) {
        String soFar = trace.get(i);
        String newString = sub + " " + soFar;
        gathered.add(newString);
      }
      gathered = traceOutput(gathered, str, s, ind);
    }

    return gathered;
  }

  public static void main(String[] args) {
    String s = "catsanddog";
    List<String> wordDict =
        Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog"});
    WordBreak wb = new WordBreak();
    //    System.out.println(s + " : " + wb.wordBreak(s, wordDict));
    System.out.println("pineapplepenapple" + " : "
        + wb.wordBreak("pineapplepenapple", Arrays
            .asList(new String[] {"apple", "pen", "applepen", "pine", "pineapple"})));
    //    System.out.println("catsandog" + " : " + wb.wordBreak("catsandog", wordDict));
    //    System.out.println("aaaaaaa" + " : "
    //            + wb.wordBreak("aaaaaaa", Arrays.asList(new String[] {"aaaa", "aaa"})));

  }

}
