class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    boolean[][] vis;
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                    
                }
            }
        }
        
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j] == 0)
            return 0;
        
        int res = 0;
        
        
        if(j-1 < 0 || (j-1 >= 0 && grid[i][j-1] == 0))
            res++;
        
        if(i-1 < 0 || (i-1 >= 0 && grid[i-1][j] == 0))
            res++;
        
        if(j+1 >= grid[0].length || (j+1 < grid[0].length && grid[i][j+1] == 0))
            res++;
        
        if(i+1 >= grid.length || (i+1 < grid.length && grid[i+1][j] == 0))
            res++;
        // System.out.println(i+" "+j+" sides "+res);
        
        vis[i][j] = true;
        for(int d=0;d<4;d++)
            res += dfs(grid, i+dir[d][0], j+dir[d][1]);
        
        return res;
    }
}