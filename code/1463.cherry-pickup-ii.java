class Solution {
    int[][][] dp ;
    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
            Arrays.fill(dp[i][j], -1);
        
        return solve(grid, 0, 0, grid[0].length-1);
    }
    
    public int solve(int[][] grid, int i, int j1, int j2){
        if(i>= grid.length || j1< 0 || j2 <0 || j1 >= grid[0].length || j2 >= grid[0].length)
            return 0;
        
        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int currCh = j1 == j2 ? grid[i][j1] : grid[i][j1]+grid[i][j2];
        
        // System.out.println(currCh);
        int res = 0;
        res = Math.max(res, solve(grid, i+1, j1-1, j2-1));
        res = Math.max(res, solve(grid, i+1, j1-1, j2));
        res = Math.max(res, solve(grid, i+1, j1-1, j2+1));
        
        
        res = Math.max(res, solve(grid, i+1, j1, j2));
        res = Math.max(res, solve(grid, i+1, j1, j2-1));
        res = Math.max(res, solve(grid, i+1, j1, j2+1));
        
        res = Math.max(res, solve(grid, i+1, j1+1, j2+1));
        res = Math.max(res, solve(grid, i+1, j1+1, j2-1));
        res = Math.max(res, solve(grid, i+1, j1+1, j2));
        
        
        return dp[i][j1][j2] = res+currCh;
    }
}