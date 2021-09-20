class Solution {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        int i = 0;
        for(int[] move: moves){
            grid[move[0]][move[1]] = i%2 == 0 ? 1: -1; 
                i++;
        }
        
        if(winner(1, grid))
            return "A";
        if(winner(-1, grid))
            return "B";
        
        return moves.length < 9 ? "Pending" : "Draw";
        
    }
    
    public boolean winner(int n, int[][] grid){
        
        for(int i=0;i<3;i++)
        if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] == n)
            return true;
        
        for(int i=0;i<3;i++)
        if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] == n)
            return true;
        
        if(grid[0][0] == grid[1][1] && grid[2][2] == grid[1][1] && grid[0][0] == n)
            return true;
        
        
        if(grid[0][2] == grid[1][1] && grid[2][0] == grid[1][1] && grid[0][2] == n)
            return true;
        
        return false;
        
        
    }
}
