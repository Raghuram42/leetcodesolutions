class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int neg = 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MAX_VALUE;
        int zer = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                neg += matrix[i][j] < 0 ? 1: 0;
                ans += Math.abs(matrix[i][j]);
                max = Math.min(max, Math.abs(matrix[i][j]));
                if(matrix[i][j] == 0)
                    zer = 0;
            }
        }
        return neg%2 == 0 || zer == 0 ? ans : ans-max*2;
    }
}