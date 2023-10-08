class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new Integer[n][amount+1];
        int res = s(coins, amount, 0);
        return res >= Integer.MAX_VALUE-1 ? -1 :res;
    }
    
    public int s(int[] c, int amount, int i){
        if(i>=c.length || amount < 0)
            return Integer.MAX_VALUE-1;
        
        if(dp[i][amount] != null)
            return dp[i][amount];
        if(amount == 0)
            return 0;
        
        return dp[i][amount] = Math.min(1+s(c, amount-c[i], i), s(c, amount, i+1));
        
    }
}


// => min(1+ s(coins, i, am-curr), s(coins, i+1, am)) 