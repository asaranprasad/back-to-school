
// Incomplete

// https://leetcode.com/problems/the-skyline-problem/description/

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;



public class SkylineProblem {
  public static void main(String args[]) {
    int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    List<int[]> skyPoints = (new SkylineProblem()).getSkyline1(buildings);

    for (int[] eachSkyPoint : skyPoints)
      System.out.print("[" + eachSkyPoint[0] + "," + eachSkyPoint[1] + "], ");

    // Inp: {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
    // Exp: [2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]
    // Act: [2,10],[3,15],[5,12],[9,0],[15,10],[20,8],[24,0]

    System.out.println();
    int[][] buildings2 = {{2, 9, 10}, {3, 4, 15}, {5, 12, 12}};
    for (int[] eachSkyPoint : (new SkylineProblem()).getSkyline1(buildings2))
      System.out.print("[" + eachSkyPoint[0] + "," + eachSkyPoint[1] + "], ");

    // Inp: {{2,9,10},{3,4,15},{5,12,12}}
    // Exp: [2,10],[3,15],[4,10],[5,12],[12,0]
  }


  /*
   * Skyline Probem - my algorithm 2.
   * 
   */
  public List<int[]> getSkyline1(int[][] buildings) {

  }

  /*
   * Skyline Probem - my algorithm 1.
   * 
   */
  public List<int[]> getSkyline1(int[][] buildings) {

    List<int[]> skyPoints = new ArrayList<int[]>();

    if (buildings.length < 1)
      return skyPoints;

    // 1. sort input by left x
    Arrays.sort(buildings, new CustomArraySort());
    // Collections.sort(buildings,CustomArraySort);

    // 2. always print first lEdge
    skyPoints.add(new int[] {buildings[0][0], buildings[0][2]});

    // 3. keep track of max rEdge
    // 4. keep track of max rEdge's height
    int[] max_rEdge = new int[] {buildings[0][1], buildings[0][2]};

    // 5. compare set with previous height and max-rEdge
    for (int i = 1; i < buildings.length; i++) {
      int this_lx = buildings[i][0];
      int this_rx = buildings[i][1];
      int this_h = buildings[i][2];
      int[] this_lEdge = new int[] {buildings[i][0], buildings[i][2]};
      int[] this_rEdge = new int[] {buildings[i][1], buildings[i][2]};

      // 1. if this.lx < max.rEdge,
      if (this_lx < max_rEdge[0]) {
        // 1. if this.height > max-rEdge.height, print this lEdge
        if (this_h > max_rEdge[1])
          skyPoints.add(this_lEdge);
        // 2. else if this.rEdge < max.rEdge, do nothing.
        else if (this_rx < max_rEdge[0]) {
          // do nothing.

        }
        // 3. else
        else {
          // 1. print intersection of max-rEdge and this.height
          skyPoints.add(new int[] {max_rEdge[0], this_h});
          // 2. make this.rEdge as max-rEdge.
          max_rEdge = this_rEdge;
        }

      }
      // 2. else if this.ledge = max.rEdge,
      else if (this_lx == max_rEdge[0]) {
        // 1. print this.lEdge.
        skyPoints.add(this_lEdge);
        // 2. make this.rEdge as max-rEdge
        max_rEdge = this_rEdge;
      }
      // 3. else,
      else {
        // 1. print bottom-of-max.rEdge.
        skyPoints.add(new int[] {max_rEdge[0], 0});
        // 2. print this lEdge
        skyPoints.add(this_lEdge);
        // 3. make this.rEdge as max-rEdge.
        max_rEdge = this_rEdge;
      }
    }

    // 6. print bottom-of-max.rEdge.
    skyPoints.add(new int[] {max_rEdge[0], 0});

    // 7. sort the final list of edges
    Collections.sort(skyPoints, new CustomArraySort());

    return skyPoints;
  }

}


class CustomArraySort implements Comparator<int[]> {
  @Override
  public int compare(int[] o1, int[] o2) {
    return o1[0] - o2[0];
  }
}


class MyTest {
  @Test
  public void testSkyLine() {
    int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    List<int[]> skyPoints = (new SkylineProblem()).getSkyline1(buildings);

    int[][] expectedSkyPoints =
        {{2, 10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0}};

    Assert.assertArrayEquals(expectedSkyPoints, skyPoints.toArray());
  }
}
