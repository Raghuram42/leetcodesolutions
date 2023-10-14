class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int noOfOranges = 0;
        
        int i = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        while(i<n){
            int j=0;
            while(j<m){
                if(grid[i][j] == 1)
                    noOfOranges++;
                else if(grid[i][j] == 2)
                    q.offer(new int[]{i,j});
                j++;
            }
            i++;
        }
        int ans = 0;
        if(noOfOranges == 0)
            return 0;
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz > 0){
                int[] curr = q.poll();
                
                for(int k=0;k<4;k++)
                {
                    int x = dir[k][0]+curr[0];
                    int y = dir[k][1]+curr[1];
                    
                    if(x<0 || y<0 || x>=n || y >= m || grid[x][y] != 1)
                        continue;
                    noOfOranges--;
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
                sz--;
            }
            ans++;
        }
        
        return noOfOranges == 0 ? ans-1 : -1;
        
    
    }
}