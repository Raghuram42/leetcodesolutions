class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2)  
            return false;
        int sum = 0;
        if(sum != 0 && k!=0 &&  sum%k == 0)
            return true;
       int[] dp = new int[nums.length];   
       dp[0] = nums[0];
        for(int i=1;i<nums.length;i++)
            dp[i] = dp[i-1]+nums[i];
        
        if(dp[1] == k || (k != 0 && dp[1]%k == 0))
            return true;
        for(int i = 2;i<nums.length;i++){
            int j = 2;
            while(i-j >= 0){
            if(dp[i] == k || dp[i]-dp[i-j] == k|| (k != 0 && (dp[i]%k == 0 || (dp[i]-dp[i-j])%k == 0)))
                return true;
            j++;    
            }
        }
        return false;
    }
}