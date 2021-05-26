class Solution {
    public int countSubstrings(String s) {
        int res  = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            dp[i][i] = true;
        for(int i=0;i<s.length();i++){
            for(int j=i;j>=0;j--){
                if(s.charAt(i) == s.charAt(j) &&  ((i-j < 2) || dp[i-1][j+1]))
                    dp[i][j] = true;
                
                if(dp[i][j])
                    res++;
                    
            }
        }
        
        return res;
    }
    
    public boolean isPalindrome(String s, int i, int j){
        
        int p = j/2;
        while(i<=p){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
        
    }
}