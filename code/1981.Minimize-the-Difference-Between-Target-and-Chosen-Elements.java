class Solution {
    int[][] dp;
    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        dp = new int[n][4901];
        
        for(int i=0;i<n;i++)
                Arrays.fill(dp[i], -1);
        
        return solve(mat, 0, target, 0);
    }
    
    public int solve(int[][] mat, int i, int target, int sum){
        
        
        if(i>=mat.length)
            return Math.abs(target-sum);
        if(dp[i][sum] != -1)
            return dp[i][sum];
        int res = Integer.MAX_VALUE;
        for(int k=0;k<mat[i].length;k++)
            res = Math.min(res, solve(mat, i+1,target, sum+mat[i][k]));
        
        return dp[i][sum]=res;
    }
}
/*
[[1,2,3],[4,5,6],[7,8,9]], target = 13
  12 11 10 9 8 7 6 5 4  
  */
