class Solution {
    int[][] dirs = new int[][]{{1,-1},{1,0},{1,1}};
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new Integer[71][71][71];
        
        return s(grid, 0,0, 0, m-1);
    }
    
    public int s(int[][] g, int r1x, int r1y, int r2x, int r2y){
        if(r1x >= g.length || r1y >= g[0].length || r2x >= g.length || r2y >= g[0].length || r1x < 0 || r1y < 0 || r2x < 0 || r2y < 0)
            return 0;
        if(dp[r1x][r1y][r2y] != null)
            return dp[r1x][r1y][r2y];
        int ans = g[r1x][r1y];
    
        ans += r1y == r2y ? 0 : g[r1x][r2y];
        int tmax = 0;
        for(int k=0;k<3;k++){
            int x = dirs[k][0]+r1x;
            int y = dirs[k][1]+r1y;

            for(int p=0;p<3;p++){
            int x1 = dirs[p][0]+r2x;
            int y1 = dirs[p][1]+r2y;
                
                tmax = Math.max(s(g, x, y, x1, y1), tmax);
            }
        }
        return dp[r1x][r1y][r2y] = ans+tmax;
        
        
    }
    public boolean safe(int x, int y, int[][] g){

            if(x <0 || y < 0 || x >=g.length || y >= g[0].length)
                return false;
        return true;
    }
    
    
}