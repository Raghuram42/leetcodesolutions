class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public class Pair{
        int i;
        int j;
        int k;
        Pair(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }
        
        
        @Override
        public String toString(){
            return this.i+" "+this.j+" "+this.k;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        
        int n = heights.length;
        int m = heights[0].length;
        Integer[][] dp = new Integer[n][m];
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a,b)->a.k-b.k);
        
        q.offer(new Pair(0, 0, 0));
        
        // dp[0][0] = 0;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            
                if(cur.i == n-1 && cur.j == m-1)
                    return cur.k;
            for(int k=0;k<4;k++){
                int x = dir[k][0]+cur.i;
                int y = dir[k][1]+cur.j;
                
                if(x<0 || y<0 || x >= n || y >= m)
                    continue;
                
                int nextCost = dp[cur.i][cur.j] == null ? Math.abs(heights[cur.i][cur.j]-heights[x][y]) : Math.max(dp[cur.i][cur.j], Math.abs(heights[cur.i][cur.j]-heights[x][y]));
                
                if(dp[x][y] == null || dp[x][y] > nextCost){
                    dp[x][y] = nextCost;
                    q.offer(new Pair(x, y, nextCost));
                }
            }
        }
        
        
        return 0;
    }
}