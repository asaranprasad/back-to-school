package leetcode;
<<<<<<< HEAD

=======
 
>>>>>>> 37d26e1909f2bb9bcc478e2b47ba528271069785
import java.util.*;

public class BFSAscendingOrder {

  public static void main(String[] args) {
    BFSAscendingOrder b = new BFSAscendingOrder();
    List<Integer> out = b.bfsAsc(5, Arrays.asList(1,1,2,2), Arrays.asList(2,5,3,4), 1);
    System.out.println(Arrays.toString(out.toArray()));
  }
  
  private List<Integer> bfsAsc(int n, List<Integer> from, List<Integer> to, int host){
    host--;
<<<<<<< HEAD
    List<Integer> out = new List<>();

    List<Integer>[] graph = new List<>[n];
    for(int i = 0; i < graph.length; i++) graph[i] = new LinkedList<Integer>();
    
    for(int i = 0; i < graph.length; i++){
    	graph[from - 1].add(to - 1);
    	graph[to - 1].add(from - 1);
=======
    List<Integer> out = new LinkedList<>();

    List<Integer>[] graph = new List[n];
    for(int i = 0; i < graph.length; i++) graph[i] = new LinkedList<Integer>();
    
    for(int i = 0; i < from.size(); i++){
        graph[from.get(i) - 1].add(to.get(i) - 1);
        graph[to.get(i) - 1].add(from.get(i) - 1);
>>>>>>> 37d26e1909f2bb9bcc478e2b47ba528271069785
    }
    
    for(int i = 0; i < graph.length; i++) Collections.sort(graph[i]);

    Queue<Integer> q = new LinkedList<>();
<<<<<<< HEAD
	boolean[] visited = new boolean[n];

	while(!q.isEmpty()){
		int v = q.poll();
		if(v != host) out.add(v + 1);
		visited[v] = true;

		for(int neigh : graph[v]){
			if(!visited[neigh]) q.add(neigh);
		}
	}
	return out;
=======
    q.add(host);
    boolean[] visited = new boolean[n];

    while(!q.isEmpty()){
        int v = q.poll();
        if(v != host) out.add(v + 1);
        visited[v] = true;

        for(int neigh : graph[v]){
            if(!visited[neigh]) q.add(neigh);
        }
    }
    return out;
>>>>>>> 37d26e1909f2bb9bcc478e2b47ba528271069785
  }

}
