class Solution {
    
    class Node{
        Node[] children;
        boolean isEnd;
        int ind;
        
        Node(){
            this.children = new Node[26];
            this.isEnd = false;
            ind = -1;
        }

    }
    class TrieNode{
        Node root;
        Node revRoot;
        TrieNode(){
            this.root = new Node();
            this.revRoot = new Node();
        }
        
        
        public void insert(String s, int ind){
            
            Node curr = root;
            Node revcurr = revRoot;
            for(int i=0;i<s.length();i++)
            {
                int ch = s.charAt(i)-'a';
                if(curr.children[ch] == null)
                    curr.children[ch] = new Node();
                
                curr = curr.children[ch];
                
                
                
                 ch = s.charAt(s.length()-i-1)-'a';
                if(revcurr.children[ch] == null)
                    revcurr.children[ch] = new Node();
                
                revcurr = revcurr.children[ch];
            }            
            curr.isEnd = true;
            curr.ind = ind;
            
            revcurr.isEnd = true;
            revcurr.ind = ind;
        }
        
        
        public List<Integer> matchedIndex(String target){
            // System.out.println(target);
            List<Integer> res = new ArrayList<>();
            
            Node curr = root;
            for(int i=target.length()-1;i>=0;i--){
                int ch = target.charAt(i)-'a';
                if(curr.isEnd && palindrome(target, 0, i))
                        res.add(curr.ind);
                if(curr.children[ch] == null){
                    return res;
                }else {
                    curr = curr.children[ch];
                }
            }
            
            if(curr.isEnd)
                res.add(curr.ind);
             
            return res;
        }
        
        
        
        
        public List<Integer> matchedIndex2(String target){
            // System.out.println(target);
            List<Integer> res = new ArrayList<>();
            
            Node curr = revRoot;
            for(int i=0;i<target.length();i++){
                int ch = target.charAt(i)-'a';
                if(curr.isEnd && palindrome(target, 0, i))
                        res.add(curr.ind);
                if(curr.children[ch] == null){
                    return res;
                }else {
                    curr = curr.children[ch];
                }
            }
            
            if(curr.isEnd)
                res.add(curr.ind);
             
            return res;
        }
        
    public boolean palindrome(String w, int i, int j){
        
        while(i<j){
            if(w.charAt(i) != w.charAt(j))
                return false;
            
            i++;
            j--;
        }
        
        return true;
    }
        
        
    }
    public List<List<Integer>> palindromePairs2(String[] words) {
        TrieNode tre =  new TrieNode();
        
        boolean[][] res= new boolean[words.length][words.length];
        
        for(int i=0;i<words.length;i++)
            if(words[i].length() > 0)
            tre.insert(words[i], i);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].length() > 0){
            List<Integer> r1 = tre.matchedIndex(words[i]);
            
            // System.out.println(r1+" "+words[i]);
            for(int j=0;j<r1.size();j++)
                if(r1.get(j) != i)
                // res.add(Arrays.asList(r1.get(j), i));
                res[r1.get(j)][i] = true;
                
             r1 = tre.matchedIndex2(words[i]);
            
            // System.out.println(r1+" "+words[i]);
            for(int j=0;j<r1.size();j++)
                if(r1.get(j) != i)
                // res.add(Arrays.asList(i, r1.get(j)));
                res[i][r1.get(j)] = true;
            }else{
                
                for(int p=0;p<words.length;p++){
                if(p != i && tre.palindrome(words[p], 0, words[p].length()-1)){
                // res.add(Arrays.asList(p, i));
                    // res.add(Arrays.asList(i, p));
                    res[i][p] = true;
                }
                }
            }
            
        }
        
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(res[i][j])
                    ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
    
    
    
    
    public List<List<Integer>> palindromePairs(String[] words) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<words.length;i++){
         map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        
        
        if(map.containsKey("")){
            
            for(int i=0;i<words.length;i++){
                if(i!=map.get("") && palindrome(words[i]))
                {
                        // res.add(Arrays.asList(map.get(""), i));       
                        res.add(Arrays.asList(i, map.get("")));
                }
            }
            
            
        }
        
        
        
        for(int i=0;i<words.length;i++){
            StringBuilder lft = new StringBuilder();
            for(int j=0;j<words[i].length();j++){
                lft.append(words[i].charAt(j));
                String rgt = words[i].substring(j+1);
                String strLft = lft.toString();
                if(map.containsKey(strLft) &&  map.get(strLft) != i && palindrome(rgt))
                    res.add(Arrays.asList( i, map.get(strLft)));
                
                
                if(map.containsKey(rgt) &&  map.get(rgt) != i && palindrome(strLft))
                    res.add(Arrays.asList( map.get(rgt), i));
                
            }
        }
        
        return res;
    }
    
    public boolean palindrome(String w){
        int i=0;
        int l = w.length()-1;
        
        while(i<l){
            if(w.charAt(i) != w.charAt(l))
                return false;
            
            i++;
            l--;
        }
        
        return true;
    }
}