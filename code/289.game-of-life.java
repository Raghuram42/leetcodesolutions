class Solution {
    int n;
    int m;
    public void gameOfLife(int[][] board) {
         n = board.length;
         m = board[0].length;
        int[][] res = new int[n][m];
        
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j] = solve(board, i, j);
            }
        }
        
        // board = res;
        
        for(int i=0;i<n;i++)
                board[i]= res[i];
        
    }
    
    public int solve(int[][] board, int i, int j){
        int res = 1;
        int live = getLiveCells(board, i,  j);
        if(board[i][j] == 1){
            if(live < 2 || live > 3)
                res = 0;
        }else {
            if(live == 3)
                res = 1;
            else
                res = 0;
        }
        // System.out.println(res);
        return res;
    }
    
    public int getLiveCells(int[][] board, int i, int j){
        
        int liveCells = 0;
        if(validIndexes(i-1, j-1))
            liveCells += board[i-1][j-1] == 1 ? 1: 0;
        
        
        if(validIndexes(i+1, j+1))
            liveCells += board[i+1][j+1] == 1 ? 1: 0;
        
        
        
        if(validIndexes(i-1, j))
            liveCells += board[i-1][j] == 1 ? 1: 0;
        
        if(validIndexes(i, j+1))
            liveCells += board[i][j+1] == 1 ? 1: 0;
        
        
        if(validIndexes(i+1, j))
            liveCells += board[i+1][j] == 1 ? 1: 0;
        
        
        if(validIndexes(i-1, j+1))
            liveCells += board[i-1][j+1] == 1 ? 1: 0;
        
        
        
        if(validIndexes(i+1, j-1))
            liveCells += board[i+1][j-1] == 1 ? 1: 0;
        
        
        
        if(validIndexes(i, j-1))
            liveCells += board[i][j-1] == 1 ? 1: 0;
        
        
        return liveCells;
    }
    
    public boolean validIndexes(int i, int j){
        return i >=0 && i< n && j >=0 && j< m;
    }
}