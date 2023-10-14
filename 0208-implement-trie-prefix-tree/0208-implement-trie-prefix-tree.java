class Trie {
    class Node{
        Node[] children;
        boolean isEnd;
        
        Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        int i = 0;
        int n = word.length();
        Node mover = root;
        while(i<n){
            int ind = word.charAt(i)-'a';
            Node curr = mover.children[ind];
            if(curr == null)
                mover.children[ind] = new Node();
            mover = mover.children[ind];
            i++;
        }
        
        mover.isEnd = true;
    }
    
    public boolean search(String word) {
        int i = 0;
        int n = word.length();
        Node mover = root;
        
        while(i<n){
            int ind = word.charAt(i)-'a';
            Node curr = mover.children[ind];
            if(curr == null)
                return false;
            mover = mover.children[ind];
            i++;
        }
        
        return mover != null && mover.isEnd; 
        
    }
    
    public boolean startsWith(String prefix) {
         int i = 0;
        int n = prefix.length();
        Node mover = root;
        
        while(i<n){
            int ind = prefix.charAt(i)-'a';
            Node curr = mover.children[ind];
            if(curr == null)
                return false;
            mover = mover.children[ind];
            i++;
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */