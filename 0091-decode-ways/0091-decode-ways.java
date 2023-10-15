class Solution {
    Integer[] dp = new Integer[101];
    public int numDecodings(String s) {
        return solve(s, 0);
    }
    public int solve(String s, int i){
        
        int n = s.length();
        if(i>= n)
            return 1;
        
        if(dp[i] != null){
            return dp[i];
        }
        if(s.charAt(i) == '0')
            return 0;
        int ans1 = solve(s, i+1);
        int ans2 = i+1 < n && Integer.parseInt(s.substring(i, i+2)) >= 1 && Integer.parseInt(s.substring(i, i+2)) <= 26 ?  solve(s, i+2) : 0;
        // int ans2 =   >=  && solve()
        
        
        // System.out.println((i-1>=0 ? s.substring(i-1, i+1) : "NA")+" "+i+" "+s.charAt(i));
        
        return dp[i] = ans1+ans2;
    }
}