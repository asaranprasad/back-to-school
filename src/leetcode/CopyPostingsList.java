package leetcode;

class PostingsList {
  char val;
  PostingsList jump;
  PostingsList next;

  PostingsList(char val) {
    this.val = val;
  }
}


public class CopyPostingsList {

  public static void main(String[] args) {
    PostingsList a = new PostingsList('a');
    PostingsList b = new PostingsList('b');
    PostingsList c = new PostingsList('c');
    PostingsList d = new PostingsList('d');
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = null;
    a.jump = c;
    c.next = b;
    b.next = d;
    d.next = d;

    CopyPostingsList cpl = new CopyPostingsList();
    PostingsList copy = cpl.copyPostingsList(a);
    cpl.printListAndPointers(a);
    cpl.printListAndPointers(copy);
  }

  private void printListAndPointers(PostingsList copy) {
    while (copy != null) {
      System.out.print(copy.val + " jump: " + copy.jump.val + " -> ");
    }
    System.out.println("null");
  }

  private PostingsList copyPostingsList(PostingsList head) {
    // create a fresh list with only next ptrs
        
    
    return null;
  }

}
