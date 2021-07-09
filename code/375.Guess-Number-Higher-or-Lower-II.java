
class Solution {
    int[][] memo;
    public int getMoneyAmount(int n) {
        memo = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++)
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        
        return solve(1, n);
    }
    
    
    public int solve(int st, int end){
        if(st >= end)
            return 0;
        if(memo[st][end] != Integer.MAX_VALUE)
            return memo[st][end];
        int res = Integer.MAX_VALUE;
        for(int i=st;i<=end;i++)
            res = Math.min(res, i+Math.max(solve(st, i-1), solve(i+1, end)));
        
        return memo[st][end] = res;
    }
}
