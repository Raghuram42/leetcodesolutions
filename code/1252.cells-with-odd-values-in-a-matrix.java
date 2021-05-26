class Solution {
    public int oddCells(int n, int m, int[][] indices) {
     int[][] mat = new int[n][m];
        int res = 0;
        for(int[] ind : indices){
            int r = ind[0];
            int c = ind[1];
            
            for(int i = 0;i<m;i++){
                mat[r][i] +=1;
                if(mat[r][i]%2 != 0)
                    res++;
                else
                    res--;
            }
            
            
                        for(int i = 0;i<n;i++){
                mat[i][c] +=1;
                if(mat[i][c]%2 != 0)
                    res++;
                else
                    res--;
            }
        }
        return res;
    }
}