class Solution {
    public int maximalSquare(char[][] matrix) {
       //System.out.println(matrix.length +" hh ");
        if(matrix.length == 1 && matrix[0].length == 0 || matrix.length == 0)
            return 0;
        if(matrix.length == 1 && matrix[0].length == 1){
            if(matrix[0][0] == '1')
            return 1;
        else
            return 0;
        }
        int prepare[][] = new int[matrix.length][matrix[0].length];
        int res = 0;
       
        for(int i=0;i<matrix.length;i++){
            prepare[i][0] = matrix[i][0] == '1' ? 1: 0;
            if(matrix[i][0] == '1')
                res =1;
        }
//         for(int i=0;i<matrix.length;i++){
        
//             for(int j=0;j<matrix[0].length;j++){
//             System.out.println(prepare[i][j]+" "+i+" "+j);
//             }}
        for(int i=0;i<matrix[0].length;i++){
            prepare[0][i] = matrix[0][i] == '1' ? 1: 0;
            if(matrix[0][i] == '1')
                res =1;
        }
        
        for(int i=1;i<matrix.length;i++){
        
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == '1')
                prepare[i][j] = Math.min(prepare[i][j-1], Math.min(prepare[i-1][j-1], prepare[i-1][j])) + 1;
                 else
                       prepare[i][j] = 0;
               //   System.out.println(prepare[i][j]+" "+prepare[i][j-1]+" "+prepare[i-1][j]+" "+prepare[i-1][j-1]+" "+i+" "+j+" "+matrix[i][j]);
                if(res < prepare[i][j])
                    res = prepare[i][j];
                
            }
        }
        return res*res;
        
    }
}