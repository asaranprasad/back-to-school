package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pb1 {

  public static void main(String[] args) {
    Pb1 pb = new Pb1();

//    List<String> out = pb.subStringsKDist("awaglknagawunagwkwagl", 4);
    List<String> out = pb.subStringsKDist("abcd", 4);

    for (String s : out) {
      System.out.println(s);
    }

  }

  public List<String> subStringsKDist(String inputStr, int num) {
    Set<String> oSet = new HashSet<String>();

    for (int i = 0; i + num < inputStr.length(); i++) {
      String subStr = inputStr.substring(i, i + num);

      if (isUnique(subStr.toCharArray()))
        oSet.add(subStr);

    }
    return new ArrayList<String>(oSet);
  }

  private boolean isUnique(char[] cs) {
    Set<Character> uSet = new HashSet<Character>();

    for (Character c : cs) {
      if (uSet.contains(c))
        return false;
      else
        uSet.add(c);
    }
    return true;
  }


}
