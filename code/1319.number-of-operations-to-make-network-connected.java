class Solution {
    int[] parents;
    int[] sz;
    int ans;
    public int makeConnected(int n, int[][] connections) {
        parents = new int[n];
        sz = new int[n];
        
        if(n-1 > connections.length)
            return -1;
        
        for(int i=0;i<n;i++){
            parents[i] = i;
            sz[i] = 1;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        
        for(int[] connection: connections){
            if(!graph.containsKey(connection[0]))
                graph.put(connection[0], new ArrayList<Integer>());
            
            graph.get(connection[0]).add(connection[1]);
        }
        ans = n;
        
        for(int i=0;i<n;i++){
            if(!graph.containsKey(i))
                continue;
            
            for(int con: graph.get(i))
                union(i, con);
        }
        // for(int i=0;i<)
        return ans-1;
    }
    
    public void union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);
        
        if(p1 == p2) return;
        
        if(sz[p1] > sz[p2]){
            parents[p2] = p1;
            sz[p1]++;
        }else{
            parents[p1] = p2;
            sz[p2]++;
        }
        ans--;
    }
    
    public int find(int i){
        if(parents[i] != i)
            parents[i] = find(parents[i]);
        
        return parents[i];
    }
}