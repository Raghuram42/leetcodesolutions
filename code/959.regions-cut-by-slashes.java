class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] graph = new boolean[n * 3][n * 3];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                char cur = grid[i].charAt(j);
                if(cur == '/'){
                    graph[3 * i][3 * j + 2] = true;
                    graph[3 * i + 1][3 * j + 1] = true;
                    graph[3 * i + 2][3 * j] = true;
                }
                else if(cur == '\\'){
                    graph[3 * i][3 * j] = true;
                    graph[3 * i + 1][3 * j + 1] = true;
                    graph[3 * i + 2][3 * j + 2] = true;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n * 3; ++i){
            for(int j = 0; j < n * 3; ++j){
                if(!graph[i][j]){
                    dfs(i, j, graph);
                    res++;
                }
            }
        }
        return res;
    }
    
    void dfs(int x, int y, boolean[][] g){
        if(x < 0 || y < 0 || x == g.length || y == g.length || g[x][y])
            return;
        g[x][y] = true;
        dfs(x+1,y,g);
        dfs(x-1,y,g);
        dfs(x,y+1,g);
        dfs(x,y-1,g);
    }

}