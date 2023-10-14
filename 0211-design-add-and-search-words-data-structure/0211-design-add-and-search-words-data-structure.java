class WordDictionary {
    Trie tri;
    public WordDictionary() {
        tri = new Trie();
    }
    
    public void addWord(String word) {
        tri.insert(word);
    }
    
    public boolean search(String word) {
        return tri.search(word, tri.root, 0);
    }
    
    class Trie{
        class Node{
            Node[] children;
            boolean isEnd;
            
            Node(){
                this.children = new Node[26];
                this.isEnd = false;
            }
        }
        Node root;
        
        Trie(){
            this.root = new Node();
        }
        
        public void insert(String w){
            int i=0;
            int n= w.length();
            
            Node mover = root;
            while(i<n){
                int ind = w.charAt(i)-'a';
                Node curr = mover.children[ind];
                if(curr == null)
                    mover.children[ind] = new Node();
                
                mover = mover.children[ind];
                i++;
            }
            
            mover.isEnd = true;
        }
        
        public boolean search(String w, Node r, int i){
            if(r == null)
                return false;
            // System.out.println(w+" "+i);
            int n= w.length();
            
            Node mover = r;
            while(i<n){
                if(w.charAt(i) != '.'){
                int ind = w.charAt(i)-'a';
                Node curr = mover.children[ind];
                    if(curr == null)
                        return false;
                mover = mover.children[ind];
                }else{
                    for(int j=0;j<26;j++)
                        if(search(w, mover.children[j], i+1))
                            return true;
                    
                    return false;
                }
                i++;
        }
            
        return mover != null && mover.isEnd;
    }
}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */