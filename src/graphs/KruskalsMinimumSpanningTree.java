package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** Represents a vertex in a graph */
class Node {
  public Node p;
  String name;
  int graphIndex;
  public Node next;

  public Node(String name) {
    this.name = name;
    p = null;
    next = null;
    graphIndex = 0;
  }

  public Node(String name, int graphIndex) {
    this(name);
    this.graphIndex = graphIndex;
  }

}


/** Represents a vertex-weight in a graph's adjacency list */
class NodesAndWeights {
  public Node v;
  public int w;

  public NodesAndWeights(Node v, int w) {
    this.v = v;
    this.w = w;
  }
}


/** Represents an edge in a graph */
class Edge {
  int w;
  Node from;
  Node to;

  public Edge(int w, Node from, Node to) {
    this.w = w;
    this.from = from;
    this.to = to;
  }

  // Overriding equals so that edges are considered undirected
  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    final Edge other = (Edge) obj;
    if (other.from.name.equals(this.from.name) && other.to.name.equals(this.to.name))
      return true;
    if (other.from.name.equals(this.to.name) && other.to.name.equals(this.from.name))
      return true;
    return false;
  }

  // Overriding hashCode by contract for equals
  @Override
  public int hashCode() {
    return this.from.hashCode() + this.to.hashCode();
  }

}


/** Represents a DisjointSet datastructure, enabling to identify the set a node belongs to */
class DisjointSet {
  public Node head;
  public Node tail;

  public DisjointSet() {
    head = new Node("head");
    tail = new Node("tail");
    head.p = tail;
    tail.p = head;
    head.next = null;
    tail.next = null;
  }

  // Point to a disjointSet using the given head
  public DisjointSet(Node head) {
    this.head = head;
    this.tail = head.p;
  }

  public void add(Node n) {
    if (head.next == null) {
      head.next = n;
      tail.next = n;
    } else {
      tail.next.next = n;
      tail.next = n;
      n.next = null;
    }
    n.p = head;
  }

  public static void union(Node a, Node b) {
    Node aHead = a.p;
    Node bHead = b.p;
    Node t = bHead.next;
    while (t != null) {
      t.p = aHead;
      t = t.next;
    }
    Node aTail = aHead.p;
    Node bTail = bHead.p;
    aTail.next.next = bHead.next;
    aTail.next = bTail.next;
  }

  public static Node findSet(Node n) {
    return n.p;
  }

}


/** Represents a graph */
class KGraph {
  LinkedList<NodesAndWeights>[] Adj;
  int V; // num of vertices in the graph
  boolean isUndirected;

  // init graph just with number of vertices information
  @SuppressWarnings("unchecked")
  public KGraph(int V) {
    this.V = V;
    Adj = new LinkedList[V];
    // init Adjacency list
    for (int i = 0; i < V; i++) {
      Adj[i] = new LinkedList<NodesAndWeights>();
    }
    isUndirected = false;
  }

  public KGraph(int V, boolean isUndirected) {
    this(V);
    this.isUndirected = isUndirected;
  }

  public static void addEdge(KGraph G, Node source,
      Node destination, int weight) {
    // add to adjacency list
    G.Adj[source.graphIndex].add(new NodesAndWeights(destination, weight));

    // add again vice-versa if graph is undirected
    if (G.isUndirected)
      G.Adj[destination.graphIndex].add(new NodesAndWeights(source, weight));
  }

  public KGraph(LinkedList<NodesAndWeights>[] Adj, boolean isUndirected) {
    this.Adj = Adj;
    this.isUndirected = isUndirected;
  }

  public Node[] v() {
    Node[] nodes = new Node[Adj.length];
    for (int i = 0; i < Adj.length; i++)
      nodes[i] = Adj[i].get(0).v;
    return nodes;
  }
}


/** Main class */
public class KruskalsMinimumSpanningTree {

  /**
   * Returns resultant set of edges from the minimal spanning tree of the Given graph G post running
   * Kruskal's algorithm
   * 
   * @param G - Graph
   */
  public static List<Edge> mstKruskal(KGraph G) {
    for (Node v : G.v()) {
      (new DisjointSet()).add(v);
    }

    // Collect all edges in the graph
    List<Edge> edges = new ArrayList<Edge>();
    for (LinkedList<NodesAndWeights> list : G.Adj) {
      Node from = list.getFirst().v;
      for (int i = 1; i < list.size(); i++) {
        Node to = list.get(i).v;
        edges.add(new Edge(list.get(i).w, from, to));
      }
    }

    // sort the edges in non-decreasing order
    Collections.sort(edges, new Comparator<Edge>() {
      @Override
      public int compare(Edge a, Edge b) {
        return a.w - b.w;
      }
    });


    // Final set of edges in the minimum spanning tree
    List<Edge> A = new ArrayList<Edge>();

    for (Edge edge : edges) {
      if (DisjointSet.findSet(edge.from) != DisjointSet.findSet(edge.to)) {
        DisjointSet.union(edge.from, edge.to);
        A.add(edge);
      }
    }
    return A;
  }


  /** Main method */
  public static void main(String[] args) {
    // create vertices
    int vertex_count = 9;
    Node a = new Node("a", 0);
    Node b = new Node("b", 1);
    Node c = new Node("c", 2);
    Node d = new Node("d", 3);
    Node e = new Node("e", 4);
    Node f = new Node("f", 5);
    Node g = new Node("g", 6);
    Node h = new Node("h", 7);
    Node i = new Node("i", 8);

    KGraph G = new KGraph(vertex_count);

    KGraph.addEdge(G, a, a, 0);
    KGraph.addEdge(G, a, b, 4);
    KGraph.addEdge(G, a, h, 8);

    KGraph.addEdge(G, b, b, 0);
    KGraph.addEdge(G, b, c, 8);
    KGraph.addEdge(G, b, h, 11);

    KGraph.addEdge(G, c, c, 0);
    KGraph.addEdge(G, c, d, 7);
    KGraph.addEdge(G, c, f, 4);
    KGraph.addEdge(G, c, i, 2);

    KGraph.addEdge(G, d, d, 0);
    KGraph.addEdge(G, d, e, 9);
    KGraph.addEdge(G, d, f, 14);

    KGraph.addEdge(G, e, e, 0);
    KGraph.addEdge(G, e, f, 10);

    KGraph.addEdge(G, f, f, 0);
    KGraph.addEdge(G, f, g, 2);

    KGraph.addEdge(G, g, g, 0);
    KGraph.addEdge(G, g, h, 1);
    KGraph.addEdge(G, g, i, 6);

    KGraph.addEdge(G, h, h, 0);
    KGraph.addEdge(G, h, i, 7);

    KGraph.addEdge(G, i, i, 0);


    // perform minimal spanning tree generation
    List<Edge> MST = KruskalsMinimumSpanningTree.mstKruskal(G);

    // print edges
    Iterator<Edge> it = MST.iterator();
    while (it.hasNext()) {
      Edge ed = it.next();
      System.out.println(ed.from.name + " -> " + ed.to.name + " : " + ed.w);
    }
  }

}
