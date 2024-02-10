class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for(int i=1;i<n;i++){
            dp[i][i] = true;
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i) == s.charAt(j) && (i-j<2 || dp[i-1][j+1]))
                    dp[i][j] = true;
                
                if(dp[i][j])
                    res++;
            }
        }
        
        return res;
    }
}

// a b a a a a a b c
// 0 1 2 3 4 5 6 7 8

// [i][i] true
//[i][i+1] true

/*
i = 2
j = 0 ; j < i

if s[i] == s[j] && dp[i-1][j+1]
    dp[i][j] = true //2 0



*/