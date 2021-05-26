class NumMatrix {
    int[][] dpmat;
    int n;
    int m;
    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        
        
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        
        
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[j][i] += matrix[j-1][i];
            }
        }
        
        dpmat = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return validate(row1-1, col1-1)+validate(row2, col2)-validate(row1-1, col2)-validate(row2, col1-1);
    }
    
    public int validate(int r, int c){
        if(r<0 || c<0)
            return 0;
        return dpmat[r][c];
    }
    
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */