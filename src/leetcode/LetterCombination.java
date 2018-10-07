package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombination {

  public static void main(String[] args) {
    LetterCombination lc = new LetterCombination();
    lc.letterCombinations("23");
  }


  public List<String> letterCombinations(String digits) {
    /* Init and populate the Hashmap of Phone numbers to characters */
    HashMap<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
    map.put(2, Arrays.asList('a', 'b', 'c'));
    map.put(3, Arrays.asList('d', 'e', 'f'));
    map.put(4, Arrays.asList('g', 'h', 'i'));
    map.put(5, Arrays.asList('j', 'k', 'l'));
    map.put(6, Arrays.asList('m', 'n', 'o'));
    map.put(7, Arrays.asList('p', 'q', 'r', 's'));
    map.put(8, Arrays.asList('t', 'u', 'v'));
    map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

    List<String> comb = new LinkedList<String>();
    buildString(digits, 0, "", comb, map);
    return comb;
  }


  private void buildString(String digits, int index, String currBuild, List<String> comb,
      HashMap<Integer, List<Character>> map) {
    int thisDigit = Character.getNumericValue(digits.charAt(index));
    for (char eachChar : map.get(thisDigit)) {
      String nextSeq = currBuild + eachChar;
      if (index == digits.length() - 1) {
        comb.add(nextSeq);
      } else {
        buildString(digits, index + 1, nextSeq, comb, map);
      }
    }
  }
}
