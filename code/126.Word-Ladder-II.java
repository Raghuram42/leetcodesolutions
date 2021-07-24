class Solution {
     HashMap<String, List<String>> graph;
     HashSet<String> vis;
    HashMap<String, List<List<String>>> map;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        graph = buildGraph(beginWord, endWord, wordList);//O(N*Len*26)
        map = new HashMap<String, List<List<String>>>();
        if(graph == null)
            return res;
        
        
       int seqsize = getSize(beginWord, endWord);//O(N)
        // System.out.println(graph+" "+seqsize);
        vis = new HashSet<>();
        if(seqsize == 0)
            return res;
        List<String> tres = new ArrayList<>();
        tres.add(beginWord);
        return dfs(beginWord, endWord, seqsize);//O(2^n)
        // return res;
    }
    
    public List<List<String>> dfs(String beginWord, String endWord, int sz){
        if(sz < 0)
            return null;
        List<List<String>> ans = new ArrayList<>();
        String key = beginWord+"$"+sz;
        
        if(beginWord.equals(endWord) && sz == 0){
            
            ans.add(new ArrayList<String>());
            ans.get(0).add(beginWord);
            return ans;
        }
        
        if(map.containsKey(key))
            return map.get(key);
        
        
        vis.add(beginWord);
        
        for(String next: graph.get(beginWord)){
            if(!vis.contains(next)){
                // tres.add(next);
                List<List<String>> nextAns = dfs(next, endWord, sz-1);
                
                if(nextAns != null){
                    for(List<String> newList : nextAns)
                    ans.add(new ArrayList<String>(newList));
                }
                
            }
            
        }
        
        if(ans.size() > 0){
            for(List<String> n: ans)
                n.add(0, beginWord);
        }
        vis.remove(beginWord);
        map.put(key, ans);
        return ans;
    }
    
    
    public int getSize(String beginWord, String endWord){
             
        Queue<String> q = new LinkedList<>();
        
        q.offer(beginWord);
        int path = 0;
        HashSet<String> vis = new HashSet<>();
        while(!q.isEmpty()){
            
            int sz = q.size();
            
            while( sz > 0){
                String curr = q.poll();
                if(curr.equals(endWord))
                    return path;
                vis.add(curr);
                for(String next : graph.get(curr))
                {
                    if(!vis.contains(next))
                        q.offer(next);
                }
                
                sz--;
            }
            
            path++;
        }
        
        
        return 0;
    }
    
    public HashMap<String, List<String>> buildGraph(String beginWord, String endWord, List<String> w){
        
        HashSet<String> set = new HashSet<String>(w);
        
        
        HashMap<String, List<String>> graph = new HashMap<>(); 
        if(!set.contains(endWord))
            return null;
        
        if(!set.contains(beginWord)){
            w.add(beginWord);
            set.add(beginWord);
        }
        
        int n = w.size();
        for(int i =0;i<n;i++){
            
            if(!graph.containsKey(w.get(i)))
                graph.put(w.get(i), new ArrayList<>());
                    
            char[] ary = w.get(i).toCharArray();
            
            for(int j=0;j<ary.length;j++){
                char c = ary[j];
            for(char k='a';k<='z';k++){
                if(c == k)
                    continue;
                
                ary[j] = k;
                if(set.contains(new String(ary)))
                        graph.get(w.get(i)).add(new String(ary));    
            }
                ary[j] = c;
            }
            
        }
        
        
        return graph;
    }
}
