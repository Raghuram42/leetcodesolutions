class Solution {
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()];
        
        return solve(s1, s2, s3, 0, 0, 0);
    }
    
    
    public boolean solve(String s1, String s2, String s3, int i, int j, int k){
     if(i==s1.length() && k == s3.length() && j == s2.length())   
         return true;
      if(k >= s3.length())  
          return false;
        if(i>=s1.length())
            i = s1.length();
        
        if(j>=s2.length())
            j = s2.length();
        if(dp[i][j][k] != null)
            return dp[i][j][k];
        
     if(i<s1.length() && s1.charAt(i) == s3.charAt(k) && j<s2.length() && s2.charAt(j) == s3.charAt(k))
         return dp[i][j][k] = solve(s1,s2,s3,i+1, j, k+1) || solve(s1,s2,s3,i, j+1, k+1);
     else if(i<s1.length() && s1.charAt(i) == s3.charAt(k))
         return dp[i][j][k] = solve(s1,s2,s3,i+1, j, k+1);
    else if(j<s2.length() && s2.charAt(j) == s3.charAt(k))
         return dp[i][j][k] =solve(s1,s2,s3,i, j+1, k+1);
     
        return dp[i][j][k] = false;
    }
}
/*
 "aabcc"
i      5
 "dbbca"
j      5
 "aadbbcbcac"
k           10






        int i = 0;
        int j = 0;
        int k = 0;
        
        
        while((i<s1.length() || j<s2.length()) && k<s3.length()){
            
            if(i <s1.length() && s1.charAt(i) == s3.charAt(k) && j< s2.length() && s2.charAt(j) == s3.charAt(k)){
                int p = i;
                int q = j;
                int r = k;
                while(p<s1.length() && k<s3.length() && s1.charAt(p) == s3.charAt(r))
                {
                    p++;
                    r++;
                }
                r = k;
                while(q<s2.length() && k<s3.length() && s2.charAt(q) == s3.charAt(r))
                {
                    q++;
                    r++;
                }
                
                if(p >= q){
                    k = k+(p-i);
                    i = p;
                }else
                {
                    k = r;
                    j = q;
                }
                
            }
            if(i <s1.length() && s1.charAt(i) == s3.charAt(k)){
                i++;
                k++;
            }else if(j< s2.length() && s2.charAt(j) == s3.charAt(k)){
                j++;
                k++;
            }else 
                return false;
        // System.out.println(i+" "+j+" "+k);    
*/