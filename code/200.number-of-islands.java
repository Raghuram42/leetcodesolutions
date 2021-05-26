class Solution {
    char[][] gr;
    int[][] vis;
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || (grid.length == 1 && grid[0].length == 1 && grid[0][0] == '0'))
            return 0;
        if(grid.length == 1 && grid[0].length == 1 && grid[0][0] == '1')
            return 1;
        gr = grid;
        int c = 0;
        vis = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j] != 1 && grid[i][j] == '1'){
                buildgrph(i,j);
                c++;
                }
            }
        }
        return c;
    }
    public void buildgrph(int sr, int des){
        
        if(sr >= 0 && sr <=gr.length-1  && des >=0 && des <= gr[0].length-1 && vis[sr][des] != 1 && gr[sr][des] == '1'){
            vis[sr][des] = 1;
            buildgrph(sr, des-1);
            buildgrph(sr, des+1);
            buildgrph(sr+1, des);
            buildgrph(sr-1, des);
        }
        
        
    }
}