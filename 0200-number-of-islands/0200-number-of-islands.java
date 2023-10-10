class Solution {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i<n){
            j = 0;
            
            while(j<m){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j);
                }
                j++;
            }
            i++;
        }
        
        return ans;
    }
    
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || j <0 || i>= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        
        for(int k=0;k<4;k++){
            int x = dirs[k][0]+i;
            int y = dirs[k][1]+j;
            
            dfs(grid, x, y);
        }
        
}
}