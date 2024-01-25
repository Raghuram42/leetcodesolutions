class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[1001][1001];
        
        return sl(text1, text2, 0, 0);
    }
    
    public int sl(String s, String d, int i, int j){
        if(i >= s.length() || j >= d.length())
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        
        int with = 0;
        
        if(s.charAt(i) == d.charAt(j))
           return 1+sl(s, d, i+1, j+1);
        
        return dp[i][j] =  Math.max(sl(s, d, i+1, j), sl(s, d, i, j+1));
    }
}