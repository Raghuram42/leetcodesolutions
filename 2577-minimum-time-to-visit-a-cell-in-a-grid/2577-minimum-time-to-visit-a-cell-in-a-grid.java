class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0}, {-1,0},{0,-1}};
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>((
        a,b)->a.get(2)-b.get(2));
        
        pq.add(Arrays.asList(0,0,0));
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        while(!pq.isEmpty()){
            List<Integer> curr = pq.poll();
            if(curr.get(0) == n-1 && curr.get(1) == m-1)
                return curr.get(2);
            if(vis[curr.get(0)][curr.get(1)])
                continue;
            vis[curr.get(0)][curr.get(1)] = true;
            for(int k=0;k<4;k++){
                int x = curr.get(0)+dirs[k][0];
                int y = curr.get(1)+dirs[k][1];
                
                if(x<0 || y <0|| x>=n || y >=m || vis[x][y] )
                    continue;
                int w = (grid[x][y]-curr.get(2))%2 == 0 ? 1: 0;
                pq.add(Arrays.asList(x,y, Math.max(curr.get(2)+1, grid[x][y]+w)));   
            }
        }
        return -1;
        
    }
}