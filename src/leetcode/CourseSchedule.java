//https://leetcode.com/problems/course-schedule/description/

package leetcode;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] adj = new LinkedList[numCourses];

    for (int i = 0; i < numCourses; i++)
      adj[i] = new LinkedList<Integer>();

    for (int[] p : prerequisites) {
      //adj[p[1]].add(p[0]);
      adj[p[0]].add(p[1]);
    }

    // 0 - not visited (White)
    // 1 - visited (Black)
    // 2 - currently in traversal (Gray)
    int[] visited = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      if (visited[i] == 0) {
        if (!dfsCheck(adj, i, visited))
          return false;
      }
    }
    return true;
  }

  // returns false if a cycle is found
  public boolean dfsCheck(List<Integer>[] adj, int node, int[] visited) {
    for (int neigh : adj[node]) {
      if (visited[neigh] == 2)
        return false; // Cycle exists, i.e. visiting a parent Gray node
      visited[neigh] = 2; // mark as Gray
      boolean isTree = dfsCheck(adj, neigh, visited);
      if (!isTree)
        return false;
      visited[neigh] = 1;
    }
    return true;
  }

  public static void main(String[] args) {
    CourseSchedule cs = new CourseSchedule();
    System.out.println(!cs.canFinish(2, new int[][] {{1, 0}, {0, 1}}) ? "pass" : "fail");
    System.out.println(cs.canFinish(3, new int[][] {{1, 0}, {2, 0}}) ? "pass" : "fail");
    System.out.println(cs.canFinish(2, new int[][] {{1, 0}}) ? "pass" : "fail");

  }


  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer>[] adj = new LinkedList[numCourses];

    for (int i = 0; i < numCourses; i++)
      adj[i] = new LinkedList<Integer>();

    for (int[] p : prerequisites) {
      //adj[p[1]].add(p[0]);
      adj[p[0]].add(p[1]);
    }

    // -10 - not visited (White)
    // +ve - visited (Black)
    // -12 - currently in traversal (Gray)
    int[] visited = new int[numCourses];
    for (int i = 0; i < numCourses; i++)
      visited[i] = -10;

    int ord = 0;
    for (int i = 0; i < numCourses; i++) {
      if (visited[i] == -10) {
        ord = dfsCheck(adj, i, visited, ord);
        if (ord == -1)
          return new int[0];
      }
    }

    int[] order = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      System.out.print(visited[i] + " ");
      order[visited[i]] = i;
    }

    return order;
  }

  // returns false if a cycle is found
  public int dfsCheck(List<Integer>[] adj, int node, int[] visited, int order) {
    for (int neigh : adj[node]) {
      if (visited[neigh] == -12)
        return -1; // Cycle exists, i.e. visiting a parent Gray node

      visited[neigh] = -12; // mark as Gray
      order = dfsCheck(adj, neigh, visited, order);

      if (order == -1)
        return -1; // cycle detected in sub-traversal        
    }

    if (visited[node] < 0) {
      System.out
          .println("ord: " + order + " node: " + node + " visited: " + visited[node]);
      visited[node] = order++;
    }
    return order;
  }

}


