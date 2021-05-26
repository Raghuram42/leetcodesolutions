class Solution {
    int[][] gr;
    int n;
    int m;
    int dp[][];
    public int minPathSum(int[][] grid) {
        n = grid.length;
        if(n == 0)
            return 0;
        m = grid[0].length;
        if(n == 1 && m ==1)
            return grid[0][0];
        gr = grid;
        dp = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                dp[i][j] = -1;
        }
        //mapr = new int[n][m][Math.max(m,n)];
        return buildsm(0 ,0 ,0);
        
    }
    public int buildsm(int sr, int des, int res){
        if((des == m-1 && sr == n-1)){
           // System.out.println(res+gr[n-1][m-1]);
            return gr[n-1][m-1];
        }
        if(sr == n || des == m)
         return Integer.MAX_VALUE;
        
            if(dp[sr][des] != -1)
                return dp[sr][des];
        if(sr >=0 && sr < n && des >=0 && des < m){
            dp[sr][des] = Math.min(buildsm(sr+1, des, res), buildsm(sr, des+1, res)) + gr[sr][des];
            
        }
    return dp[sr][des];
    }
}