##Graphs

// A Java program to represent a graph
import java.util.*; 
  
// This class represents a directed graph using adjacency 
// list representation 
class Graph 
{ 
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; // Adjacency List 
  
    //Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int v,int w) { adj[v].add(w); } 
  
    // Some graph function
    void customGraphFunction(int v, boolean visited[]) 
    { }
  
    // Driver method 
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
    } 
} 
