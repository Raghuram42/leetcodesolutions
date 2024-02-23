class Solution {
    HashMap<Integer, List<int[]>> g;
    Integer[][] dp;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        g = new HashMap<>();
        dp = new Integer[n+1][k+2];
        for(int[] f: flights){
            if(!g.containsKey(f[0]))
                g.put(f[0], new ArrayList<>());
            
            g.get(f[0]).add(new int[]{f[1], f[2]});
        }
        // System.out.println(g);
        int ans = s(n, src, dst, k+1); 
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public int s(int n, int sr, int ds, int k){
        if(k >= 0 && sr == ds)
            return 0;
        if(k == 0)
            return Integer.MAX_VALUE;
        
        if(dp[sr][k] != null)
            return dp[sr][k];
        // System.out.println(sr+" "+ds+" "+k);
        int ans = Integer.MAX_VALUE; 
        for(int[] next: g.getOrDefault(sr, new ArrayList<>())){
            int chep = s(n, next[0], ds, k-1);
            if(chep != Integer.MAX_VALUE)
                ans = Math.min(ans, next[1]+chep);
        }
        
        return dp[sr][k] = ans;
        
    }
}