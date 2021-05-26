class Solution {
    int[][] dir  = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}}; 
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid.length == 0)
            return grid;
        if(r0 <0 || c0 <0 || r0 >= grid.length || c0 >= grid[0].length)
            return grid;
        int ocolor = grid[r0][c0];
        if(grid[r0][c0] != color)
            dfs(grid, r0, c0, color, grid[r0][c0]);
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] < 0)
                    grid[i][j] *=  -1;
            }
        }
        return grid;
    }
    
    
    public boolean dfs(int[][] grid, int i, int j, int ncolor, int ocolor){
     
        if(i<0 || j<0 || i >= grid.length || j >= grid[0].length)
            return true;
        
        if(grid[i][j] < 0)
            return false;
        
        
        if(grid[i][j] != ocolor)
            return true;
        
        
        boolean res = false;
        if(grid[i][j] == ocolor){
                
            grid[i][j] = -ocolor;
            
            for(int p=0;p<4;p++)
                res |= dfs(grid, i+dir[p][0], j+dir[p][1], ncolor, ocolor);
            
            // else
            if(res)
                grid[i][j] = -ncolor;
            
        }
        return false;
    }
}