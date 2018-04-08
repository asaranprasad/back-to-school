package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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


class NodesAndWeights {
  public Node v;
  public int w;

  public NodesAndWeights(Node v, int w) {
    this.v = v;
    this.w = w;
  }
}


class Edge {
  int w;
  Node from;
  Node to;

  public Edge(int w, Node from, Node to) {
    this.w = w;
    this.from = from;
    this.to = to;
  }
}


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
    n.p = head;
    if (head == null) {
      head.next = n;
      tail.next = n;
      n.p = head;
    } else {
      tail.next = n;
      n.next = null;
    }
  }

  public static void union(DisjointSet a, DisjointSet b) {
    Node t = b.head.next;
    while (t != null) {
      t.p = a.head;
      t = t.next;
    }
    b.tail.p = a.head;
    a.tail = b.tail;
  }

  public static Node findSet(Node n) {
    return n.p;
  }

}


class KGraph {
  LinkedList<NodesAndWeights>[] Adj;

  public Node[] v() {
    Node[] nodes = new Node[Adj.length];
    for (int i = 0; i < Adj.length; i++)
      nodes[i] = Adj[i].get(0).v;
    return nodes;
  }
}


public class KruskalsMinimumSpanningTree {

  /**
   * Returns resultant set of edges from the minimal spanning tree of the Given graph G post running
   * Kruskal's algorithm
   * 
   * @param G - Graph
   */
  public Set<Edge> mstKruskal(KGraph G) {
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
      public int compare(Edge a, Edge b) {
        return a.w - b.w;
      }
    });

    // Final set of edges in the minimum spanning tree
    Set<Edge> A = new HashSet<Edge>();

    for (Edge edge : edges) {
      if (DisjointSet.findSet(edge.from) != DisjointSet.findSet(edge.to)) {
        DisjointSet.union(new DisjointSet(edge.from), new DisjointSet(edge.to));
        A.add(edge);
      }
    }
    return A;
  }

  public static void main(String[] args) {
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

  }

}
