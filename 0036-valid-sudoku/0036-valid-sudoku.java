class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] r = new int[10][10];
        int[][] c = new int[10][10];
        int[][][] b = new int[10][10][10];
        
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')
                    continue;
                int v = board[i][j]-'0';
                if(r[i][v] != 0 || c[j][v] != 0 || b[i/3][j/3][v] != 0)
                    return false;
                
                r[i][v] = 1;
                c[j][v] = 1;
                b[i/3][j/3][v] = 1;
            }
        }
        
        return true;
        
    }
}