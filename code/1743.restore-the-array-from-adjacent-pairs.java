class Solution {
    HashSet<Integer> vis;
    Deque<Integer> res;
    HashMap<Integer, List<Integer>> graph;
    public int[] restoreArray(int[][] adjacentPairs) {
        vis = new HashSet<Integer>();
        graph = new HashMap<Integer, List<Integer>>();
        res = new ArrayDeque<Integer>();
        int starttwo = -1;
        int startone = -1;
        for(int[] adj : adjacentPairs)
        {
            if(!graph.containsKey(adj[0]))
                graph.put(adj[0], new ArrayList<Integer>());
            
            if(!graph.containsKey(adj[1]))
                graph.put(adj[1], new ArrayList<Integer>());
            
            graph.get(adj[0]).add(adj[1]);
            graph.get(adj[1]).add(adj[0]);
            // if(starttwo == -1 && (graph.get(adj[0]) == 2))
        }
        
        Set<Integer> keys = graph.keySet();
        
        for(int k:keys){
            if(!vis.contains(k)){
            if(graph.get(k).size() == 2){
                vis.add(k);
                res.addFirst(k);
                dfs(graph.get(k).get(0), true);
                dfs(graph.get(k).get(1), false);
                // dfs(k, false);
            }else {
                dfs(k, true);
            }
            }
        }
        
        int[] r = new int[res.size()];
        
        int p = 0;
        
        while(!res.isEmpty())
            r[p++]= res.pop();
        
        return r;
        
        
    }
    public void dfs(int k, boolean side){
        if(vis.contains(k))
            return;
        
        vis.add(k);
        if(side)
        res.addLast(k);
        else
            res.addFirst(k);
        for(int p: graph.get(k)){
            dfs(p, side);
        }
        
    }
}