class Solution {
    int[][] dp;
    int[] prefix;
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        dp = new int[n+1][numCarpets+1];
        
        prefix = new int[n];
        
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], -1);
        
        int w = 0;
        for(int i=0;i<floor.length();i++){
            w += (floor.charAt(i)-'0');
            prefix[i] = w;
        }
        
        return w-solve(floor, numCarpets, carpetLen, 0);
    }
    
    public int solve(String floor, int carp, int len, int i){
        if(i>= floor.length())
            return 0;
        if(carp == 0)
            return 0;
        if(dp[i][carp] != -1)
            return dp[i][carp];
        int whiteTiles = getW(floor, i, i+len);
        int n= floor.length();
        if(whiteTiles > 0){
            return dp[i][carp] = Math.max(whiteTiles+(i+len < n ? solve(floor, carp-1, len, i+len):0), solve(floor, carp, len, i+1));
        }
        
        return dp[i][carp] = solve(floor, carp, len, i+1);
    }
    
    
    public int getW(String floor, int i, int n){
        n = Math.min(floor.length(), n);

        return prefix[n-1]-((i-1) < 0 ? 0 : prefix[i-1]);
    }
}
