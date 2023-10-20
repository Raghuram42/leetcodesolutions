class Solution {
    Boolean[][][] dp; 
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() == 0)
            return true;
        
        dp = new Boolean[101][101][202];
        return s(s1, s2,s3,  0, 0, 0);
    }
    
    public boolean s(String s1, String s2, String s3, int i, int j, int k){
        // System.out.println(l);
       if(k >= s3.length() && i >= s1.length() && j >= s2.length())
           return true;
        
        if((i >= s1.length() && j >= s2.length()) || k>=s3.length())
            return false;
        
        if(dp[i][j][k] != null)
            return dp[i][j][k];
        
        boolean res = false;
        if(i< s1.length() && s1.charAt(i) == s3.charAt(k))
            res = res || s(s1, s2, s3, i+1, j, k+1);
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k))
            res = res || s(s1, s2, s3, i, j+1, k+1);
        
        return dp[i][j][k] = res;
        
    }
}