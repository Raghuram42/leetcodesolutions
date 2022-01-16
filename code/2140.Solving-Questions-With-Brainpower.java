class Solution {
        long[] dp;
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new long[n];
        
        
        Arrays.fill(dp, -1);
        
        return solve(questions, 0);
        
    }
    public long solve(int[][] questions, int i){
        if(i>=questions.length)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        long ans = solve(questions, questions[i][1]+i+1)+questions[i][0];
        
        return dp[i] = Math.max(ans, solve(questions, i+1));
        
    }
}
