class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
     int[][] dp = new int[n][n];   
        
     for(int i=0;i<n;i++){
         dp[i][i] = 1;
         if(i >0 && s.charAt(i) == s.charAt(i-1))
             dp[i-1][i] = 1;
     }
     
         
        
      for(int i=2;i<n;i++){
          for(int j=0;j<i;j++){
              
              if(s.charAt(j) == s.charAt(i) && dp[j+1][i-1] == 1)
                  dp[j][i] = 1;
          }
      }
        
        
        for(int i=0;i<n;i++){
            if(dp[0][i] == 1){
            for(int j=0;j<n-1;j++){
                if(dp[i+1][j] == 1 && dp[j+1][n-1] == 1 )
                    return true;
            }
            }
        }
        return false;
    }
}
