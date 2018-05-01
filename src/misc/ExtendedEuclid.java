package misc;

public class ExtendedEuclid {

  public int[] extendedEuclid(int a, int b) {
    int r[] = new int[3];
    if (b == 0) {
      r[0] = a;
      r[1] = 1;
      r[2] = 0;
    } else {
      int r_prime[] = extendedEuclid(b, a % b);
      r[0] = r_prime[0];
      r[1] = r_prime[2];
      r[2] = r_prime[1] - (a / b) * r_prime[2];
      return r;
    }
    return r;
  }

  public static void main(String[] args) {
    ExtendedEuclid ec = new ExtendedEuclid();
    int a[] = ec.extendedEuclid(48, 32);
    System.out.println("d: " + a[0]);
    System.out.println("a: " + a[1]);
    System.out.println("b: " + a[2]);
  }
}
