package misc;

public class RodCutting {

  public static void main(String[] args) {
    int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    RodCutting rc = new RodCutting();
    System.out.println(rc.bruteForceCut(prices, 7));
  }

  public int bruteForceCut(int[] prices, int length) {
    if (length == 0)
      return 0;
    int sum = 0;
    for (int i = 0; i < length; i++)
      sum = Math.max(sum, prices[i] + bruteForceCut(prices, length - (i + 1)));

    return sum;
  }

}
