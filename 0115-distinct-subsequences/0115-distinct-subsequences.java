class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[1001][1001];
        return solve(s, t, 0 ,0);
    }
    
    public int solve(String s, String t, int i, int j){
        if(j>=t.length())
            return 1;
        
        if(i>=s.length())
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == t.charAt(j))
            ans += solve(s, t, i+1, j+1);
        
        return dp[i][j] = ans + solve(s, t, i+1, j);
    }
}