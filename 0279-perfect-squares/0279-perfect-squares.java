class Solution {
    Integer[] dp;
    public int numSquares(int n) {
        
        dp = new Integer[n+1];   
        return s(1, n);
    }
    
    public int s(int i,int sum){
        if(sum == 0)
            return 0;
        if(sum < 0 || i*i > sum)
            return Integer.MAX_VALUE-1;
        
        if(dp[sum] != null)
            return dp[sum];
        // System.out.println(i+" "+sq.get(i)+" "+sum);
        int w = 1+s(i,  sum-i*i);
        int wout = s(i+1, sum);
        
        return dp[sum] = Math.min(w, wout);
    }
}