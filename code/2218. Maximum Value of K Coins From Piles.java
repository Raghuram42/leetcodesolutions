class Solution {
    int[][][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int m = 0;
        for(List<Integer> p: piles){
            Collections.reverse(p);
            m = Math.max(m, p.size());
        }
        
        int n = piles.size();
        dp = new int[k+1][n+1][m+1];
        
        return solve(piles, k, 0, piles.get(0).size()-1);
    }
	
    public int solve(List<List<Integer>> piles, int k, int i, int j){
        if(k == 0)
            return 0;
        if(i >= piles.size())
            return 0;
        if(piles.get(i).size() == 0)
            return solve(piles, k, i+1, j);
        
        j = piles.get(i).size()-1;
        
        if(dp[k][i][j] != 0)
            return dp[k][i][j];
            
        int ans = 0;
        int include = piles.get(i).get(piles.get(i).size()-1);
        piles.get(i).remove(piles.get(i).size()-1);
        ans = Math.max(ans, include+solve(piles, k-1, i, piles.get(i).size()-1));
        piles.get(i).add(include);
        ans = Math.max(ans, solve(piles, k, i+1, piles.get(i).size()-1));
        
        return dp[k][i][j] = ans;
    }
}
