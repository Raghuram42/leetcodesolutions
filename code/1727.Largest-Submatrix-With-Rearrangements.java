class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 1)
                    matrix[i][j] += matrix[i-1][j];
            }
        }
        
        int res = 0;
        for(int i=0;i<n;i++){
            Arrays.sort(matrix[i]);
            
            for(int j=0;j<m;j++)
                res = Math.max(res, matrix[i][j]*(m-j));
        }
        return res;
    }
}
