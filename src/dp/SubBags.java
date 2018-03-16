package dp;

import java.util.HashSet;

public class SubBags {

  HashSet<Integer> primeNumbers;
  int lastPrimeNumber;

  public SubBags() {
    primeNumbers = new HashSet<Integer>();
    initPrimeNumbers();
  }

  private void initPrimeNumbers() {
    primeNumbers.add(2);
    primeNumbers.add(3);
    lastPrimeNumber = 3;
  }

  private int subBagsWithPrimeWeight(int[] input) {
    int n = input.length;
    int[][] C = new int[n + 1][n + 1];


    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        C[i][j] = Integer.MIN_VALUE;

        if (i == j) {
          int w = weight(input, i - 1, j - 1);
          if (isPrime(w))
            C[i][j] = 1;
        }

        for (int k = i + 1; k <= j; k++) {
          for (int m = k + 1; m <= j; m++) {
            int wik = weight(input, i - 1, k - 1);
            int wmj = weight(input, m - 1, j - 1);
            if (isPrime(wik + wmj)) {
              if (C[i][j] < C[i][k] + C[m][j] + 1)
                C[i][j] = C[i][k] + C[m][j] + 1;
            } else {
              if (C[i][j] < C[i][k] + C[m][j])
                C[i][j] = C[i][k] + C[m][j];
            }
          }
        }
      }
    }
    return C[n][n];
  }

  private boolean isPrime(int i) {
    populatePrimeNumbers(lastPrimeNumber + 1, i);
    return primeNumbers.contains(i);
  }

  private int weight(int[] input, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++)
      sum += input[i];
    return sum;
  }

  private void populatePrimeNumbers(int from, int to) {
    for (int i = from; i <= to; i++) {
      int sqrt = (int) Math.sqrt(i);
      boolean isComposite = false;
      for (int j = 2; j <= sqrt; j++) {
        if (i % j == 0) {
          isComposite = true;
          break;
        }
      }
      if (isComposite)
        continue;
      primeNumbers.add(i);
      lastPrimeNumber = i;
    }
  }

  public static void main(String[] args) {
    SubBags s = new SubBags();
    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));//4

    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {4, 6, 8, 10, 12, 14}));//0

    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {1, 2, 4, 8, 16, 32, 64, 128}));//54

    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {9947, 9948, 9949, 9950, 9951, 9952,
            9953, 9954, 9955, 9956, 9957, 9958, 9959,
            9960, 9961, 9962, 9963, 9964, 9965, 9966, 9967, 9968, 9969, 9970, 9971, 9972,
            9973,
            9974, 9975, 9976, 9977, 9978, 9979, 9980, 9981, 9982, 9983, 9984, 9985, 9986,
            9987,
            9988, 9989, 9990, 9991, 9992, 9993, 9994, 9995, 9996}));//91378169764810

    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {9947, 9947, 9947, 9947, 9947, 9947,
            9947, 9947, 9947, 9947, 9947, 9947, 9947,
            9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9934,
            9934,

            9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934,
            9934,
            9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934}));//54


    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {1, 1, 2, 2, 4, 4, 8, 8, 16, 16, 32,
            32, 64, 64, 128, 128, 256, 256, 512, 512, 1024,
            1024, 2048, 2048, 4096, 1, 1, 2, 2, 4, 4, 8, 8, 16, 16, 32, 32, 64, 64, 128,
            128, 256, 256,
            512, 512, 1024, 1024, 2048, 2048, 4096}));//62648678


    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {10000, 9999, 9998, 9997, 9996, 9995,
            9994, 9993, 9992, 9991, 9990, 9989,
            9988, 9987, 9986, 9985, 9984, 9983, 9982, 9981, 9980, 9979, 9978, 9977, 9976,
            9975,
            9974, 9973, 9972, 9971, 9970, 9969, 9968, 9967, 9966, 9965, 9964, 9963, 9962,
            9961,
            9960, 9959, 9958, 9957, 9956, 9955, 9954, 9953, 9952, 9951}));//89655114688016


    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {9990, 9991, 9992, 9993, 9994, 9995,
            9996, 9997, 9998, 9999, 9990, 9991, 9992,
            9993, 9994, 9995, 9996, 9997, 9998, 9999, 9990, 9991, 9992, 9993, 9994, 9995,
            9996,
            9997, 9998, 9999, 9990, 9991, 9992, 9993, 9994, 9995, 9996, 9997, 9998, 9999,
            9990,
            9991, 9992, 9993, 9994, 9995, 9996, 9997, 9998, 9999}));//4814999


    System.out
        .println(s.subBagsWithPrimeWeight(new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256,
            512, 1024, 10000, 10000, 10000, 10000, 10000,
            10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
            10000,
            10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
            10000,
            10000, 10000, 10000, 10000, 10000, 10000, 10000}));//6555
    System.out.println("end");
  }

}
