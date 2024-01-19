class Solution {
    Integer[][] dp;
    
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        dp = new Integer[n][n];
        
        int minSum = Integer.MAX_VALUE;
        
        // Iterate through the first row of the grid
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, findMinPathSum(grid, 0, i));
        }
        
        return minSum;
    }
    
    private int findMinPathSum(int[][] m, int row, int col) {
        int n = m.length;
        
        // Base case: If the current position is out of bounds, return 0
        if (row < 0 || col < 0 || row >= n || col >= n) {
            return 0;
        }
        
        // If the result for this cell is already calculated, return it
        if (dp[row][col] != null) {
            return dp[row][col];
        }
        
        int tmax = Integer.MAX_VALUE;
        int temp = -1;
        
        if (row + 1 < n) {
            temp = m[row + 1][col];
            m[row + 1][col] = Integer.MAX_VALUE;
        }
        
        // Iterate through the cells in the next row and find the minimum path sum
        for (int k = 0; k < n; k++) {
            if (row + 1 < n && m[row + 1][k] != Integer.MAX_VALUE) {
                tmax = Math.min(tmax, findMinPathSum(m, row + 1, k));
            }
        }
        
        if (row + 1 < n) {
            // Restore the original value of the cell
            m[row + 1][col] = temp;
        }
        
        // Calculate the minimum path sum for the current cell
        dp[row][col] = (tmax == Integer.MAX_VALUE) ? m[row][col] : tmax + m[row][col];
        return dp[row][col];
    }
}
