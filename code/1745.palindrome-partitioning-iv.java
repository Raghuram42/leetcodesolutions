class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
     int[][] dp = new int[n][n];   
        
     for(int i=0;i<n;i++)
         dp[i][i] = 1;
     for(int i=1;i<n;i++)
         if(s.charAt(i) == s.charAt(i-1))
             dp[i-1][i] = 1;
        
      for(int i=2;i<n;i++){
          for(int j=0;j<n-i;j++){
              int p = j+i;
              if(s.charAt(j) == s.charAt(p) && dp[j+1][p-1] == 1)
                  dp[j][p] = 1;
          }
      }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(dp[0][i] == 1 && dp[i+1][j] == 1 && dp[j+1][n-1] == 1 )
                    return true;
            }
        }
        return false;
    }
}