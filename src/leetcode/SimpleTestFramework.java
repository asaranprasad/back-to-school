package leetcode;

import java.util.List;
import java.util.stream.Collectors;

// This class helps to provide a simple test framework using checks like
// checkTrue, checkFalse, checkListEqual
public class SimpleTestFramework {

  //////////////////////////////////////////////////////////////////////////
  // TESTING FRAMEWORK
  //////////////////////////////////////////////////////////////////////////

  private int testsPassed = 0;
  private int testsFailed = 0;

  private final String FAILED = "    TEST FAILED: ";

  public void checkTrue(boolean result) {
    checkTrue(result, "anonymous");
  }

  public void checkTrue(boolean result, String name) {
    if (result)
      testsPassed = testsPassed + 1;
    else {
      testsFailed = testsFailed + 1;
      System.err.println(FAILED + name);
    }
  }

  public void checkFalse(boolean result) {
    checkFalse(result, "anonymous");
  }

  public void checkFalse(boolean result, String name) {
    checkTrue(!result, name);
  }

  <T> void checkListEqual(List<T> l1, List<T> l2,
      String message) {
    boolean ret = l1.containsAll(l2) && l2.containsAll(l1);
    if (!ret)
      message += "\nExpected: " + listToString(l2) + "\nActual  : "
          + listToString(l1);;
    checkTrue(ret, message);
  }

  <T> String listToString(List<T> l2) {
    return l2.stream()
        .map(p -> p.toString())
        .collect(Collectors.joining(","));
  }

  public void summarize() {
    System.err.println("Passed " + testsPassed + " tests");
    if (testsFailed > 0) {
      System.err.println("Failed " + testsFailed + " tests");
    }
  }
}

