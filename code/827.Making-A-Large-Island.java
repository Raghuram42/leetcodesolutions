class Solution {
    int[][] vis;
    int[][] dp;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int largestIsland(int[][] grid) {
        int ans = 0;
        
        int n = grid.length;
        int m = grid[0].length;
        vis = new int[n][m];
        dp = new int[n][m];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
            Arrays.fill(vis[i], -1);
        }
        int k = 200000;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] == -1){
                    int max = solve(grid,i, j);
                    ans = Math.max(max, ans);
                    fill(grid, i, j, max, k);
                }
                k++;
            }
        }
        
        // int maxSum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0)
                    ans = Math.max(ans, getDirectionSum(grid, i, j)+1);
            }
        }
        
        return ans;
        
    }
    
    public int solve(int[][] grid, int i, int j){
        if(i>=grid.length || i<0 || j<0 || j>=grid[0].length || grid[i][j] == 0 || vis[i][j] != -1)
            return 0;
        
        vis[i][j] = 1;
        
        int res = 1;
        for(int d=0;d<4;d++)
            res+=solve(grid, i+dir[d][0], j+dir[d][1]);
        
        return res;
    }
    
    public void fill(int[][] grid, int i, int j, int max, int k){
        if(i>=grid.length || i<0 || j<0 || j>=grid[0].length || grid[i][j] == 0 || dp[i][j] == max)
           return;
        
        dp[i][j] = max;
        vis[i][j] = k;
            // System.out.println(max+ "d");
        for(int d=0;d<4;d++)
            fill(grid, i+dir[d][0], j+dir[d][1], max, k);
        
    }
    
    public int getDirectionSum(int[][] grid, int i, int j){
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
         for(int d=0;d<4;d++){
             int x = i+dir[d][0];
             int y = j+dir[d][1];
             
             if(x<0 || y<0 || x>=grid.length || y>= grid[0].length || grid[x][y] == 0)
                 continue;
                 // System.out.println(i+" "+j+" ans "+dp[i][j]);
             if(!set.contains(vis[x][y]))
             {
                 set.add(vis[x][y]);
                 res += dp[x][y];
             }
             
         }
        
        return res;
    }
} 
