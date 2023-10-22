class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        dp = new Integer[302][301];
        
        return s(nums, 0, nums.length-1);
    }
    
    public int s(int[] nums, int prev, int cur){
        
        if(prev > cur)
            return 0;
        if(dp[prev][cur] != null)
            return dp[prev][cur];
        int ans = 0;
        for(int mid =prev;mid<=cur;mid++){
            
            int tans = g(nums, prev-1)* g(nums, mid) * g(nums, cur+1);
            
            tans += s(nums, prev, mid-1)+s(nums, mid+1, cur);
            ans = Math.max(tans, ans);
        }
        
        return dp[prev][cur] = ans;
    }
    public int g(int[] nums, int t){
        if(t<0 || t >= nums.length)
            return 1;
        
        return nums[t];
    }
}