class Solution {
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
     int sum = 0;
        
        for(int i=0;i<stones.length;i++)
            sum += stones[i];
        dp = new int[stones.length+1][(sum/2)+1];
        
        for(int i=0;i<=stones.length;i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        return sum - 2*((sum/2)-solve(stones, stones.length-1, sum/2));
    }
    public int solve(int[] s, int i, int sum){
        if(i<0)
            return sum;
        
        if(dp[i][sum] != Integer.MAX_VALUE)
            return dp[i][sum];
        
        int res = solve(s, i-1,sum);
        if(s[i] <= sum)
            res = Math.min(res, solve(s,i-1, sum-s[i]));
        
        return  dp[i][sum] = res;
    }
}