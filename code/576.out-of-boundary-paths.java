class Solution {
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int dp[][][] = new int[51][51][51];
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    
        for(int i=0;i<51;i++)
            for(int j=0;j<51;j++)
                Arrays.fill(dp[i][j], -1);
        
        return findPaths2(m, n, maxMove, startRow, startColumn);
        
    }
        public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove < 0)
            return 0;
        
        if(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1;
        
        if(dp[maxMove][startRow][startColumn] != -1)
            return dp[maxMove][startRow][startColumn];
        int res = 0;
        for(int d= 0;d<4;d++)
            res = (res +findPaths2(m, n, maxMove-1, startRow+dir[d][0], startColumn+dir[d][1]))%1000000007;
        
        return dp[maxMove][startRow][startColumn] = res%1000000007;
        
        
    }
}