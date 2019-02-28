package leetcode;

 // 1. Create a datastucture *Node* to remember the Key - Value Pair.
 // 2. Create a map of <Key, Node> to access and update the Node's value in O(1) time.
 // 3. Maintain a *Doubly Linked List* of nodes to depict the cache
 // 4. Use dummy head and tail and never remove them - makes the code super easy.
 // 5. Move the recently accessed element to the *head* of the queue, so that it won't get ejected as a LRU Node.
 // 6. Insert and then check for capacity to remove the node before *tail*

class LRUCache {
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;            
        }
    }
    
    private void addFirst(Node n){
        n.next = head.next;
        n.next.prev = n;
        n.prev = head;
        head.next = n;
        count++;
    }
    
    private void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        count--;
    }
    
    private Node removeLast(){
        Node n = tail.prev;
        remove(n);
        return n;
    }
    
    int cap;
    int count;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n != null){
            remove(n);
            addFirst(n);
            // printCache();
            return n.val;
        }
        // printCache();
        return -1;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n != null){
            n.val = value;            
            remove(n);
            addFirst(n);
        }
        else{
            n = new Node(key, value);
            addFirst(n);
            if(count > cap){ 
                int removedKey = removeLast().key;
                map.put(removedKey, null);
            }
        }
        map.put(key, n);
        // printCache();
    }
    
    private void printCache(){
        Node n = head.next;
        System.out.println();
        while(n != tail){
            System.out.print(n.key+":"+n.val+" -> ");
            n = n.next;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */