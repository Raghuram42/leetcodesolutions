class Solution {
    int[] dp;
    public int[] countBits(int n) {
        if(n == 0)
            return new int[1];
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        // dp[2] = 1;
        
        for(int i=2;i<=n;i++){
            int v = calculateNearestPowerOfTwo(i);
            
            dp[i] = (i&(i-1)) == 0 ?  1 :dp[v]+dp[i-v];
        }
        
        return dp;
    }
    
     public int calculateNearestPowerOfTwo(int x) {
        // Handle the case where x is 0 or 1
        if (x <= 1) {
            return 1;
        }
        
        // Calculate the nearest lesser power of two
        int exponent = (int) (Math.log(x) / Math.log(2));
        int nearestPowerOfTwo = (int) Math.pow(2, exponent);
        
        return nearestPowerOfTwo;
    }
}