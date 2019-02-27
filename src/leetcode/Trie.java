/* 
 https://leetcode.com/problems/implement-trie-prefix-tree/submissions/
 */

package leetcode;


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {    
    class TrieNode{
        private TrieNode[] nexts;
        public boolean isEnd;
        
        public TrieNode(){
            isEnd = false;
            nexts = new TrieNode[26];
        }
        
        public boolean hasKey(char c){
            return nexts[c - 'a'] != null;
        }
        
        public TrieNode get(char c){
            return nexts[c - 'a'];
        }
        
        public void put(char c, TrieNode t){
            nexts[c - 'a'] = t;
        }        
    }

    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode n = root;
        for(char c : word.toCharArray()){
            if(!n.hasKey(c)){
                n.put(c, new TrieNode());
            }
            n = n.get(c);
        }
        n.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode n = root;
        for(char c : word.toCharArray()){
            if(!n.hasKey(c)){
                return false;
            }
            n = n.get(c);
        }
        if(!n.isEnd) return false;
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode n = root;
        for(char c : prefix.toCharArray()){
            if(!n.hasKey(c)){
                return false;
            }
            n = n.get(c);
        }
        return true;
    }
}
