class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n+1];
        return solve(n);
    }
    
    public int solve(int n){
        if(n == 0)
            return 0;
        if(dp[n] != 0)
            return dp[n];
        int res = Integer.MAX_VALUE-1;
        for(int i=1;i*i<=n;i++)
            res = Math.min(res , 1+solve(n-i*i));
        
        
        return dp[n] = res;
        
        
    }
}