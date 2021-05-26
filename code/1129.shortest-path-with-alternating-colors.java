class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] vis = new int[n+n];
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        
        for(int[] ed: red_edges){
            if(!graph.containsKey(ed[0]))
                graph.put(ed[0], new ArrayList<Integer>());
            
            graph.get(ed[0]).add(ed[1]);
        }
        
        
        for(int[] ed: blue_edges){
            if(!graph.containsKey(-ed[0]))
                graph.put(-ed[0], new ArrayList<Integer>());
            
            graph.get(-ed[0]).add(-ed[1]);
        }
        vis[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer(0);
        int res[] = new int[n];
        int ans = 0;
        Arrays.fill(res, -1);
        while(!q.isEmpty()){
            
            int sz = q.size();
            
            while(sz>0){
                int curr = q.poll();
                if(res[Math.abs(curr)] == -1)
                    res[Math.abs(curr)] = ans;
                
                for(Integer p: graph.getOrDefault(-curr, new ArrayList<Integer>())){
                    
                    if(vis[n+p] != 1){
                        vis[n+p] = 1;
                        q.offer(p);
                    }
                }
                sz--;
            }
            ans++;
        }
        return res;
    }
}