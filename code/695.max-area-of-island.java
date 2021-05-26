class Solution {
    int  c;
    int[][] dir = new int[][]{{0,1}, {-1,0}, {1,0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        
        c = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1)
                    res = Math.max(dfs(grid, i, j), res);
            }
        }
        return res;
    }
    
    public int dfs(int[][] g, int i, int j){
        if(i<0 || j < 0 || i >= g.length || j >= g[0].length)
            return 0;
        
        if(g[i][j] == 0)
            return 0;
        
        g[i][j] = 0;
        
        int res = 1;
        for(int p=0;p<4;p++)
            res += dfs(g, i+dir[p][0], j+dir[p][1]);
            
        return res;
    }
    
}