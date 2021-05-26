class Solution {
    int[][] res;
    int[][] dp;
    public int[][] updateMatrix(int[][] matrix) {
        
        res =  new int[matrix.length][matrix[0].length];
        dp =  new int[matrix.length][matrix[0].length];
        
        for(int i=0; i<matrix.length;i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(matrix[i][j] == 1){
                    dp[i][j] = Integer.MAX_VALUE;
                    int tres = solve(matrix, i, j);
                res[i][j] = tres ;
                    }
            }
        }

        
        for(int i=0; i<matrix.length;i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
         for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Integer.MAX_VALUE;
                    int tres = solve(matrix, i, j);
                res[i][j] = Math.min(res[i][j], tres) ;
                    }
            }
        }
        return res;
    }
    
    
    public int solve(int[][] matrix , int i, int j){
        if(i< 0 || j <0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == -1)
            return Integer.MAX_VALUE-1;
        
        if(matrix[i][j] == 0)
            return 0;
        
        if(dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        
        
        int c = matrix[i][j];
        matrix[i][j] = -1;
        
        // System.out.println(i+" "+j);
        int res  = solve(matrix, i, j+1);
    
        res = Math.min(solve(matrix, i+1, j), res);
        res = Math.min(solve(matrix, i-1, j), res);
        res = Math.min(solve(matrix, i, j-1), res);
        
        matrix[i][j] = c;
        
        return dp[i][j] = 1+res;
    }
    
    
}