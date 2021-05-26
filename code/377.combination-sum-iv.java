class Solution {
    int[] dp;
    int res;
    public int combinationSum4(int[] nums, int target) {
        res =0;
        
        
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] =1; 
        solve(nums, 0, target);
        
        return dp[target] == -1 ? 0: dp[target];
        
    }
    
    public int solve(int[] nums, int i, int tar){

 
        if(i>=nums.length || tar < 0)
            return 0;
        
             if(dp[tar] != -1){
            return dp[tar] ;
        }
        
        int res  = 0;
        for(int p =0;p<nums.length;p++)
            res += solve(nums, p, tar-nums[p]);
        return dp[tar] = res;
        
    }
}