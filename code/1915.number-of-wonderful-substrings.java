class Solution {
    boolean[][] vis;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid1[i][j] == 1 && grid2[i][j] == 1)
                    grid2[i][j] = 2;
            }
        }
        
        int res = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j] == 1)
                    solve(grid1, grid2, i, j);
                
            }
        }
        
        
        
        
        for(int i=0;i<n;i++){
            // System.out.println(Arrays.toString(grid2[i]));
            for(int j=0;j<m;j++){
                if(grid2[i][j] == 2){
                    solve(grid1, grid2, i, j);
                    res++;
                }
                
            }
            // System.out.println("af+ "+Arrays.toString(grid2[i]));
        }
        return res;
    }
    
    
    public void solve(int[][] grid1, int[][] grid2, int i, int j){
        if(i>=grid1.length ||  i<0 || j<0 || j>=grid1[0].length || grid2[i][j] == 0)
            return ;
        
        
        // boolean res = true;
            grid2[i][j] = 0;
            for(int d=0;d<4;d++)
                solve(grid1, grid2, dir[d][0]+i, dir[d][1]+j);
            
        
        return;
    }
    
}