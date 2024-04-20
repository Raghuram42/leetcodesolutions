class Solution {
    boolean[][] vis;
    int[] temp;
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        vis = new boolean[n][m];
        
        List<int[]> res = new ArrayList<int[]>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j] == 1 && !vis[i][j]){
                    temp = new int[4];
                    temp[0] = 300;
                    temp[1] = 300;
                    solve(land, i, j);
                    res.add(temp);
                }
            }
        }
        return res.toArray(new int[res.size()][4]);
    }
    
    
    public void solve(int[][] land, int i, int j){
        if(i<0 || j<0 || i >= land.length || j >= land[0].length || vis[i][j] || land[i][j] == 0)
            return;
        vis[i][j] = true;
        if(temp[0]*1000+ temp[1] > i*1000+j){
            temp[0] = i;
            temp[1] = j;
        }
        
        if(temp[2]*1000+ temp[3] < i*1000+j){
            temp[2] = i;
            temp[3] = j;
        }
        
        
        for(int d=0;d<4;d++)
            solve(land, i+dirs[d][0], j+dirs[d][1]);
        
        
        
    }
}