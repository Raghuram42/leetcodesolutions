class Solution {
    Integer[][] dp;
    int[][] dirs = new int[][]{{1, -1}, {1, 0}, {1, 1}};
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new Integer[n][n];
        
        int minSum = Integer.MAX_VALUE; // Initialize minimum sum
        
        // Iterate through the first row of the matrix
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, findMinPathSum(matrix, 0, i));
        }
        
        return minSum;
    }
    
    // Helper function to find the minimum path sum recursively
    private int findMinPathSum(int[][] m, int row, int col) {
        int n = m.length;
        
        // Base case: If the current position is out of bounds, return a large value
        if (row < 0 || col < 0 || row >= n || col >= n) {
            return Integer.MAX_VALUE;
        }
        
        // If the result for this cell is already calculated, return it
        if (dp[row][col] != null) {
            return dp[row][col];
        }
        
        int minSum = Integer.MAX_VALUE;
        
        // Iterate through three possible directions: left, down, right
        for (int p = 0; p < 3; p++) {
            int newRow = row + dirs[p][0];
            int newCol = col + dirs[p][1];
            
            // Recursively find the minimum path sum in the next row
            int nextSum = findMinPathSum(m, newRow, newCol);
            
            // Update the minimum sum if the nextSum is smaller
            minSum = Math.min(minSum, nextSum);
        }
        
        // Calculate the minimum path sum for the current cell
        dp[row][col] = (minSum == Integer.MAX_VALUE) ? m[row][col] : m[row][col] + minSum;
        
        return dp[row][col];
    }
}
