package dp;

import java.util.Scanner;


// Incomplete
public class JobAssignment {
  public static void main(String args[]) {
    JobAssignment j = new JobAssignment();
    //    j.assignment();
    System.out
        .println(j.assignmentDP(new int[][] {{19, 22, 22}, {79, 31, 2}, {77, 47, 8}}, 3));
    System.out
        .println(j.assignmentDP(new int[][] {{2, 1, 2}, {9, 8, 1}, {1, 1, 1}}, 3));
  }

  public void assignment() {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt(); // testcase
    for (int i = 0; i < t; i++) {
      int n = scan.nextInt(); // no. of persons and jobs
      int[][] a = new int[n][n];
      for (int m = 0; m < n; m++) {
        for (int k = 0; k < n; k++) {
          a[m][k] = scan.nextInt();
        }
      }
      System.out.println(assignmentDP(a, n));
    }
    scan.close();
  }


  private int assignmentDP(int[][] t, int n) {
    int[][] C = new int[n + 1][n + 1];

    //    for (int a = 1; a <= n; a++) {
    //      for (int b = 1; b <= n; b++) {
    //        C[a][b] = Integer.MAX_VALUE;
    //        for (int k = 1; k <= b; k++) {
    //          C[a][b] = Math.min(C[a][b], C[a - 1][k] + t[a - 1][k - 1]);
    //        }
    //      }
    //    }

    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        C[a][b] = Integer.MAX_VALUE;
        for (int k = 1; k <= b; k++) {
          //          int x = Math.min(C[a][b], C[a - 1][k] + t[a - 1][k - 1]);
          //          int y = Math.min(C[a][b], C[a - 1][k - 1] + t[a - 1][k - 1]);
          //          C[a][b] = Math.max(x, y);
          
          C[a][b] = Math.min(C[a][b], C[a - 1][k] + t[a - 1][k - 1]);
        }
      }
    }

    System.out.println();
    for (int m = 0; m < n; m++) {
      for (int k = 0; k < n; k++) {
        System.out.print(t[m][k] + "\t");
      }
      System.out.println();
    }
    System.out.println();
    for (int m = 1; m < n + 1; m++) {
      for (int k = 1; k < n + 1; k++) {
        System.out.print(C[m][k] + "\t");
      }
      System.out.println();
    }
    System.out.println();


    return C[n][n];
  }
}
