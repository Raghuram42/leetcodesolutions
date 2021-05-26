class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
              int n = locations.length;
        long[][] dp = new long[n][fuel + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }
        
        return (int) solve(locations, start, finish, dp, fuel);
    }
     private long solve(int[] locations, int curCity, int e, long[][] dp, int fuel) {
         if (fuel < 0) return 0;
        if (dp[curCity][fuel] != -1) return dp[curCity][fuel];
          long ans = (curCity == e) ? 1 : 0;
          for (int nextCity = 0; nextCity < locations.length; ++nextCity) {
                 if (nextCity != curCity) {
             ans = (ans + solve(locations, nextCity, e, dp, fuel - Math.abs(locations[curCity] - locations[nextCity]))) % 1000000007;
                 }
          }
         dp[curCity][fuel] = ans;
         return ans;
     }
}