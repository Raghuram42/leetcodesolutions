class Solution {
    int[][] di = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0) == board[i][j] && solve(board, word, i, j, 1))
                    return true;
            }
        }   
        return false;
    }
    
    public boolean solve(char[][] b, String w, int i, int j, int d){
        if(d >= w.length())
            return true;
        char c = b[i][j];
        b[i][j] = '.';
        for(int k=0;k<4;k++){
            int x = i+di[k][0];
            int y = j+di[k][1];
            if(x<0 || y<0 || x>=b.length || y >= b[0].length)
                continue;
            
            if(w.charAt(d) == b[x][y] && solve(b, w, x, y, d+1))
                return true;
        }
        b[i][j] = c; 
        return false;
    }
}