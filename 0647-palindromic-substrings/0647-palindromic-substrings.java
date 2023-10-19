class Solution {
    public int countSubstrings(String s) {
          int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        
        int i = 0;
        // int n = s.length();
        
        while(i<n){
            dp[i][i] = true;
            if(i-1 >=0 && s.charAt(i) == s.charAt(i-1))
                dp[i-1][i] = true;
            i++;
        }
        
        
        i = 2;
        
        while(i<n){
            int j = 0;
            while(j<i){
                if(s.charAt(i) == s.charAt(j) && dp[j+1][i-1])
                    dp[j][i] = true;
                j++;
            }
            i++;
        }
        
        int res = 0;
        
        for(i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j])
                    res++;
            }
        }
        
        return res;
    }
}