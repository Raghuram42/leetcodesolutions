class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        // int n = word1.length();
        // int m
        dp = new Integer[501][501];
        
        return s(word1, word2, 0, 0);
    }
    
    public int s(String w1, String  w2, int i, int j){
        
        
        if(j<w2.length() &&  i >= w1.length())
            return w2.length()-j;
        
        if(i < w1.length() && j >= w2.length())
            return w1.length()-i;
        
        if(j>=w2.length())
            return 0;
        if(i>=w1.length())
            return w1.length()-i;
        
        if(dp[i][j] != null)
            return dp[i][j];
        if(w1.charAt(i) == w2.charAt(j))
            return dp[i][j] = s(w1, w2, i+1, j+1);
        
        return dp[i][j] = 1+Math.min(Math.min(s(w1, w2, i+1, j), s(w1,w2, i+1, j+1)), s(w1,w2, i, j+1));
    }
}