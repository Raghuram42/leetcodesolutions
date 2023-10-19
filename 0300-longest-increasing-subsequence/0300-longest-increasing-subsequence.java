class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
         int n = nums.length;
         dp = new Integer[n+1][n+1];
        
         return solve(nums, -1, 0)+1;
    }
    
    public int solve(int[] nums, int i, int j){
        
        if(j >= nums.length)
            return 0;
        if(dp[i+1][j] != null)
            return dp[i+1][j];
        int sol = 0;
        if(i == -1)
            return dp[i+1][j] = Math.max(solve(nums, j, j+1), solve(nums, i,j+1));
        else if(nums[i] < nums[j]){
            sol = 1+ solve(nums, j, j+1);
        }
        return dp[i+1][j] = Math.max(sol, solve(nums, i, j+1));
    }
}