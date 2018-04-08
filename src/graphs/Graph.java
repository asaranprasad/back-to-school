package graphs;

import java.util.LinkedList;

class VertexAndWeights {
  public Vertex v;
  public int w;

  public VertexAndWeights(Vertex v, int w) {
    this.v = v;
    this.w = w;
  }

  public VertexAndWeights() {
    v = null;
    w = 0;
  }
}


public class Graph {
  LinkedList<VertexAndWeights>[] Adj;
  int V; // num of vertices in the graph
  boolean isUndirected;

  // init graph just with number of vertices information
  @SuppressWarnings("unchecked")
  public Graph(int V) {
    this.V = V;
    Adj = new LinkedList[V];

    // init Adjacency list
    for (int i = 0; i < V; i++) {
      Adj[i] = new LinkedList<VertexAndWeights>();
    }
    isUndirected = false;
  }

  public Graph(LinkedList<VertexAndWeights>[] Adj) {
    this.Adj = Adj;
    isUndirected = false;
  }

  public Graph(int V, boolean isUndirected) {
    this(V);
    this.isUndirected = isUndirected;
  }

  public void setGraphAsUndirected() {
    isUndirected = true;
  }

  public void resetGraphAsDirected() {
    isUndirected = false;
  }

  public static void addEdge(Graph G, Vertex source,
      Vertex destination, int weight) {
    VertexAndWeights vw = new VertexAndWeights(destination, weight);
    // add to adjacency list
    G.Adj[source.graphIndex].add(vw);

    // add again vice-versa if graph is undirected
    if (G.isUndirected) {
      vw = new VertexAndWeights(source, weight);
      G.Adj[destination.graphIndex].add(vw);
    }
  }

  public Vertex[] v() {
    Vertex[] vertices = new Vertex[Adj.length];
    for (int i = 0; i < Adj.length; i++)
      vertices[i] = Adj[i].get(0).v;
    return vertices;
  }

  public LinkedList<VertexAndWeights> Adj(Vertex u) {
    for (LinkedList<VertexAndWeights> adj : Adj)
      if (adj.getFirst().equals(u)) {
        LinkedList<VertexAndWeights> adjList = new LinkedList<VertexAndWeights>(adj);
        adjList.remove(0);
        return adjList;
      }
    return null;
  }
}
