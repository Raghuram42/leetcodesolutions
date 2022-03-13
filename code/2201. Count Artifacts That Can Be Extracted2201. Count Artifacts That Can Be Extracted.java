class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        boolean[][] vis = new boolean[n][n];
        
        for(int[] d: dig)
            vis[d[0]][d[1]] = true;
        
        int ans = 0;
        for(int[] art: artifacts){
            boolean all = true;
            
            int st = art[0];
            int end = art[2];
            int jst = art[1];
            int jend = art[3];
            
            for(int i=st;i<=end;i++){
                for(int j=jst;j<=jend;j++){
                    if(!vis[i][j])
                        all = false;
                }
            }
            
            if(all)
                ans++;
        }
        return ans;
    }
}
