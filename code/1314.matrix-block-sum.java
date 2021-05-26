class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int dp[][] = new int[m+1][n+1];
        int ans[][] = new int[m][n];
        computePrefix(dp,mat,m,n);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K);
               int r2 = Math.min(m - 1, i + K), c2 = Math.min(n - 1, j + K);   
               ans[i][j] = rangeSum(dp,r1,c1,r2,c2);
            }
        }
        return ans;
    }
    
    void computePrefix(int[][]dp,int[][]mat,int m, int n){
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1];
    }
    
    int rangeSum(int[][]dp,int r1,int c1, int r2, int c2){
        r1++; c1++; r2++; c2++;
        return dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1];
    }
}