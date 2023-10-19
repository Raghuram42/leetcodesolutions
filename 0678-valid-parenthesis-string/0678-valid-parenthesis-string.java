class Solution {
    Boolean[][][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[101][101][101];
        return sol(s, 0, 0, 0);
    }
    
    public boolean sol(String s, int o, int c, int i){
        if(i>=s.length() && o == c)
            return true;
        
        if(i>=s.length() || c > o)
            return false;
        
        if(dp[o][c][i] != null)
            return dp[o][c][i];
        
        if(s.charAt(i) == '(')
            return dp[o][c][i] = sol(s, o+1, c, i+1);
        if(s.charAt(i) == '*')
            return dp[o][c][i] = sol(s, o+1, c, i+1) || sol(s, o, c+1, i+1) || sol(s, o, c, i+1);
        return dp[o][c][i] =  sol(s, o,c+1, i+1);
    }
}