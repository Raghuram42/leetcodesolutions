class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie(searchWord.length());
        List<List<String>> res = new ArrayList<>();
        for(String p: products)
            root.insert(p, searchWord);
        int i=0;
        for(i=0;i<searchWord.length();i++){
            res.add(root.search(searchWord, i));
            if(res.get(i).size() == 0){
                i++;
                break;
            }
        }
        for(;i<searchWord.length();i++)
            res.add(new ArrayList<>());
        // System.out.println(root.search(searchWord, 17));
        return res;
    }
    
    class Trie{
        Node root;
        Node[] searchIndex; 
        HashMap<String, List<String>> map;

            Trie(int len){
                this.root = new Node();
                searchIndex = new Node[len];
                map = new HashMap<>();
            }
        
        
        public void insert(String target, String searchWord){
            Node curr = root;
            
            boolean allmatch = true;
            for(int i=0;i<target.length();i++){
                int ind = target.charAt(i)-'a';
                // int searchChar = i < searchWord.length() ? searchWord.charAt(i)-'a' : -1;
                
                if(curr.children[ind] == null)
                    curr.children[ind] = new Node();
                curr = curr.children[ind];
                
                if(i < searchWord.length() && target.charAt(i) == searchWord.charAt(i) && allmatch)
                    searchIndex[i] = curr;
                else 
                    allmatch = false;
                    
            }
            curr.isEnd = true;
        }
        
        
        public List<String> search(String searchWord, int ind){
                 
            List<String> res = new ArrayList<>();
               // System.out.println(searchWord.substring(0, ind)+" bef "+ind+" "+res);
            if(this.searchIndex[ind] == null)
                return res;
            Node curr = this.searchIndex[ind];
            
           res = solve(curr, searchWord.substring(0, ind+1));
            // System.out.println(searchWord.substring(0, ind+1)+" "+ind+" "+res);
            return res;
        }
        
        public List<String> solve(Node curr, String val){
                List<String> res = new ArrayList<>();
                if(curr == null)
                    return res;
            if(map.containsKey(val))
                return map.get(val);
               if(curr.isEnd)
                    res.add(val);
                 for(int j=0;j<26;j++){
                  
                    if(curr.children[j] != null)
                    {
                        List<String> next = solve(curr.children[j], val+(char)(j+'a'));
                        // System.out.println(val +" "+next);
                      
                        for(int i=0;i<next.size() && res.size()<3;i++)
                            res.add(next.get(i));
                    }
                     if(res.size() == 3){
                         map.put(val, res);
                         return res;
                     }
                }
              map.put(val, res);
            return res;
        }
        
        
    }
    class Node{
        Node[] children;
        boolean isEnd;
        
        Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    
}