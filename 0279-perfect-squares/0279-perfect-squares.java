class Solution {
    Integer[][] dp;
    public int numSquares(int n) {
        List<Integer> sq = new ArrayList<>();
        
        for(int next=1;next*next<=n;next++)
            sq.add(next*next);
        dp = new Integer[101][n+1];   
        return s(0, sq, n);
    }
    
    public int s(int i, List<Integer> sq, int sum){
        if(sum == 0)
            return 0;
        if(sum < 0 || i >= sq.size())
            return Integer.MAX_VALUE-1;
        
        if(dp[i][sum] != null)
            return dp[i][sum];
        // System.out.println(i+" "+sq.get(i)+" "+sum);
        int w = 1+s(i, sq, sum-sq.get(i));
        int wout = s(i+1, sq, sum);
        
        return dp[i][sum] = Math.min(w, wout);
    }
}