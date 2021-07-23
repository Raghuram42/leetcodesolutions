class Solution {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0, 0, k});
        
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dis = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dis[i], -1);
        dis[0][0] = k;
        int dep = 0;
        while(!q.isEmpty()){
            
            int sz = q.size();
            
            while( sz > 0 ) {
                int[] cur = q.poll();
                if(cur[0] == n-1 && cur[1] == m-1)
                    return dep;
                for(int d=0;d<4;d++){
                    int x = cur[0]+dir[d][0];
                    int y = cur[1]+dir[d][1];
                    
                    if( x<0 || y<0 || x>= n || y>= m || (cur[2] == 0 && grid[x][y] == 1))
                        continue;
                        
                        if(dis[x][y] >= cur[2]-grid[x][y])
                            continue;
                    
                        dis[x][y] = cur[2]-grid[x][y];
                        q.offer(new int[]{x, y, dis[x][y]});
                    
                    
                }
                sz--;
            }
            dep++;    
        }
        return -1;
        
    }
}

/*
   0 1 2
 0[0,0,0],
 1[1,1,0],
 2[0,0,0],
 3[0,1,1],
 4[0,0,0]
 
 
 dis 0 1 2
   0 0 1 2
   1 1 2 3
   2 2 3 4
   3 3   5
   4 4 5 6
k = 1
      0       1        2      3      4        5        6
q -> 0 0 1  0 1 1   0 2 1   1 2 1   2 2 1   3 2 0   4 2 0
            1 0 0   1 1 0                           
                            2 1 0    
                    2 0 0                   
                            3 0 0   
                                    4 0 0   
                                            4 1 0   
                                                    4 2 0
                                                    */
