class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0]==null || dungeon[0].length==0) return 0;
        
        int n = dungeon[0].length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 1;
        
        for(int row=dungeon.length-1; row>=0; row--) {
            for(int col=n-1; col>=0; col--) {
                int t = Math.min(dp[col], dp[col+1]);
                dp[col] = Math.max(1, t - dungeon[row][col]);
            }
        }
        
        return dp[0];
    }
}