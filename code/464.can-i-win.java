class Solution {
    Boolean[] dp;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        int m = desiredTotal, n = maxChoosableInteger, l = 1 << n;
        dp = new Boolean[l + 1];
        return dfs(0, 0, n, m);  //
    }
    
    private boolean dfs(int tot, int mask, int n, int m) {
        if (tot >= m) return false;  
        if (dp[mask] != null) return dp[mask];
        dp[mask] = false;
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) > 0) continue; // num already picked
            if (!dfs(tot + i + 1, mask | (1 << i), n, m)) {  // found a strategy next player won't win
                dp[mask] = true;
                return true;
            }
        }
        return dp[mask];
    }
}