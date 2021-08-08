class Solution {

    char[][] res;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;
        int m = board[0].length;
        res = new char[n][m];
        update(board, click[0], click[1]);
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                res[i][j] = res[i][j] == Character.MIN_VALUE ? board[i][j] : res[i][j];
        
        return res;
    }
    
    public void update(char[][] b, int i, int j){
   
        if(i<0 || j<0 || i>=b.length || j>=b[0].length || res[i][j] != Character.MIN_VALUE)
            return;
        // System.out.println(i+" "+j+" adj "+noAdjacentMines(b, i,j)+" "+vis[i][j]+" b "+b[i][j]+" "+(b[i][j] == 'E' ));

        if(b[i][j] == 'M')    
        {
            res[i][j] = 'X';
        }else if(b[i][j] == 'E'){
            
            
            int noOfAdjMines = getMines(b, i, j);
            if(noOfAdjMines > 0)
            res[i][j] = (char)(noOfAdjMines+'0');
            else{
                 res[i][j] = 'B';
            for(int d=0;d<8;d++)
                update(b, i+dir[d][0], j+dir[d][1]);
            }
        }
        
    }
    
    public boolean noAdjacentMines(char[][] b, int i, int j){
        
        for(int d=0;d<8;d++){
            int x = dir[d][0]+i;
            int y = dir[d][1]+j;
            
            if(x<0 || y<0 || x>=b.length || y >= b[0].length)
                continue;
            
            if(b[x][y] == 'M')
                return false;
        }
        
        return true;
    }
    
    
       public int getMines(char[][] b, int i, int j){
        int res = 0;
        for(int d=0;d<8;d++){
            int x = dir[d][0]+i;
            int y = dir[d][1]+j;
            
            if(x<0 || y<0 || x>=b.length || y >= b[0].length)
                continue;
            
            if(b[x][y] == 'M')
                res++;
        }
        
        return res;
    }
}
