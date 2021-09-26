class Solution {

    public long gridGame(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        long[] rightTop = new long[m];    
        long[] leftBot = new long[m];
        
        leftBot[0] = grid[1][0];
        for(int i=1;i<m;i++)
            leftBot[i] = grid[1][i]+leftBot[i-1];
        
        
        rightTop[m-1] = grid[0][m-1];
        
        
        for(int i=m-2;i>=0;i--)
            rightTop[i] = grid[0][i]+rightTop[i+1];
        
        
        long res = Long.MAX_VALUE;
        
        for(int i=0;i<m;i++){
            long next = i+1 < m ? rightTop[i+1] : Long.MIN_VALUE;
            long prev = i-1 >=0 ? leftBot[i-1] : Long.MIN_VALUE;
            res = Math.min(res, Math.max(next, prev));
        }
        
        
        return res;
    }
  
 
}
