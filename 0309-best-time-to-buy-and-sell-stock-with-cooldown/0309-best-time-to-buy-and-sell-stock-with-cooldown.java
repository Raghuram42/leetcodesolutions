class Solution {
    Integer[] dp;
    public int maxProfit(int[] prices) {
        int i = 0;
        int n = prices.length;
        dp = new Integer[n];
        return solve(prices, 0);
    }
    
    public int solve(int[] p, int i){
        if(i>=p.length)
            return 0;
        
        if(dp[i] != null)
            return dp[i];
        
        int ans = 0;
        int n = p.length;
        for(int j=i+1;j<n;j++){
            ans = Math.max(ans, Math.max(p[j]-p[i]+solve(p, j+2), solve(p, j)));
        }
        // System.out.println(i+" "+ans);
        return dp[i] = ans;
    }
}

