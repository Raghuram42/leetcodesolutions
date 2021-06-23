class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowmax = new int[grid.length];
        int[] colmax = new int[grid.length];
        
        for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid.length;j++){
                 rowmax[i] = Math.max( rowmax[i], grid[i][j]);
                colmax[j] = Math.max(colmax[j], grid[i][j]);
            }
        }
        
        int res = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int max = Math.max(rowmax[i], colmax[j]);
                int min = Math.min(rowmax[i], colmax[j]);
                if(grid[i][j] < max)
                    res += Math.abs(grid[i][j]-min);
            }
        }
        
        return res;
    }
}