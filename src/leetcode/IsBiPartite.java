/*
Color graphs alternatively.
Return false if color of parent matches color of child.
*/

package leetcode;

public class IsBiPartite {

  public static void main(String[] args) {
    int[][] graph = {{3, 4, 6}, {3, 6}, {3, 6}, {0, 1, 2, 5}, {0, 7, 8}, {3},
        {0, 1, 2, 7}, {4, 6}, {4}, {}};
    System.out.println("isBipartite(): " + new IsBiPartite().isBipartite(graph));
  }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++)
            if(colors[i] == 0 && !dfs(graph, colors, i, 1)) 
                return false;
        
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] colors, int node, int color){
        colors[node] = color;
        int nextColor = (color == 1) ? 2 : 1;
        
        for(int child : graph[node]){    
            // If parent and child are of same color
            if(colors[child] == color) return false;
            
            // If child has not yet ben visited but once traversed, fails
            if (colors[child] == 0 && !dfs(graph, colors, child, nextColor))
                return false;
        }
        return true;
    }

}
