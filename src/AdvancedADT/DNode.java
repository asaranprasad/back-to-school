package AdvancedADT;

import graphs.Vertex;

public class DNode {
  public int key;
  public DNode left;
  public DNode right;
  public DNode child;
  public DNode parent;
  public Vertex v; // for graph problems
  public int degree;
  public boolean mark;

  public DNode(int key) {
    this.key = key;
    left = null;
    right = null;
    child = null;
    parent = null;
    degree = 0;
    mark = false;
    v = null;
  }

  public DNode(int key, Vertex u) {
    this.key = key;
    left = null;
    right = null;
    child = null;
    parent = null;
    degree = 0;
    mark = false;
    v = u;
  }
}
