class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
    
    public int solve(int[] nums, int i){
        if(i >= nums.length-1)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        int res = Integer.MAX_VALUE-1;
        for(int stp=1;stp<=nums[i];stp++){
            res = Math.min(res, 1+solve(nums, i+stp));
        }
        return dp[i] = res;
    }
}