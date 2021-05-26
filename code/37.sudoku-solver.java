class Solution {
    int vis[][];
    public boolean isValidSudoku(char[][] board) {
        vis = new int[10][10];
        boolean row_column = solve1(board, 0,0, new int[10][10], new int[10][10], vis);
        boolean box = true;
        for(int i=0;i<board.length;i=i+3){
            for(int j=0;j<board[0].length;j=j+3){
                if(!(box && solve2(board,i,j)))
                    return false;
            }
        }
        return row_column && box;
    }
    
    
    public boolean solve1(char[][] b, int i, int j, int[][] checkr, int[][] checkc, int[][] vis){
        if(i>=0 && i<b.length && j>=0 && j<b[0].length && vis[i][j] != -1){
            if(b[i][j] != '.'){
                
                if(checkr[i][b[i][j]-'0'] >0 || checkc[j][b[i][j]-'0'] >0){
                   // System.out.println(i+" "+j+" "+b[i][j]+" "+checkc[j][b[i][j]-'0']+" "+checkr[i][b[i][j]-'0']);
                    return false;
                }
                checkr[i][b[i][j]-'0']++;
                checkc[j][b[i][j]-'0']++;
                }
            vis[i][j] = -1;
            
            boolean ans = true;
            ans = ans && solve1(b,i+1,j,checkr,checkc, vis);
            ans = ans && solve1(b,i-1,j,checkr,checkc, vis);
            ans = ans && solve1(b,i,j+1,checkr,checkc, vis);
            ans = ans && solve1(b,i,j-1,checkr,checkc, vis);
     //       b[i][j] = tmp;
            return ans;
        }
        
        return true;
    }
    
    public boolean solve2(char[][] b, int i,int j){
        int[] mapr = new int[10];
        for(int p =i;p<i+3;p++){
            for(int q=j;q<j+3;q++){
                if(b[p][q] != '.'){
                if(mapr[b[p][q]-'0']>0)
                    return false;
                mapr[b[p][q]-'0']++;
                }
            }
        }
        return true;
    }
}