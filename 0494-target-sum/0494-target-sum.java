class Solution {
    Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int n  = nums.length;
        
        dp = new Integer[n][3000+target+1];
        
        return s(nums, 0, target);
    }
    
    public int s(int[] nm, int i, int t){
        if(i>=nm.length && t==0)
            return 1;
        if(i>=nm.length)
            return 0;
        
        if(dp[i][2000+t] != null)
            return dp[i][2000+t];
        
        return dp[i][t+2000] = s(nm, i+1, t+nm[i])+ s(nm, i+1, t-nm[i]);
    }
}