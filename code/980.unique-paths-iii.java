class Solution {
    int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int uniquePathsIII(int[][] grid) {
        int[] st = new int[2];
        int[] end = new int[2];
        int n = grid.length;
        int m = grid[0].length;
        int places = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1)       
                    st = new int[]{i, j};
                else if(grid[i][j] == 2)
                    end = new int[]{i, j};
                else if(grid[i][j] == 0)
                    places++;
                    
            }
        }
        // System.out.println(Arrays.toString(st)+" "+Arrays.toString(end)+" "+places);
        return solve(grid, places, st[0], st[1], end[0], end[1]);
    }
    
    public int solve(int[][] g, int p, int i, int j, int ie, int je){
        if(i>=g.length || j>= g[0].length || i<0 || j<0 || g[i][j] == -1)
            return 0;
        
        if(i == ie && j ==je && p == -1)
            return 1;
        // System.out.println(p+" "+i+" "+j);
        int cur = g[i][j];
        g[i][j] = -1;
        
        int res = 0;
        
        for(int d=0;d<4;d++)
            res += solve(g, p-1, i+dir[d][0], j+dir[d][1], ie, je);
        g[i][j] = cur;
        return res;
    }
}
