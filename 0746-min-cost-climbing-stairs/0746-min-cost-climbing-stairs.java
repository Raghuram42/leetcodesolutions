class Solution {
    Integer[] dp = new Integer[10001];
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(s(cost, 0), s(cost, 1));
    }
    
    public int s(int[] c, int i){
        if(i>=c.length)
            return 0;
        if(dp[i] != null)
            return dp[i];
        return dp[i] = c[i]+Math.min(s(c, i+1), s(c, i+2));
        
        
    }
}