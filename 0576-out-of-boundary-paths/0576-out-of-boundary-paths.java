class Solution {
    Long[][][] dp;
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Long[m+1][n+1][maxMove+1];
        return (int)(sol(m, n, maxMove, startRow, startColumn));
    }
    
    public long sol(int m, int n, int p, int i, int j){
        if(i< 0 || j < 0 || i >= m || j >= n)
            return 1;
        if(p == 0)
            return 0;
        if(dp[i][j][p] != null)
            return dp[i][j][p];
        long ans = 0;
        for(int k=0;k<4;k++){
            int x = dirs[k][0]+i;
            int y = dirs[k][1]+j;
            ans = mod(ans+sol(m,n,p-1, x, y));
        }
        return dp[i][j][p] = ans;
        
    }
    
    public long mod(long n){
        return n%1000000007;
    }
}