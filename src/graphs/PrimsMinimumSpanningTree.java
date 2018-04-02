package graphs;

import java.util.LinkedList;
import AdvancedADT.DNode;
import AdvancedADT.FibonacciHeap;

/* 
 * Prim's algorithm to compute Minimum Spanning Tree MST
 * using Fibonacci Heaps to maintain the Min-Priority Queue
 */
public class PrimsMinimumSpanningTree {

  public void mstPrim(Graph G, Vertex r) {
    for (Vertex u : G.v()) {
      u.key = Integer.MAX_VALUE;
      u.p = null;
    }
    r.key = 0;
    FibonacciHeap Q = new FibonacciHeap();

    // fillFibonacciHeap
    for (Vertex u : G.v()) {
      DNode d = new DNode(u.key, u);
      u.d = d;
      Q.fibHeapInsert(d);
    }

    while (Q.size() != 0) {
      Vertex u = Q.fibHeapExtractMin().v;
      LinkedList<VertexAndWeights> adjList = G.Adj(u);
      for (VertexAndWeights vw : adjList) {
        Vertex v = vw.v;
        int w = vw.w;
        if (w < v.key) {
          v.p = u;
          v.key = w;
          Q.fibHeapDecreaseKey(v.d, w);
        }
      }
    }
  }

  public static void main(String[] args) {
    // init graph
    // select root
    //print tree level order
  }

}
