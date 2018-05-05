package google;

import java.util.LinkedList;
import java.util.List;

public class LongestMatchingPath {

  /**
   * Array A represents the label of each node in the tree Node 1 -> Node n.
   * 
   * Array E represents the list of edges from node 2i to 2i+1
   * 
   * @param A
   * @param E
   * @return
   */
  public int solution(int[] A, int[] E) {
    int n = A.length;
    List<Integer>[] adj = new LinkedList[n];

    for (int i = 0; i < n; i++)
      adj[i] = new LinkedList<Integer>();

    for (int i = 0; i < E.length; i = i + 2) {
      adj[E[i] - 1].add(E[i + 1] - 1);
      adj[E[i + 1] - 1].add(E[i] - 1);
    }

    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      int firstLen = 0;
      int secondLen = 0;
      for (int neighbour : adj[i]) {
        if (A[neighbour] == A[i]) {
          int pathLen = dfs(neighbour, adj, A, i, 1);
          if (pathLen > firstLen) {
            secondLen = firstLen;
            firstLen = pathLen;
          } else if (pathLen > secondLen) {
            secondLen = pathLen;
          }
          maxLen = Math.max(maxLen, firstLen + secondLen);
        }
      }
    }
    return maxLen;
  }

  private static int dfs(int node, List<Integer>[] adj, int[] A, int parent, int len) {
    if (A[node] != A[parent])
      return len - 1;

    int maxLen = 0;
    for (int n : adj[node]) {
      if (n != parent) {
        int thisLen = dfs(n, adj, A, node, len + 1);
        maxLen = Math.max(maxLen, thisLen);
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int[] A = {1, 1, 1, 2, 3, 3, 2, 1, 3, 1, 3};
    int[] E = {1, 2, 1, 3, 1, 8, 2, 4, 2, 5, 3, 6, 8, 9, 8, 10, 8, 11, 4, 7};
    LongestMatchingPath lmp = new LongestMatchingPath();
    //    System.out.println(lmp.solution(A, E) == 3 ? "true" : "false");
    System.out.println(lmp.solution(A, E));
  }

}
