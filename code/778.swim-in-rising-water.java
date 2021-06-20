class Solution {
    int[][] dp;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int ans;
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n];
        ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        // Priority<Integer>
        Queue<int[]> q = new LinkedList<>();
        
        
        
        q.offer(new int[]{0,0});
        dp[0][0] = grid[0][0];
        
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz>0){
                int[] curr = q.poll();
                
                
                for(int d=0;d<4;d++){
                    int x = dir[d][0]+curr[0];
                    int y = dir[d][1]+curr[1];
                    
                    if(x<0 || y<0 || x>=n || y>=n)
                        continue;
                    
                    if(dp[x][y] > Math.max(dp[curr[0]][curr[1]], grid[x][y])){
                        q.offer(new int[]{x,y});
                    dp[x][y] =  Math.max(dp[curr[0]][curr[1]], grid[x][y]);
                    }
                    
                    
                }
                
                sz--;
            }
        }
        
        return dp[n-1][n-1];
        
    }
    
    
    public int solve(int[][] g, int i, int j, int max){
        if(i<0 || j <0 || i>= g.length || j>=g.length || g[i][j] == -1)
            return Integer.MAX_VALUE;
        
        max = Math.max(max, g[i][j]);
        if(i == g.length-1 && j == g.length-1){
            return Math.min(max, ans);
        }
        
        int t = g[i][j];
        g[i][j] = -1;
        int res = Integer.MAX_VALUE;
        for(int p=0;p<4;p++)
            res = Math.min(res, solve(g, i+dir[p][0], j+dir[p][1], max));
        
        g[i][j] = t;
        return res;
        
    }
}


/*
class Solution {
    int[][] dp;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int ans;
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n];
        ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        
        return solve(grid, 0, 0, grid[0][0]);
    }
    
    
    public int solve(int[][] g, int i, int j, int max){
        if(i<0 || j <0 || i>= g.length || j>=g.length || g[i][j] == -1)
            return Integer.MAX_VALUE;
        
        max = Math.max(max, g[i][j]);
        if(i == g.length-1 && j == g.length-1){
            return Math.min(max, ans);
        }
        
        int t = g[i][j];
        g[i][j] = -1;
        int res = Integer.MAX_VALUE;
        for(int p=0;p<4;p++)
            res = Math.min(res, solve(g, i+dir[p][0], j+dir[p][1], max));
        
        g[i][j] = t;
        return res;
        
    }
}
*/