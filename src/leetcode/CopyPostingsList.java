package leetcode;

class PostingsList{
  int val;
  PostingsList jump;
  PostingsList next;
  PostingsList(int val){ this.val = val; }
}

public class CopyPostingsList {

  public static void main(String[] args) {
    PostingsList a = new PostingsList(1);
    PostingsList b = new PostingsList(2);
    PostingsList c = new PostingsList(3);
    PostingsList d = new PostingsList(4);
    a.next = b; b.next = c; c.next = d; d.next = null;
    a.jump = c; c.next = b; b.next = d; d.next = d;
    
    
  }

}
