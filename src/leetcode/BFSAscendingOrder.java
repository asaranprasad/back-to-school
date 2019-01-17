package leetcode;

import java.util.*;

public class BFSAscendingOrder {

  public static void main(String[] args) {
    BFSAscendingOrder b = new BFSAscendingOrder();
    List<Integer> out = b.bfsAsc(5, Arrays.asList(1,1,2,2), Arrays.asList(2,5,3,4), 1);
    System.out.println(Arrays.toString(out.toArray()));
  }
  
  private List<Integer> bfsAsc(int n, List<Integer> from, List<Integer> to, int host){
    
  }

}
