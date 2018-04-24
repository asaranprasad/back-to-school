package graphs;

import java.util.ArrayList;

class EdgePR {
  int f, c;
  int u, v;

  public EdgePR(int f, int c, int u, int v) {
    this.f = f;
    this.c = c;
    this.u = u;
    this.v = v;
  }
}


class VertexPR {
  int h, e;

  public VertexPR(int h, int e) {
    this.h = h;
    this.e = e;
  }
}


class GraphPR {
  int V;
  ArrayList<VertexPR> vertex;
  ArrayList<EdgePR> edge;

  public GraphPR(int V) {
    this.V = V;
    vertex = new ArrayList<VertexPR>();
    edge = new ArrayList<EdgePR>();
    for (int i = 0; i < V; i++)
      vertex.add(new VertexPR(0, 0));
  }

  public void addEdgePR(int u, int v, int c) {
    edge.add(new EdgePR(0, c, u, v));
  }

  public void initFlow(int s) {
    vertex.get(s).h = vertex.size();
    for (int i = 0; i < edge.size(); i++) {
      if (edge.get(i).u == s) {
        edge.get(i).f = edge.get(i).c;
        vertex.get(edge.get(i).v).e += edge.get(i).f;
        edge.add(new EdgePR(-edge.get(i).f, 0, edge.get(i).v, s));
      }
    }
  }

  public int overfVertex(ArrayList<VertexPR> ver) {
    for (int i = 1; i < ver.size() - 1; i++)
      if (ver.get(i).e > 0)
        return i;
    return -1;
  }

  public void updateReverseEdgePRf(int i, int f) {
    int u = edge.get(i).v, v = edge.get(i).u;
    for (int j = 0; j < edge.size(); j++) {
      if (edge.get(j).v == v && edge.get(j).u == u) {
        edge.get(j).f -= f;
        return;
      }
    }
    EdgePR e = new EdgePR(0, f, u, v);
    edge.add(e);
  }

  public boolean push(int u) {
    for (int i = 0; i < edge.size(); i++) {
      if (edge.get(i).u == u) {
        if (edge.get(i).f == edge.get(i).c)
          continue;
        if (vertex.get(u).h > vertex.get(edge.get(i).v).h) {
          int f = Math.min(edge.get(i).c - edge.get(i).f,
              vertex.get(u).e);
          vertex.get(u).e -= f;
          vertex.get(edge.get(i).v).e += f;
          edge.get(i).f += f;
          updateReverseEdgePRf(i, f);
          return true;
        }
      }
    }
    return false;
  }

  public void relabel(int u) {
    int mh = Integer.MAX_VALUE;
    for (int i = 0; i < edge.size(); i++) {
      if (edge.get(i).u == u) {
        if (edge.get(i).f == edge.get(i).c)
          continue;
        if (vertex.get(edge.get(i).v).h < mh) {
          mh = vertex.get(edge.get(i).v).h;
          vertex.get(u).h = mh + 1;
        }
      }
    }
  }

  public int getMaxflow(int s, int t) {
    initFlow(s);
    while (overfVertex(vertex) != -1) {
      int u = overfVertex(vertex);
      if (!push(u))
        relabel(u);
    }
    return vertex.get(vertex.size() - 1).e;
  }
}


public class PushRelabelAlgorithm {
  public static void main(String args[]) {
    GraphPR graph = new GraphPR(6);

    // Example from book
    graph.addEdgePR(0, 1, 16);
    graph.addEdgePR(0, 2, 13);
    graph.addEdgePR(1, 2, 10);
    graph.addEdgePR(2, 1, 4);
    graph.addEdgePR(1, 3, 12);
    graph.addEdgePR(2, 4, 14);
    graph.addEdgePR(3, 2, 9);
    graph.addEdgePR(3, 5, 20);
    graph.addEdgePR(4, 3, 7);
    graph.addEdgePR(4, 5, 4);

    System.out.println(graph.getMaxflow(0, 5));
  }
}
