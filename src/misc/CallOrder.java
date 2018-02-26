package misc;

class A {
  A() {
    System.out.println("A");
  }
}


class B extends A {
  B(int a) {
    System.out.println("B: " + a);
  }
}


public class CallOrder extends B {
  int a;

  CallOrder(int a) {
    super(a);
    System.out.println("C: " + a);
  }

  public static void main(String[] args) {
    CallOrder obj = new CallOrder(12);
  }
}
