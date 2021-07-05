class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if(n*m != r*c)
            return mat;
        
        int i=0;
        int j=0;
        int k=0;
        int l=0;
        
        int[][] res = new int[r][c];
        while(i<n){
            
            if(j == m){
                j = 0;
                i++;
            }
            if(i == n)
                break;
            
            if(l == c){
                l = 0;
                k++;
            }
            
            res[k][l] = mat[i][j];
            
            j++;
            l++;
        }
        
        return res;
        
    }
}
