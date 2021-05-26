class WordDictionary {
    Trie triy;
    /** Initialize your data structure here. */
    public WordDictionary() {
        triy = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        triy.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        //triy.searchs(word);
        boolean res =false;
        if(word.length() > 0){
        try{
            res = triy.search(word, triy.root, 0);
        }
           catch(Exception e){
                System.out.println(e);
                    return false;
            }
        }
        return res;
    }
    // HashMap<Integer, int[]> hsm = new HashMap<Integer, int[]>();
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        
        public void insert(String s){
            TrieNode node = root;
               char c ='a';
            for(int i=0;i<s.length();i++){
             c = s.charAt(i);
                if(node.child[c-'a'] == null){
                    node.child[c-'a'] = new TrieNode();
                }
                node = node.child[c-'a'];
             //   System.out.println(c+" "+node.isEnd);
            }
            node.isEnd = true;
            //    System.out.println(c+" end "+node.isEnd);
        }
        
        public boolean search(String s, TrieNode rootn, int p){

            TrieNode node = rootn;
            char c = s.charAt(p);
       // System.out.println(p+" "+(s.length()-1));
         if(p == s.length()-1){
           //  System.out.println(c+" "+p+" "+ (s.length()-1)+" "+node.child[c-'a'].isEnd);
               if(c == '.'){
                  for(int i=0;i<26;i++){
                        if(node != null && node.child[i] != null && node.child[i].isEnd)
                             return true;
                  }
               }
             else if(node != null && node.child[c-'a'] != null && node.child[c-'a'].isEnd)
                   return true;
                 return false;
           }
               if(c == '.'){
                   for(int i=0;i<26;i++){
                       
                       if(node != null && search(s,  node.child[i], p+1))
                            return true;
                   }      
                }
            else{
                if(node != null && node.child[c-'a'] != null){
              //      System.out.println(c+" "+p+" "+ (s.length()-1)+" "+node.child[c-'a'].isEnd);
                    node = node.child[c-'a'];
                    return search(s, node, p+1);
                }
            }

            return false;
        }
        public boolean searchs(String word){
            TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char c = word.charAt(i);
           if (node.child[c-'a'] != null) {
                System.out.println(c+" "+node.isEnd);
               node = node.child[c-'a'];
           } 
       
        }
              System.out.println(" end "+node.isEnd);
        return node != null && node.isEnd;
        }
    }
    class TrieNode{
        TrieNode[] child;
        boolean isEnd;
        TrieNode(){
            child = new TrieNode[26];
         //   isEnd = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */