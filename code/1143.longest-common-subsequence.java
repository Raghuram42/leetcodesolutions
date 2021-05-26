class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0)
            return 0;
        dp = new int[text1.length()][text2.length()];
         for(int[] each : dp)
            Arrays.fill(each, -1);
        return travsr(text1, text2, 0, 0);
    }
    
    public int travsr(String s1, String s2, int i, int j){
         if(i == s1.length() || j == s2.length())
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int res;
        
        if(s1.charAt(i) == s2.charAt(j))
            res = 1 + travsr(s1, s2, i+1, j+1);
        else{
            res = Math.max(travsr(s1, s2, i+1, j), travsr(s1, s2, i, j+1));
        }
       dp[i][j] = res;
        return dp[i][j];
    }
    
}