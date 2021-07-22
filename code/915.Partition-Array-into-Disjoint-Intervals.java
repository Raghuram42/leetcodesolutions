class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        int i = 0;
        int max = Integer.MIN_VALUE;
        while( i < n){
                dp[i] = Math.max(nums[i] , i == 0? nums[i] : dp[i-1]);
            i++;
        }
        
        int res = n;
        i = n-1;
        int min = nums[n-1];
         max = nums[n-1];
        
        while( i > 0){
            min = Math.min(min, nums[i]);
            if(dp[i-1] <= min )
                res = i;
            
                
            
            i--;
        }
        
        return res;
    }
}
/*
     [5,0,3,8,6]
min   5 0 0 0 0
max   5 5 5 8 8
      0 0 3 6 6
     
     [1,1,1,0,6,12]
      1 1 1 1 6 12
      0 0 0 0 6 12
     
     [1,1,1,6,12]
      1 1 1 6 12
      1 1 1 1 1
      1 1 1 6 12
      
      */
