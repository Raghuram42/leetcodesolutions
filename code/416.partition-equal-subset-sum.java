class Solution {
    int dp[][];
    public boolean canPartition(int[] nums) {
        if(nums.length == 1)
            return false;
        int sum = 0;
        for(int num: nums)
            sum += num;
        dp = new int[nums.length+1][sum+1];
        return part(sum, nums, 0, 0);
    }
    
    public boolean part(int sum, int[] nums, int i, int s_sum){
      //  System.out.println(sum+" "+s_sum+" "+i);
        boolean res = false;
        if(i>= nums.length)
            return false;
        if(dp[i][s_sum] == 2)
            return true;
        
        if(dp[i][s_sum] == -1)
            return false;
        
        if(sum == s_sum)
            return true;
      
        res  = res || part(sum-nums[i], nums, i+1, s_sum+nums[i]);
        res = res || part(sum, nums, i+1, s_sum);
        dp[i][s_sum] = res == true ? 2 : -1;
        return res;
    }
}