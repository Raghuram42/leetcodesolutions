class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rowsMat = getRows(mat);
        int[] colsMat = getCols(mat);
        
        int[] rowsTar = getRows(target);
        int[] colsTar = getCols(target);
        
        
        
        // System.out.println(Arrays.toString(rowsMat)+" "+Arrays.toString(colsMat) +" "+Arrays.toString(rowsTar)+" "+Arrays.toString(colsTar));
        return  (check(rowsMat, rowsTar) && check(colsMat, colsTar)) || (check(rowsMat, colsTar) && check(colsMat , rowsTar));
    }
    
    
    public int[] getRows(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[] rows = new int[n];
        // int[] cols = new int[m];
        
        
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<m;j++)
                sum += mat[i][j];
            
            rows[i] =sum;
            
        }
        return rows;
    }
    
    
    public int[] getCols(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        // int[] rows = new int[n];
        int[] cols = new int[m];
        
        
        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=0;j<n;j++)
                sum += mat[j][i];
            
            cols[i] =sum;
        }
        return cols;
    }
    
    
    public boolean check(int[] rowsMat, int[] rowsTar){
        int n= rowsMat.length;
        int i=0;
        for(i=0;i<n;i++){
        if(rowsMat[i] != rowsTar[i])
            break;
        }
        
        if(i != n){
            
        for(i=n-1;i>=0;i--){
        if(rowsMat[i] != rowsTar[n-i-1])
            break;
        }
        if(i != -1)
            return false;
            
        }
        
        return true;
    }
}