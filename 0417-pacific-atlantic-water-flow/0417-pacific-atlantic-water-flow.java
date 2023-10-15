class Solution {
    Boolean[][] pac;
    Boolean[][] atl;
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        pac = new Boolean[n][m];
        atl = new Boolean[n][m];
        
        List<List<Integer>> res = new ArrayList<>();

        
        int i = 0;
        
        for(int j=0;j<m;j++){
             pac[i][j] = true;
             dfsP(heights, i, j, pac);
            
            
             atl[n-1][j] = true;
             dfsP(heights, n-1, j, atl);
        }
        
        i = 0;
        
        for(int j=0;j<n;j++){
             pac[j][i] = true;
             dfsP(heights, j, i, pac);
            
            
             atl[j][m-1] = true;
             dfsP(heights, j, m-1, atl);
        }
        
    
        for(i=0;i<n;i++){
            // System.out.println(Arrays.toString(pac[i])+" "+Arrays.toString(atl[i]));
            for(int j=0;j<m;j++)
                if(pac[i][j] != null && atl[i][j] !=null && pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i,j));
        }
        return res;
    }
    
    
    public boolean dfsP(int[][] h, int i, int j, Boolean[][] pac){
 
        if(i<0 || j<0 || i>=h.length || j >= h[0].length)
            return true;
       
        
        pac[i][j] = true;
        int v = h[i][j];
        
        boolean ans = false;
        for(int k=0;k<4;k++){
            int x = i+dirs[k][0];
            int y = j+dirs[k][1];
            
            if(x<0 || y <0 || x>=h.length || y>=h[0].length || h[x][y] < v || pac[x][y] != null)
                continue;
            
            ans = ans || dfsP(h, x, y, pac);
        }

        return ans;
    }
}