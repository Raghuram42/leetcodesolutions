class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum+=num;
        
        if(sum%2 != 0)
            return false;
        int n = nums.length;
        dp = new Boolean[n][(sum/2)+1];
        return solve(nums, 0, sum/2);
    }
    
    
    public boolean solve(int[] nums, int i, int sum){
        if(sum < 0 || i>=nums.length)
            return false;
        if(sum == 0)
            return true;
        if(dp[i][sum] != null)
            return dp[i][sum];
        return dp[i][sum] = solve(nums, i+1, sum-nums[i]) || solve(nums, i+1, sum);
    }
}