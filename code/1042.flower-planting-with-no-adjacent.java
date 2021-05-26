class Solution {
    HashMap<Integer, List<Integer>> graph;
    int vis[][];
    int[] color;
    public int[] gardenNoAdj(int n, int[][] paths) {
        graph = new HashMap<Integer, List<Integer>>();
        vis = new int[n+1][5];
        color = new int[n];
        for(int[] g: paths){
            if(!graph.containsKey(g[0]))
                graph.put(g[0], new ArrayList<Integer>());
            
            
            if(!graph.containsKey(g[1]))
                graph.put(g[1], new ArrayList<Integer>());
            
            graph.get(g[0]).add(g[1]);
            graph.get(g[1]).add(g[0]);
        }
        
        for(int i=1;i<=n;i++){
            if(vis[i][0] == 0)
                dfs(i, i);
        }
        return color;
        
    }
    
    public void dfs(int i, int par){
        
        if(vis[i][0] == 1)
            return;
        
        vis[i][0] = 1;
       
        int[] clr = new int[5];
        int c = 1;
        List<Integer> gp = new ArrayList<Integer>();
        if(graph.containsKey(i))
            gp = graph.get(i);
        for(int nxt: gp){
            if(i != nxt)
            dfs(nxt, i);
            clr[color[nxt-1]] = 1;
        }
        
        
        while(c < 5 && clr[c] != 0)
            c++;
        
        
        color[i-1] = c;
    }
}