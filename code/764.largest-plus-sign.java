class Solution {
    // int[][] dir  = new int[][]{{1,0},{-1,0},{0,1},{}};
    int[][] top;
    int[][] bottom;
    int[][] left;
    int[][] right;
    int[][] grid;
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        top = new int[n][n];
        bottom = new int[n][n];
        left = new int[n][n];
        right = new int[n][n];
        grid = new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill( top[i], -1);
            Arrays.fill( left[i], -1);
            Arrays.fill( right[i], -1);
            Arrays.fill( bottom[i], -1);
        }
        
        for(int[] mine: mines){
            grid[mine[0]][mine[1]] = 1;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    int tp = getTop(i,j);
                    tp = Math.min(tp, getBot(i,j));
                    tp = Math.min(tp, getLft(i,j));
                    tp = Math.min(tp, getRgt(i,j));
                    res = Math.max(res, tp);
                }
            }
        }
        return res;
        
    }
    
    
    public int getTop(int i, int j ){
        if(i<0 || grid[i][j] == 1)
            return 0;
        
        if(top[i][j] != -1)
            return top[i][j];
        
        return top[i][j] = 1+getTop(i-1, j);
    }
    
        
    public int getBot(int i, int j ){
        if(j>=grid.length || grid[i][j] == 1)
            return 0;
        
        if(bottom[i][j] != -1)
            return bottom[i][j];
        
        return bottom[i][j] = 1+getBot(i, j+1);
    }
    
        public int getLft(int i, int j ){
        if(j<0 || grid[i][j] == 1)
            return 0;
        
        if(left[i][j] != -1)
            return left[i][j];
        
        return left[i][j] = 1+getLft(i, j-1);
    }
    
    
        public int getRgt(int i, int j ){
        if(i>=grid.length || grid[i][j] == 1)
            return 0;
        
        if(right[i][j] != -1)
            return right[i][j];
        
        return right[i][j] = 1+getRgt(i+1, j);
    }
}