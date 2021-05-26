class Solution {
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] vis;
    Queue<int[]> q;
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        vis = new  boolean[m][n];
        q = new LinkedList<int[]>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                         vis[i][j] = true;
                    solve(grid, i, j);
                }
            }
        }
        
        
        int ans = 2;
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz>0){
                int[] cind = q.poll();
                
                if(grid[cind[0]][cind[1]] == 0){
                    grid[cind[0]][cind[1]] = ans;
                    solve(grid, cind[0], cind[1]);
                }
                sz--;
            }
            // if(!q.isEmpty())
            ans++;
        }
          int max = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                max = Math.max(grid[i][j],max);
            }
        }
        return max-1 == 0 ? -1 : max-1;
    }
    
    public void solve(int[][] g, int i, int j){
        if(i <0 || j <0 || i>= g.length || j >= g[0].length)
            return;
        
        // if(vis[i][j])
        //     return;
        
   
        
        for(int p=0;p<4;p++){
            
            int x = i+dir[p][0];
            int y = j+dir[p][1];
            
               if(x <0 || y <0 || x>= g.length || y >= g[0].length || vis[x][y])
                  continue;
            vis[x][y] = true;
            
            q.offer(new int[]{x, y});
        }
        
    }
}