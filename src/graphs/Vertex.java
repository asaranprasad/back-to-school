package graphs;

import AdvancedADT.DNode;

public class Vertex {
  public int key;
  public Vertex p;
  public DNode d; // pointer to doubly link representation in heaps
  public int graphIndex; // index to Adjacency list in the graph
}
