class Solution {
    class TrieNode {
         TrieNode[] child;
        Boolean isEnd;
        TrieNode(){
            child = new TrieNode[26];
            isEnd = false;
    }
    }
    Trie tr;
       Boolean[] hsm;
    class Trie{
        TrieNode root;
     
        Trie(){
           root = new TrieNode();
     
        }
        
        public void insert(String s){
        if(s.length() == 0)
            return;
        TrieNode curr = root;
        for(int i =0;i<s.length();i++){
            int ind = s.charAt(i)-'a';
          if(curr.child[ind] == null)
              curr.child[ind] = new TrieNode();
           curr = curr.child[ind];
        }
            curr.isEnd = true;
        }
        
        public boolean search(String s, int p){
        //    System.out.println(s);
 if(p == s.length())
            return true;
            if(hsm[p] != null)
                return hsm[p];
        TrieNode curr = root;
            boolean res = false;
        for(int i =p;i<s.length();i++){
            int ind = s.charAt(i)-'a';
          if(curr.child[ind] == null)
              return hsm[p] = res;
          curr = curr.child[ind];
            if(curr != null && curr.isEnd){
              res = res || search(s, i+1);  
                // if(res)
                //     return res;
            }
        }    
          return hsm[p] = res ;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0)
            return false;
              hsm = new Boolean[s.length()+1];
        tr = new Trie();
        for(int i=0;i<wordDict.size();i++)
            tr.insert(wordDict.get(i));
        
        return tr.search(s, 0);
    }
}