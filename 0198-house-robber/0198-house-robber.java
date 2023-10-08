class Solution {
    Integer[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp  = new Integer[n][2];
        
        return Math.max(s(nums, 0 , 0), s(nums, 0, 1));
    }
    
    public int s(int[] nums, int i, int use){
        if(i >= nums.length)
            return 0;
        
        if(dp[i][use] != null)
            return dp[i][use];
        int ans = 0;
        if(use == 1)
            ans = nums[i] + s(nums, i+1, 0);
        
        return dp[i][use] = Math.max(ans, s(nums, i+1, 1));
    }
}

// [1,2,3,1]