class Solution {
    int[] dp;
    public int subsetXORSum(int[] nums) {
        dp = new int[nums.length];
        
        // Arrays.fill(dp[]);
        return solve(nums, 0, 0);
    }
    
    public int solve(int[] nums, int i, int ans){
        if(i>=nums.length)
            return ans;
        
        // if(dp[i].containsKey(ans))
        //     return (Integer)dp[i].get(ans);
        
        return solve(nums, i+1, ans^nums[i])+solve(nums, i+1, ans);
         // return (Integer)dp[i].get(ans);
    }
}