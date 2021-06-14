class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(grid[i][j] < 0)
                    res++;
        }
        
        return res;
    }
}