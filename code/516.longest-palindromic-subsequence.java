class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuffer(s).reverse().toString();
        return lcs(s, rev);
    }
    
    public int lcs(String s, String rev){
        if(s.length() == 0)
            return 0;
        dp = new int[s.length()+1][rev.length()+1];
        
        for(int i =0;i<s.length();i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        
        
        return solve(s, rev, s.length()-1, rev.length()-1);
    }
    
    public int solve(String s, String rev, int i, int j){
        if(i <0 || j <0 )
            return 0;
        
        if(dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        
        int res = 0;
        if(s.charAt(i) == rev.charAt(j))
            res = 1+solve(s,rev,i-1,j-1);
        else
        res = Math.max(solve(s, rev, i, j-1), solve(s, rev, i-1, j));
        
        return dp[i][j] = res;
    }
}