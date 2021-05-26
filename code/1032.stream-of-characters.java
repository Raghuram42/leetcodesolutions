class StreamChecker {
    Trie root;
    StringBuilder str;
    public StreamChecker(String[] words) {
        root = new Trie();
        str = new StringBuilder();
        for(int i=0;i<words.length;i++){
            root.insert(words[i]);
        }
    }
    
    public boolean query(char letter) {
        str.append(letter);
        TrieNode curr = root.root;
        for(int i=str.length()-1;i>=0 && curr != null;i--){
           // System.out.println(str.toString());
            curr = curr.child[str.charAt(i)-'a'];
            if(curr != null && curr.isEnd){
                return true;
            }
            
        }
        return false;
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode curr = root;
        
        for(int i=word.length()-1;i>=0;i--){
            if(curr.child[word.charAt(i)-'a'] == null)
                curr.child[word.charAt(i)-'a'] = new TrieNode();
            curr = curr.child[word.charAt(i)-'a'];
        }
        curr.isEnd = true;
    }
}

class TrieNode{
    TrieNode[] child;
    boolean isEnd;
    TrieNode(){
        child = new TrieNode[26];
        isEnd = false;
    }
}
/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */