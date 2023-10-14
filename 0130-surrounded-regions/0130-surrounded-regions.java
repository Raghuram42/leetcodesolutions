class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    boolean[][] vis;
    public void solve(char[][] board) {
        
        int i = 0;
        int j = 0;
        int n = board.length;
        int m = board[0].length;
        vis = new boolean[n][m];
        
        while(j<m){
            if(board[i][j] == 'O' && !vis[i][j])
                dfs(board, i, j);
            
            if(board[n-1][j] == 'O' && !vis[n-1][j])
                dfs(board, n-1, j);
       
            j++;
        }
        
        j = 0;
        i = 0;
        
        while(i<n){
            if(board[i][j] == 'O' && !vis[i][j])
                dfs(board, i, j);
            
            if(board[i][m-1] == 'O' && !vis[i][m-1])
                dfs(board, i, m-1);
            i++;
        }
        i = 0;   
           while(i<n){
            j = 0;
            
            while(j<m){
                if(!vis[i][j])
                    board[i][j] = 'X';
                
                
                j++;
            }
               i++;
        }
     
        
    }
    
    
    public void dfs(char[][] b, int i, int j){
        if(i<0 || j<0 || i >= b.length || j >= b[0].length || b[i][j] == 'X' || vis[i][j])
            return;
        
        vis[i][j] = true;
        
        for(int k=0;k<4;k++)
            dfs(b, i+dir[k][0], j+dir[k][1]);
        
    }
}