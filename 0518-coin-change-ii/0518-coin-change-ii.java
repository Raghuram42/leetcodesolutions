class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new Integer[n][amount+1];
        
        return s(amount, coins, 0);
    }
    
    public int s(int a, int[] c, int i){
        
        if(a == 0)
            return 1;
        if(i>=c.length || a < 0)
            return 0;
        if(dp[i][a] != null)
            return dp[i][a];
        return dp[i][a] = s(a-c[i], c, i)+s(a, c, i+1);
        
    }
}