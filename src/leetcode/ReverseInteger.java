package leetcode;

public class ReverseInteger {

  public static void main(String[] args) {
    ReverseInteger r = new ReverseInteger();
    SimpleTestFramework t = new SimpleTestFramework();
    t.checkTrue(r.reverse(1534236469) == 0, "Overflow");
    t.checkTrue(r.reverse(12345) == 54321, "Normal");
    t.checkTrue(r.reverse(0) == 0, "Zero");
    t.checkTrue(r.reverse(-12345) == -54321, "Negative Int");

    t.summarize();
  }

  public int reverse(int x) {
    // preserving the sign of x
    int sign = (x < 0) ? -1 : 1;
    x = (x < 0) ? (x * -1) : x;

    int y = 0;

    for (int yPrev = y; x != 0; x /= 10, yPrev = y) {
      y = y * 10 + (x % 10);

      // check if no over-flow occured
      if (y / 10 != yPrev)
        return 0;
    }

    // restore the sign
    y *= sign;
    return y;
  }
}
