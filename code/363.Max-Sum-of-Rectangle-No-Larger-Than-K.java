class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int res = Integer.MIN_VALUE ;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                // res = matrix[][] Math.max();
                if(matrix[i][j] <= k)      
                    res = Math.max(res, matrix[i][j]);
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                // res = matrix[][] Math.max();
                matrix[i][j] += matrix[i-1][j];
            }
            
        }
        
        // for(int i=0;i<n;i++)
        //     System.out.println(Arrays.toString(matrix[i]));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int p=i;p<n;p++){
                    for(int q=j;q<m;q++){
                        int getS = getSum2(matrix, n, m, i, j, p, q);
                        // System.out.println(getS+" "+i+" "+j+" "+p+" "+q);
                        if(getS <= k)      
                            res = Math.max(res, getS);
                        
                        
                    }
                }
            }
        }
        
        return res;
    }
    
    public int getSum(int[][] mat, int n, int m, int i, int j){
        int sum = 0;
        int k = j;
        while(i<n){
            k = j;
            while(k<m){
                sum += mat[i][k];
                k++;
            }
            i++;
        }
        
        return sum;
    }
    
    public int getSum2(int[][] mat, int n, int m, int i, int j, int st, int ed){
        if(st == i && ed == j)
            return mat[st][ed];
        int sum = mat[st][ed];
        
        
        if(st-i-1>=0)
            sum -= mat[st-i-1][ed];
        if(ed-j-1>=0)
            sum -= mat[st][ed-j-1];        
        
        if(st-i-1>=0 && ed-j-1>=0)
            sum += mat[st-i-1][ed-j-1];
        
        return sum;
        
    }
}
