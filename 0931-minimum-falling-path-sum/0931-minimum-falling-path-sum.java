class Solution {
    Integer[][]  dp;
    int[][] dirs = new int[][]{{1, -1}, {1,0},{1,1}};
    public int minFallingPathSum(int[][] matrix) {
        dp = new Integer[101][101];
        
        int i = 0;
        int n = matrix.length;
        int ans = Integer.MAX_VALUE-1;
        
        for( i=0;i<n;i++){
            ans = Math.min(ans, s(matrix, 0, i));
            // System.out.println(ans);
        }
        
        return ans; 
    }
    
    public int s(int[][] m, int i, int j){
        if(i<0 || j<0 || j >= m.length || i >= m.length)
            return Integer.MAX_VALUE;
        int tmax = Integer.MAX_VALUE;
        if(dp[i][j] != null)
            return dp[i][j];
        for(int p=0;p<3;p++)
        {
            int x = i+dirs[p][0];
            int y = j+dirs[p][1];
            
            if(x<0 || y <0 || x>=m.length || y >= m.length)
                continue;
            
            tmax = Math.min(tmax, s(m, x,y));
        }
        
        return dp[i][j] = tmax == Integer.MAX_VALUE ? m[i][j] : m[i][j]+tmax;
    }
}