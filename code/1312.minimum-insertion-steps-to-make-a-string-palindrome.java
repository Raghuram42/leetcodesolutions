class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        if(s.length() == 0)
            return 0;
       char[] strary = s.toCharArray();
        dp = new int[s.length()+1][s.length()+1];
        
        for(int i=0;i<=s.length();i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        
        
        return s.length()-lcs(strary, s.length()-1, 0);
    }
    
    public int lcs(char[] strary, int i, int j){
        if(i<0 || j >= strary.length)
            return 0;
        
        
        if(dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        int res = 0;
        if(strary[i] == strary[j])
            res = 1+lcs(strary, i-1,j+1);
        else
        res = Math.max(lcs(strary, i-1, j), lcs(strary, i, j+1 ));
        
        return dp[i][j] = res;
    }
}