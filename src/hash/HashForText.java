package hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// Node to hold keys
class KeyNode {
  public String key;
  public int count;
  public LinkedListPositionNodes pl;
  public KeyNode next;

  public KeyNode(String key, int count, int pos) {
    this.key = key;
    this.count = count;
    pl = new LinkedListPositionNodes();
    pl.push(pos);
    next = null;
  }

  public void incrementCount(int pos) {
    count++;
    pl.push(pos);
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


// LinkedList of position nodes
class LinkedListPositionNodes {
  public PositionNode head;

  public void push(int value) {
    PositionNode node = new PositionNode(value);
    node.next = head;
    head = node;
  }
}


//LinkedList of key nodes
class LinkedListKeyNodes {
  public KeyNode head;

  public void push(String data, int value, int pos) {
    KeyNode node = new KeyNode(data, value, pos);
    node.next = head;
    head = node;
  }

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


/* Hash Implementation */
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

  public void insert(String key, int value, int pos) {
    int hashKey = hash(key);
    LinkedListKeyNodes list = hashTable[hashKey];
    if (list == null) {
      list = new LinkedListKeyNodes();
      hashTable[hashKey] = list;
    }
    list.push(key, value, pos);
  }

  public void delete(String key) {
    LinkedListKeyNodes list = hashTable[hash(key)];
    if (list != null)
      list.deleteFirstOccuranceOfData(key);
  }

  public void increase(String key, int pos) {
    KeyNode n = find(key);
    if (n != null) {
      n.incrementCount(pos);
    } else {
      insert(key, 1, pos);
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
          System.out.print(k.key + " : " + k.count + " -- ");
          outputHandle.print(k.key + " : " + k.count + " -- ");
          outputHandle.flush();
          // print positions
          PositionNode phead = k.pl.head;
          while (phead != null) {
            System.out.print(phead.position + " ");
            outputHandle.print(phead.position + " ");
            outputHandle.flush();
            phead = phead.next;
          }
          System.out.println();
          outputHandle.println();
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
    // splits on all non-alphanumeric characters except '
    String[] words = corpus.trim().split("[^\\w']+");

    // push each word into the hashTable
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (word.length() < 1)
        continue;
      increase(word, i + 1); // i+1 denotes position of the word
    }
  }

  private void printMapDistributionToConsole() {
    System.out.println("\n\n Map Distribution:");
    int countNull = 0;
    int n = hashTable.length;
    for (int i = 0; i < n; i++) {
      LinkedListKeyNodes k = hashTable[i];
      if (k != null)
        System.out.println("[" + i + "]" + " Filled");
      else {
        countNull++;
        System.out.println("[" + i + "]" + " Null");
      }
    }
    System.out
        .println("Percentage of Hash filled: " + (100 * (n - countNull) / n) + "%");
  }


  public static void main(String[] args) {
    //    String fileName = "test";
    String fileName = "alice_in_wonderland_orig";
    String corpus = textFileToString("./input/" + fileName + ".txt");
    HashForText hft = new HashForText();
    hft.parseAndPushStrings(corpus);
    hft.listAllKeys("./output/" + fileName + "_output.txt");
    hft.printMapDistributionToConsole();
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
