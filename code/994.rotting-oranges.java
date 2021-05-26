class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
        public void println(int res){
            System.out.println(" i: "+this.i+" j: "+this.j+" res: "+res);
        }
        
    }
    Queue<Pair> stk;
    public int orangesRotting(int[][] grid) {
        stk = new LinkedList<Pair>();
        int len = grid.length;
        int i_len = grid[0].length;
        
        for(int i=0;i<len;i++){
            for(int j=0;j<i_len;j++){
                if(grid[i][j] == 2)
                    stk.add(new Pair(i,j));
            }
        }
        // if(stk.isEmpty())
        //     return 0;
        int res = -1;
        while(!stk.isEmpty()){
            res++;
            
            int stk_sz = stk.size();
            
            while(stk_sz != 0){
                Pair tmp = stk.poll();
          //      tmp.println(res);
                int i = tmp.i;
                int j = tmp.j;
                
                dfs(grid, i-1,j);
                dfs(grid, i,j+1);
                dfs(grid, i+1,j);
                dfs(grid, i,j-1);
                
                stk_sz--;
            }
            }
        
        for(int i=0;i<len;i++){
            for(int j=0;j<i_len;j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return res == -1 ? 0 : res;
    }
    
    public void dfs(int[][] g, int i, int j){
        
        if(i >= 0 && i < g.length && j >= 0 && j < g[0].length){
                if(g[i][j] == 1){
                    g[i][j] = 2;
                    stk.add(new Pair(i,j));
                }
                    
        }
    }
}