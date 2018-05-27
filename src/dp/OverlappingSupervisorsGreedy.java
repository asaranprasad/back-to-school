package dp;

import java.util.Stack;

public class OverlappingSupervisorsGreedy {

  // INVARIANT: Activities are sorted by their start times
  private static Stack<Integer> overlappingSupervisors(int[] s, int[] f) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0);
    int pfi = -1, pli = -1;
    int i = 1;
    int ns = -1;
    while (i < s.length) {
      while (i < s.length) {
        if (f[i] > f[stack.peek()]) {
          ns = i;
          if (pfi == -1)
            pfi = i;
          pli = i;
          break;
        } else {
          if (pfi == -1)
            pfi = i;
          pli = i;
        }
        i++;
      }

      if (i < s.length) {
        if (s[ns] <= f[pfi]) {
          stack.pop();
        }
        pfi = -1;
        stack.push(ns);
      }
      i++;
    }

    int lastSup = stack.pop();
    if (s[pli] > f[stack.peek()])
      stack.push(lastSup);

    return stack;
  }

  public static void main(String args[]) {
    int s[] = {0, 1, 3, 5, 5, 8};
    int f[] = {6, 2, 4, 7, 9, 9};

    for (int supervisor : overlappingSupervisors(s, f))
      System.out.println(supervisor);
  }

}
