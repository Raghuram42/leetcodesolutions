class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[][] dp = new int[n+1][k+1];
        
        dp[0][0] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                
                dp[i][j] = (dp[i][j-1]+dp[i-1][j])%mod;
                
                if(j >= i)
                    dp[i][j] = (dp[i][j]-dp[i-1][j-i]+mod)%mod;
                
            }
        }
        
        
        return dp[n][k];
    }
}