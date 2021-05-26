// class Solution {
//     int[][] vis;
//     public void solve(char[][] board) {
//         vis  = new int[board.length][board.length];
//         traverse(board, 1, 1);
//     }
//     public boolean traverse(char[][] board, int i, int j){
//         if(i>=0 && j>= 0 && i<board.length && j < board[0].length){
            
//             if(vis[i][j] == 2)
//                 return true;
            
//             if(vis[i][j] == -1)
//                 return false;
            
            
//             if(vis[i][j] == 1)
//                 return true;
//             if(board[i][j] == 'X'){
//                 vis[i][j] = 2;
//                 return true;
//             }
//             if(board[i][j] == 'O'){
//                 vis[i][j] = 1;
//                 if(traverse(board,i,j-1) && traverse(board,i-1,j) && traverse(board,i+1,j) && traverse(board,i,j+1) ){
//                   vis[i][j] = 2;
//                   board[i][j] ='X';
//                 }
//                 else{
//                     vis[i][j] = -1;
//                 }
                
//     // if(board[i][j] == )
//             }
//         }
//         if(i >= board.length && j >= board[0].length){
//             return board[i-1][j-1] == 2 ? true : false;
//         }
        
//         if(i >= board.length && j < board[0].length){
//             return board[i-1][j] == 2 ? true : false;
//         }
        
//         if(i < board.length && j >= board[0].length){
//             return board[i][j-1] == 2 ? true : false;
//         }
        
        
//         if(i < 0 && j <0){
//             return board[0][0] == 2 ? true : false;
//         }
        
//         if(i < 0 && j >= 0){
//             return board[0][j] == 2 ? true : false;
//         }
        
//         if(i >= 0 && j < 0){
//             return board[i][0] == 2 ? true : false;
//         }
//         return false;
//     }
// }


class Solution {
    public void solve(char[][] board) {
        
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        
        int r = board.length;
        int c = board[0].length;
        
        boolean[][] visited = new boolean[r][c];
        
        //first and last row
        for (int j=0; j<c; j++) {
            markBorderConnectedZeros(board, 0, j, r, c, visited);
            markBorderConnectedZeros(board, r-1, j, r, c, visited);
        }
        
        //first and last column
        for (int i=0; i<r; i++) {
            markBorderConnectedZeros(board, i, 0, r, c, visited);
            markBorderConnectedZeros(board, i, c-1, r, c, visited);
        }
        
        for (int i=1; i<r; i++) {
            for (int j=1; j<c; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
    
    private void markBorderConnectedZeros(char[][] board, int i, int j, 
                                          int r, int c, boolean[][] visited) {
        
        if (i<0 || i>= r) {
            return;
        }
        
        if (j<0 || j>= c) {
            return;
        }
        
        if (board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        markBorderConnectedZeros(board, i+1, j, r, c, visited);
        markBorderConnectedZeros(board, i-1, j, r, c, visited);
        markBorderConnectedZeros(board, i, j+1, r, c, visited);
        markBorderConnectedZeros(board, i, j-1, r, c, visited);
        
    }
    
    
}