class Solution {
    
    Integer[][] dp;
    public int minFallingPathSum(int[][] grid) {
        dp = new Integer[201][201];
        int ans = Integer.MAX_VALUE;
        
        for(int i=0;i<grid.length;i++)
            ans = Math.min(ans, s(grid, 0, i));
        
        return ans;
    }
    
    public int s(int[][] m, int i, int j){
        if(i<0 || j<0 || i>=m.length || j>=m.length)
            return 0;
        
        if(dp[i][j] != null)
            return dp[i][j]; 
        
        int tmax = Integer.MAX_VALUE;
        int temp = -1;
        if(i+1 < m.length){
            temp = m[i+1][j];
            m[i+1][j] = Integer.MAX_VALUE; 
        }
        for(int k=0;k<m.length;k++){
            if(i+1< m.length && m[i+1][k] != Integer.MAX_VALUE)
                tmax = Math.min(tmax, s(m, i+1, k));
        }
        if(i+1 < m.length){
            // temp = m[i+1][j];
            m[i+1][j] = temp; 
        }
        return dp[i][j] = tmax == Integer.MAX_VALUE ? m[i][j] : tmax+m[i][j];
    }
}