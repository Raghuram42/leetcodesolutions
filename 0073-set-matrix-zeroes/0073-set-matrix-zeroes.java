class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        
        for(int i=0;i<m;i++){
            if(rows[i])
                Arrays.fill(matrix[i], 0);
        }
        
        
        for(int i=0;i<n;i++){
            if(cols[i]){
                for(int j=0;j<m;j++)
                    matrix[j][i] = 0;
            }
        }
    }
}