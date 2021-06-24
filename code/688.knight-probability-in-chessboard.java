class Solution {
    int tot;
    int[][] dir = new int[][]{{-2,-1}, {-2,1},{-1,-2},{2,-1},{1,-2},{-1,2},{2,1},{1,2}};
    double[][][] dp;
    public double knightProbability(int n, int k, int row, int column) {
        tot = 0;
        dp = new double[k+1][n+1][n+1];
       double r = solve(n, k, row, column);
        // System.out.println(r+" "+tot);
        return r;
    }
    
    public double solve(int n, int k, int r, int c){
      
        // tot+=1;
        if(r<0 || c<0 || r>=n || c>= n)
            return 0;
          if(k==0)
            return 1;
        
          if(dp[k][r][c] != 0d)
              return dp[k][r][c];
        
        
            // tot+=8;
        double res = 0;
        for(int d=0;d<8;d++){
            res += solve(n, k-1,r+dir[d][0], c+dir[d][1])/8;
        
        }
        
        return dp[k][r][c]=res;
        
    }
}