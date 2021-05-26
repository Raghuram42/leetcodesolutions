class Solution {
    int[][] g;
    HashSet<String> hst;
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0)
            return 0;
        g = grid;
        int res =0;
        hst = new HashSet<String>();
        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
                if(g[i][j] == 1){
                    res = dfs(i, j, 0);
                // if(res>4)
                //     res = res-((res/4)-1)*2;
                    return res;
                }
            }
        }
        return 0;
    }
    public int dfs(int i, int j, int res){
     
        if((i>=g.length || i<0) || (j<0 || j>=g[0].length)){
     
            return res;
        }
     
       
       if(g[i][j] == 1){
            res += 4;
           hst.add(i+" "+j);
       }
        else
            return res;
     //    System.out.println(i+" "+j+" "+g[i][j]+" "+res+" "+g[i][j]);
     
     g[i][j] = 0;
        res = dfs(i, j+1, res);
        res = dfs(i+1,j, res) ;
        res = dfs(i-1,j, res) ;
        res = dfs(i,j-1, res);
        
        if(hst.contains(i+" "+(j+1)))
            res--;
        
        if(hst.contains(i+" "+(j-1)))
            res--;
        
        if(hst.contains((i+1)+" "+j))
            res--;
        
        if(hst.contains((i-1)+" "+j))
            res--;
        return res;
    }
}