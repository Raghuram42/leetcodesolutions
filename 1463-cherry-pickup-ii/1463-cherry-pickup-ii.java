class Solution {
    int[][] dir = new int[][]{{1,-1}, {1,0},{1,1}};
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                Arrays.fill(dp[i][j], -1);
        return solve(grid, 0, 0, m-1);
    }
    public int solve(int[][] g, int i, int j1, int j2){
        if(i<0 || i>=g.length || j1<0 || j1 >= g[0].length || j2 < 0 || j2 >= g[0].length)
            return 0;
        if(dp[i][j1][j2] != -1) 
            return dp[i][j1][j2];
        int res = 0;
        res = Math.max(res, solve(g, i+1, j1-1, j2-1));
        res = Math.max(res, solve(g, i+1, j1-1, j2));
        res = Math.max(res, solve(g, i+1, j1-1, j2+1));
        
        
        res = Math.max(res, solve(g, i+1, j1, j2));
        res = Math.max(res, solve(g, i+1, j1, j2-1));
        res = Math.max(res, solve(g, i+1, j1, j2+1));
        
        res = Math.max(res, solve(g, i+1, j1+1, j2+1));
        res = Math.max(res, solve(g, i+1, j1+1, j2-1));
        res = Math.max(res, solve(g, i+1, j1+1, j2));
        
        return dp[i][j1][j2] = res+(j1 == j2 ? g[i][j1] : g[i][j1]+g[i][j2]);
        
    }
}