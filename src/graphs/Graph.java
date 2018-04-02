package graphs;

import java.util.LinkedList;

class VertexAndWeights {
  public Vertex v;
  public int w;
}


public class Graph {
  LinkedList<VertexAndWeights>[] Adj;

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
