class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int  k = mat.length-1;
        for(int i=0;i<mat.length;i++){
            sum += mat[i][i];
           // if(k != i)
                sum += mat[i][k];
            k--;
        }
        if(mat.length%2 == 1)
            sum -= mat[mat.length/2][mat.length/2];
        return sum;
        
    }
}