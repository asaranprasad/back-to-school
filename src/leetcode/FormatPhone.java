package leetcode;

public class FormatPhone {

  public static void main(String[] args) {
    System.out.println(new FormatPhone().format("00-44 48  555 8361"));
    System.out.println(new FormatPhone().format("00-44 48  5555 8361"));
    System.out.println(new FormatPhone().format("00-44 48  555"));
    System.out.println(new FormatPhone().format("00-44 48  55"));
    System.out.println(new FormatPhone().format("00"));
    System.out.println(new FormatPhone().format("00-4"));
    System.out.println(new FormatPhone().format("00-44"));
    System.out.println(new FormatPhone().format("111-111-111-111-111-111-1"));

  }
  
  private String format(String s) {
    s = s.replace("-", "").replaceAll(" ", "");
    StringBuilder out = new StringBuilder();
    
    int n = s.length();
    int rem = n % 3;    
    int lim = rem == 1 ? n - 4 : n - rem;
     
    int i = 0;
    while(i < lim) {
      int j = i + 3;
      out.append(s.substring(i, j));
      if(j < n) out.append("-");
      i = j;
    }
    
    if(rem == 1) out.append(s.substring(i,i+2) + "-" + s.substring(i+2));
    else out.append(s.substring(i));
       
    return out.toString();
  }

}
