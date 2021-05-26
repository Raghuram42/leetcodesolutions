class Solution {
    public int countServers(int[][] grid) {
     int[] r = new int[grid.length];   
        int[] c= new int[grid[0].length];   
        
        int t = 0;
        for(int i=0;i<r.length;i++){
            for(int j=0;j<c.length;j++){
                if(grid[i][j] == 1)
                {
                    r[i]++;
                    c[j]++;
                    t++;
                }
            }
        }
        
        for(int i=0;i<r.length;i++){
            for(int j=0;j<c.length;j++){
        if(grid[i][j] == 1 && r[i] == 1 && c[j] == 1)
            t--;
            }
        }
        
        return t;
    }
}