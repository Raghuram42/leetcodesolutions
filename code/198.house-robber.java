class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if(nums.length == 3)
            return Math.max(nums[0]+nums[2], nums[1]);
        
        
      int[] dp = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = nums[nums.length-2];
        dp[nums.length-3] = nums[nums.length-3]+dp[nums.length-1];
        
        for(int i=nums.length-4;i>=0;i--){
       //     System.out.println(i+" "+(i+3)+" "+(i+2));
         dp[i] = nums[i]+Math.max(dp[i+2], dp[i+3]);
        }
        
        return Math.max(dp[0], dp[1]);
    }
}