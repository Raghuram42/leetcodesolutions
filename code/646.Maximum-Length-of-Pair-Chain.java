class Solution {
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        dp = new int[n][n];
        Arrays.sort(pairs, (a,b)->a[0]-b[0]);
        for(int i =0;i<n;i++)
            Arrays.fill(dp[i], -1);
        
        int max = 0;
        return solve(pairs, 0, 1)+1;
    }
    
    public int solve(int[][] pairs, int i, int j){
        if(i >= pairs.length || j>=pairs.length)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int res = pairs[i][1] < pairs[j][0] ? 1 : 0;
        
        return dp[i][j] = Math.max(res + solve(pairs, j, j+1), solve(pairs, i, j+1));
    }
}
