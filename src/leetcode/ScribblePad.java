package leetcode;

public class ScribblePad {

  int maxInt = 2147483647;
  int eulerInt = 422481;

  public static void main(String[] args) {
    ScribblePad sp = new ScribblePad();
    sp.eulerSpoiler();
  }

  private void eulerSpoiler() {
    int a = 95800;
    int b = 217519;
    int c = 414560;
    int d = 422481;
    // for (int a = 1; a <= eulerInt; a++)
    // for (int b = 2; b <= eulerInt; b++)
    // for (int c = 3; c <= eulerInt; c++)
    // for (int d = 4; d <= eulerInt; d++)
    if (Math.pow(a, 4) + Math.pow(b, 4) + Math.pow(c, 4) == Math.pow(d, 4)) {
      System.out.println("a: " + a + "\nb: " + b + "\nc: " + c + "\nd: " + d);
      return;
    }
  }

}
