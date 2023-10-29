class Solution {
 public long minIncrementOperations(int[] nums, int k) {
    
        int n= nums.length;
        long[] dp = new long[n];
        
        int i = 0;
        while(i<n){
            dp[i] = Math.max(k-nums[i], 0);
            i++;
        }
        
        i = 3;
        // int p = 3;
        while(i < n){
            long c = Math.max(0, k-nums[i]);
            long t = Long.MAX_VALUE;
            if(i-1 >= 0)
                t = Math.min(t, dp[i-1]);
            if(i-2 >= 0)
                t = Math.min(t, dp[i-2]);
            if(i-3 >= 0)
                t = Math.min(t, dp[i-3]);
            
            dp[i] = t+c;
            i++;
        }
        // System.out.println(Arrays.toString(dp)+" "+dp[n-1]+" "+dp[n-2]+" "+dp[n-3]);
        return Math.min(dp[n-1], Math.min(dp[n-2], dp[n-3]));
    }     
}