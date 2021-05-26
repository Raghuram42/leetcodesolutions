class Solution {
    int res;
    public int uniquePathsIII(int[][] grid) {
        res = 0;
        int n = grid.length;
        int m = grid[0].length;
        int p = 0;
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                       if(grid[i][j] == -1){
                           p++;
                       }
            }
         }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    dfs(grid, (grid.length*grid[0].length)-p-1, i, j);
                    return res;
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] grid, int len, int i, int j){
        if(i>=0 && i < grid.length && j >= 0 && j < grid[0].length)
        {
            //if(grid[i][j] != -1)
       //     System.out.println(len+" "+i+" "+j+" "+ grid[i][j]);
            if(grid[i][j] == -1)
                return;
            if(grid[i][j] == 2){
                if(len == 0)
                    res++;
                return;
            }
            int c  = grid[i][j];
            grid[i][j] = -1;
            dfs(grid, len-1, i-1, j);
            dfs(grid, len-1, i+1, j);
            dfs(grid, len-1, i, j-1);
            dfs(grid, len-1, i, j+1);
            grid[i][j] = c;
        }
    }
}
