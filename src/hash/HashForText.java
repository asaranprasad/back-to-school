package hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// Node to hold keys
class KeyNode {
  public String key;
  public int count;
  public PositionNode pn;
  public KeyNode next;

  public KeyNode(String key, int count) {
    this.key = key;
    this.count = count;
    pn = null;
    next = null;
  }

  public void incrementCount() {
    count++;
  }
}


// Node to hold position
class PositionNode {
  public int position;
  public PositionNode next;

  public PositionNode(int position) {
    this.position = position;
    next = null;
  }
}


class LinkedListKeyNodes {
  public KeyNode head;

  public void push(String data, int value) {
    KeyNode node = new KeyNode(data, value);
    node.next = head;
    head = node;
  }

  //  public void print() {
  //    LinkedListNode<KeyNode> curr = head;
  //    while (curr != null) {
  //      System.out.print(curr.n + " ");
  //      curr = curr.next;
  //    }
  //  }

  public void deleteFirstOccuranceOfData(String key) {
    KeyNode curr = head;
    KeyNode prev = curr;
    while (curr.next != null) {
      if (curr.key.equals(key))
        break;
      prev = curr;
      curr = curr.next;
    }
    delete(prev, curr);
  }

  private void delete(KeyNode prev, KeyNode node) {
    prev.next = node.next;
  }

  public KeyNode findKeyNode(String key) {
    KeyNode curr = head;
    while (curr != null) {
      if (curr.key.equals(key))
        break;
      curr = curr.next;
    }
    return curr;
  }
}



public class HashForText {

  // size of the hash table - a prime
  private static int M = 769;
  private LinkedListKeyNodes[] hashTable;


  public HashForText() {
    hashTable = new LinkedListKeyNodes[M];
  }

  private int hash(String s) {
    char ch[];
    ch = s.toCharArray();

    int i, sum;
    for (sum = 0, i = 0; i < s.length(); i++)
      sum += ch[i];
    return sum % M;
  }

  public void insert(String key, int value) {
    int hashKey = hash(key);
    LinkedListKeyNodes list = hashTable[hashKey];
    if (list == null) {
      list = new LinkedListKeyNodes();
      hashTable[hashKey] = list;
    }
    list.push(key, value);
  }

  public void delete(String key) {
    LinkedListKeyNodes list = hashTable[hash(key)];
    if (list != null)
      list.deleteFirstOccuranceOfData(key);
  }

  public void increase(String key) {
    KeyNode n = find(key);
    if (n != null) {
      n.count = n.count + 1;
    } else {
      insert(key, 1);
    }
  }

  public KeyNode find(String key) {
    LinkedListKeyNodes list = hashTable[hash(key)];
    if (list == null)
      return null;
    return list.findKeyNode(key);
  }

  public void listAllKeys(String filePath) {
    try {
      PrintWriter outputHandle = new PrintWriter(filePath);
      outputHandle.println("Key : Count");
      outputHandle.println("-----------");
      for (LinkedListKeyNodes entry : hashTable) {
        if (entry == null)
          continue;
        KeyNode k = entry.head;
        while (k != null) {
          System.out.println(k.key + " : " + k.count);
          outputHandle.println(k.key + " : " + k.count);
          outputHandle.flush();
          k = k.next;
        }
      }
      outputHandle.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void parseAndPushStrings(String corpus) {
    // splits word by any unicode character that is not a letter
    String[] words = corpus.trim().split("\\P{L}+");

    // push each word into the hashTable
    for (String word : words) {
      increase(word);
    }
  }

  public static void main(String[] args) {
    //    String fileName = "alice_in_wonderland";
    String fileName = "alice_in_wonderland_orig";
    String corpus = textFileToString("./input/" + fileName + ".txt");
    HashForText hft = new HashForText();
    hft.parseAndPushStrings(corpus);
    hft.listAllKeys("./output/" + fileName + "_output.txt");
  }

  public static String textFileToString(String filePath) {
    String lines = new String();
    try {
      Scanner sc = new Scanner(new File(filePath));
      while (sc.hasNextLine())
        lines = lines + " " + sc.nextLine();
      sc.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lines;
  }

}
