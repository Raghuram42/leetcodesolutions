class Solution {
    boolean[] vis;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        vis = new boolean[n];
        
        for(int[] allowed: allowedSwaps){
            if(!graph.containsKey(allowed[0]))
                graph.put(allowed[0], new ArrayList<>());
            
            if(!graph.containsKey(allowed[1]))
                graph.put(allowed[1], new ArrayList<>());
            
            graph.get(allowed[0]).add(allowed[1]);
            graph.get(allowed[1]).add(allowed[0]);
        }
        // System.out.println(graph);
        int res = 0;
        for(int i=0;i<n;i++){
        
            if(!vis[i] && graph.containsKey(i)){
                HashSet<Integer> group = new HashSet<>();
                dfs(group, graph, i);
                
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                
                for(int g: group)
                    map.put(source[g], map.getOrDefault(source[g], 0)+1);
                
                for(int g: group){
                    if(!map.containsKey(target[g]))
                        res++;
                    else{
                        map.put(target[g], map.getOrDefault(target[g], 0)-1);
                        if(map.get(target[g]) == 0)
                            map.remove(target[g]);
                    }
                }
                
                
            }
            
        }
        
        for(int i=0;i<n;i++){
            if(!vis[i] && source[i] != target[i])
                res++;
                
        }
        return res;
        
    }
    
    public void dfs(HashSet<Integer> group,  HashMap<Integer, List<Integer>> graph, int i){
        if(!graph.containsKey(i) || vis[i])
            return;
        
        group.add(i);
        vis[i] = true;
        for(int next: graph.get(i))
            dfs(group, graph, next);
        
    }
}
