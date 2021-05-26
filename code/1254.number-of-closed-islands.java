class Solution {
    public int closedIsland(int[][] grid) {
        
        int n= grid.length;
        int m = grid[0].length;
        int c = 0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j] == 0 && solve(grid, i, j))
                  c++;  
            }
            
        }
        return c;
    }
    
    public boolean solve(int[][] g, int i, int j){
        if(i<0 || j < 0 || i >= g.length || j >= g[0].length)
            return false;
        
        if(g[i][j] == 1 || g[i][j] == 10)
            return true;
        if(g[i][j] == 0)
            g[i][j] = 10;
        
        boolean a =solve(g, i,j+1);
        boolean b = solve(g, i+1,j);
        boolean c = solve(g, i,j-1);
        boolean d = solve(g, i-1,j);
        return a && b && c && d;
    }
}