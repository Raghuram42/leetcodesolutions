class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public void setZeroes(int[][] matrix) {
    
        //ArrayList<Pair> pairs = new ArrayList<Pair>
        
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0)
                    dfs(matrix, i, j);
            }
        }
        
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == -999)
                    matrix[i][j] = 0;
            }
        }
    //    return matrix;
    }
    
    public void dfs(int[][] matrix, int i, int j){
        for(int p=0;p<matrix.length;p++){
            matrix[p][j] = matrix[p][j] !=0 ? -999 : matrix[p][j];
        }
        for(int p=0;p<matrix[0].length;p++){
            matrix[i][p] = matrix[i][p] != 0 ? -999: matrix[i][p];
        }
    }
    
}