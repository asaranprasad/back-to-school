//https://leetcode.com/problems/trapping-rain-water/description/
// Two Pointer Solution

package leetcode;

public class TrappingRainWater {
  public int trap(int[] height) {
    int[] out = new int[height.length];
    int ch = -1;
    int chi = -1;


    for (int i = 0; i < height.length; i++) {
      int h = height[i];
      // wade through till first pillar
      if (h < 1 && ch == -1) {
        out[i] = 0;
        continue;
      }

      if (ch <= h) {
        chi = i;
        ch = h;
        out[i] = 0;
      } else {
        out[i] = ch - h;
      }
    }

    if (chi != height.length - 1 && ch >= 0) {
      fixUp(height, out, ch, chi);
    }

    int sum = 0;
    for (int v : out) {
      sum += v;
    }
    return sum;
  }

  private void fixUp(int[] height, int[] out, int ch, int chi) {
    int sh = -1;
    int shi = -1;

    // find second highest
    for (int i = chi + 1; i < height.length; i++) {
      if (height[i] > sh) {
        sh = height[i];
        shi = i;
      }
    }
    int diff = ch - sh;

    // fixup excess diff
    for (int i = chi + 1; i < height.length; i++) {
      out[i] = out[i] - diff;
    }

    if (shi != height.length - 1) {
      fixUp(height, out, sh, shi);
    }
  }

  public static void main(String[] args) {
    TrappingRainWater trw = new TrappingRainWater();
    System.out.println(trw.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }

}
