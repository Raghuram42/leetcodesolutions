class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        
        for(int i=0;i<n;i++)
            dp[i+1] = dp[i]+(s.charAt(i)-'0'); 
        
        int ans = n;
        for(int i=0;i<=n;i++)
            ans = Math.min(ans, dp[i] + n-i-(dp[n]-dp[i]));
        
        return ans;
    }
}
