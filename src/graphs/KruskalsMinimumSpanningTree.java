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
  public Node next;

  public Node(String name) {
    this.name = name;
    p = null;
    next = null;
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

  public KGraph(LinkedList<NodesAndWeights>[] Adj) {
    this.Adj = Adj;
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

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    // create vertices
    int vertex_count = 9;
    LinkedList<NodesAndWeights>[] Adj = new LinkedList[vertex_count];
    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");
    Node h = new Node("h");
    Node i = new Node("i");

    // create edges
    LinkedList<NodesAndWeights> aNeighbours = new LinkedList<NodesAndWeights>();
    aNeighbours.add(new NodesAndWeights(a, 0));
    aNeighbours.add(new NodesAndWeights(b, 4));
    aNeighbours.add(new NodesAndWeights(h, 8));

    LinkedList<NodesAndWeights> bNeighbours = new LinkedList<NodesAndWeights>();
    bNeighbours.add(new NodesAndWeights(b, 0));
    bNeighbours.add(new NodesAndWeights(h, 11));
    bNeighbours.add(new NodesAndWeights(c, 8));
    bNeighbours.add(new NodesAndWeights(a, 4));

    LinkedList<NodesAndWeights> cNeighbours = new LinkedList<NodesAndWeights>();
    cNeighbours.add(new NodesAndWeights(c, 0));
    cNeighbours.add(new NodesAndWeights(d, 7));
    cNeighbours.add(new NodesAndWeights(f, 4));
    cNeighbours.add(new NodesAndWeights(i, 2));
    cNeighbours.add(new NodesAndWeights(b, 8));

    LinkedList<NodesAndWeights> dNeighbours = new LinkedList<NodesAndWeights>();
    dNeighbours.add(new NodesAndWeights(d, 0));
    dNeighbours.add(new NodesAndWeights(c, 7));
    dNeighbours.add(new NodesAndWeights(e, 9));
    dNeighbours.add(new NodesAndWeights(f, 14));

    LinkedList<NodesAndWeights> eNeighbours = new LinkedList<NodesAndWeights>();
    eNeighbours.add(new NodesAndWeights(e, 0));
    eNeighbours.add(new NodesAndWeights(d, 9));
    eNeighbours.add(new NodesAndWeights(f, 10));

    LinkedList<NodesAndWeights> fNeighbours = new LinkedList<NodesAndWeights>();
    fNeighbours.add(new NodesAndWeights(f, 0));
    fNeighbours.add(new NodesAndWeights(e, 10));
    fNeighbours.add(new NodesAndWeights(d, 14));
    fNeighbours.add(new NodesAndWeights(c, 4));
    fNeighbours.add(new NodesAndWeights(g, 2));

    LinkedList<NodesAndWeights> gNeighbours = new LinkedList<NodesAndWeights>();
    gNeighbours.add(new NodesAndWeights(g, 0));
    gNeighbours.add(new NodesAndWeights(f, 2));
    gNeighbours.add(new NodesAndWeights(i, 6));
    gNeighbours.add(new NodesAndWeights(h, 1));

    LinkedList<NodesAndWeights> hNeighbours = new LinkedList<NodesAndWeights>();
    hNeighbours.add(new NodesAndWeights(h, 0));
    hNeighbours.add(new NodesAndWeights(g, 1));
    hNeighbours.add(new NodesAndWeights(i, 7));
    hNeighbours.add(new NodesAndWeights(b, 11));
    hNeighbours.add(new NodesAndWeights(a, 8));

    LinkedList<NodesAndWeights> iNeighbours = new LinkedList<NodesAndWeights>();
    iNeighbours.add(new NodesAndWeights(i, 0));
    iNeighbours.add(new NodesAndWeights(c, 2));
    iNeighbours.add(new NodesAndWeights(g, 6));
    iNeighbours.add(new NodesAndWeights(h, 7));

    // Populate the adjacency list
    Adj[0] = aNeighbours;
    Adj[1] = bNeighbours;
    Adj[2] = cNeighbours;
    Adj[3] = dNeighbours;
    Adj[4] = eNeighbours;
    Adj[5] = fNeighbours;
    Adj[6] = gNeighbours;
    Adj[7] = hNeighbours;
    Adj[8] = iNeighbours;

    // Init graph with this Adjacency List
    KGraph G = new KGraph(Adj);

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
