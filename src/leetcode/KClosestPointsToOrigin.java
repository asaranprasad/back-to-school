// https://leetcode.com/problems/k-closest-points-to-origin/solution/

package leetcode;

import java.util.*

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> 
                                b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]);
        
        for(int[] p : points){
            pq.add(p);
            if(pq.size() > K)   pq.poll();
        }
        
        int k = pq.size();
        int[][] out = new int[k][2];
        
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            out[--k][0] = p[0];
            out[k][1] = p[1];
        }
        return out;
    }
}
