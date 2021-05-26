class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0)
            return 0;
      
        
        dp = new int[nums.length][3001];
        return solve(nums, 0, S, 0);
    }
    public int solve(int[] nums, int i, int s, int currs){
        if(i>= nums.length)
            return currs == s ? 1 : 0;
        
        int ind = currs;
        if(ind < 0){
            ind += 1100;
            if(dp[i][ind] != 0)
                return dp[i][ind];
        }
        return dp[i][ind] = solve(nums, i+1, s, currs+nums[i])+solve(nums, i+1, s, currs-nums[i]);
    }
}