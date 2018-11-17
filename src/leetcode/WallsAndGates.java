package leetcode;

import java.util.LinkedList;

public class WallsAndGates {

  public static void main(String[] args) {

    int[][] r = {{2147483647, -1, 0, 2147483647},
        {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1},
        {0, -1, 2147483647, 2147483647}};
    new WallsAndGates().wallsAndGates(r);

    for (int[] m : r) {
      for (int n : m) {
        if(n == Integer.MAX_VALUE) n = -10;
        System.out.print(n + "\t");
      }
      System.out.println();
    }

  }

  class Point {
    int i;
    int j;
    int val;

    Point(int i, int j, int val) {
      this.i = i;
      this.j = j;
      this.val = val;
    }
  }

  public void wallsAndGates(int[][] r) {
    int m = r.length;
    if (m < 1)
      return;
    int n = r[0].length;
    final int INF = Integer.MAX_VALUE;
    final int[][] neighs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (r[i][j] != INF)
          continue;
        int steps = 1;
        boolean[][] visited = new boolean[m][n];
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(new Point(i, j, r[i][j]));
        queue.add(null);
        while (queue.size() > 0) {
          Point p = queue.poll();
          if (p == null && queue.peek() == null) {
            r[i][j] = INF;
            break;
          }
          if (p == null) {
            steps++;
            queue.add(null);
            continue;
          }

          if (!visited[p.i][p.j]) {
            visited[p.i][p.j] = true;
            if (p.val == 0) {
              r[i][j] = steps;
              break;
            }
            for (int[] neigh : neighs) {
              int ni = i + neigh[0];
              int nj = j + neigh[1];
              if (isWithinBounds(r, ni, nj) && !visited[ni][nj])
                queue.add(new Point(ni, nj, r[ni][nj]));
            }
          }
        }
      }
    }
  }

  private boolean isWithinBounds(int[][] r, int i, int j) {
    int m = r.length;
    int n = r[0].length;
    return i >= 0 && i < m && j >= 0 && j < n;
  }

}
