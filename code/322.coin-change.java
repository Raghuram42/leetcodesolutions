class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0)
            return 0;
        // if(coins.length == 1 && coins[0] < amount)
        //     return -1;
        dp = new int[coins.length+1][amount+1] ;
        for(int i=0;i<=coins.length;i++)
        Arrays.fill(dp[i], Integer.MAX_VALUE);
        int res = solve(coins, 0, amount);
        return res == Integer.MAX_VALUE-1 ? -1 : res;
    }
    
    public int solve(int[] coins, int i, int amount){
        if(i >= coins.length || amount < 0)
            return Integer.MAX_VALUE-1;
        
        if(amount == 0){
         // System.out.println(i+" ins  "+amount);
            return 0;
        }else
          //  System.out.println(i+" "+amount);
        
        
        if(dp[i][amount] != Integer.MAX_VALUE)
            return dp[i][amount];
        
        
        dp[i][amount] = Math.min(1+solve(coins, i, amount-coins[i]), solve(coins, i+1, amount));
        return dp[i][amount];
    }
}