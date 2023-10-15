class Solution {
    Integer[][] dp; 
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        dp = new Integer[n][m];
        
        return s(text1, text2, 0 ,0);
    }
    
    public int s(String t1, String t2, int i, int j){
        if(i >= t1.length() || j>=t2.length())
            return 0;
        
        if(dp[i][j] != null)
            return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j))
            return 1+s(t1, t2, i+1, j+1);
        
        return dp[i][j] = Math.max(s(t1, t2, i, j+1), s(t1, t2, i+1, j));
        
    }
}