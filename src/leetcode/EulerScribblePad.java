package leetcode;

public class EulerScribblePad {

  int[] memo;

  private void s1() {
    int limit = 1000;
    int sum = 0;
    for (int i = 1; i < limit; i++)
      if (i % 3 == 0 || i % 5 == 0)
        sum += i;
    System.out.println(sum);
  }

  // Even Fibonacci
  private void s2() {
    int limit = 4000000;
    memo = new int[50];
    int sum = 0;
    for (int i = 2; fibo(i) < limit; i++)
      if (fibo(i) % 2 == 0)
        sum += fibo(i);
    System.out.println(sum);
  }

  private int fibo(int n) {
    if (memo[n] != 0)
      return memo[n];
    if (n <= 2)
      return n;
    else {
      memo[n] = fibo(n - 1) + fibo(n - 2);
      return memo[n];
    }

  }

  public static void main(String[] args) {
    EulerScribblePad e = new EulerScribblePad();
    // e.s1();
    e.s2();
  }
}
