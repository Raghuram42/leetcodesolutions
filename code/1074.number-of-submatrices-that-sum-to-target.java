// class Solution {
//     public int numSubmatrixSumTarget(int[][] matrix, int target) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int[][] presum = new int[n][m];
//         int res = 0;
//         for(int i=0;i<n;i++){
            
//             for(int j=0;j<m;j++){
//                 // if(matrix[i][j] == target)
//                 //     res++;
//                 presum[i][j] = j-1 < 0 ? matrix[i][j] : matrix[i][j]+presum[i][j-1];
//             }
//         }
        
//         // System.out.println(res);
//         for(int i=0;i<n;i++){
            
//             for(int j=0;j<m;j++){
//                 // if(matrix[i][j] == target)
//                 //     res++;
//                 presum[i][j] = i-1 >= 0 ? presum[i][j]+presum[i-1][j]: presum[i][j];
//                 // System.out.println(presum[i][j]+" "+i+" "+j);
//             }
//         }
        
        
        
//         for(int i=0;i<n;i++){
            
//             for(int j=0;j<m;j++){
//                 if(i !=0 && j != 0 && presum[i][j] == target)
//                     res++;
//                 for(int k=0;k<i;k++){
//                     for(int l=0;l<j;l++){
//                         if(k==l)
//                             continue;
                        
//                         if(presum[i][j]-presum[i][j-l]-presum[i-k][j]+presum[i-k][j-l] == target){
//                             res++;
//                             System.out.println(i+" "+j+" "+" "+k+" "+l);
//                         }
                        
                        
//                         // if(presum[i][j]-presum[i][j-l]-presum[i-k][j]+presum[i-k][j-l] == target)
//                         //     res++;
//                     }
//                 }
//                 // presum[i][j] = i-1 >= 0 ? presum[i][j]+presum[i-1][j]: presum[i][j];
         
//             }
//         }
        
//         return res;
//         // for()
//     }
// }

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        HashMap<Integer, Integer> count = new HashMap();
        int [] dp = new int [matrix[0].length];
        int res = 0;
        for(int i = 0;i <matrix.length;i++){
            for(int j =i; j < matrix.length;j++){
                count.put(0, 1);
                res += numSubmatrixSumTarget(i, j, matrix, target, count, dp);
                count.clear();
            }
        }
        return res;
    }
    
    private int numSubmatrixSumTarget(int first, int second, int [][] matrix, int target, HashMap<Integer, Integer> count, int [] dp){
        int res = 0;
        int sum = 0;
        for(int i  = 0;i<matrix[first].length;i++){
            sum += matrix[second][i];
            dp[i] = sum+ (first == second?0:dp[i]);
            res += count.getOrDefault(dp[i] - target, 0);
            count.put(dp[i], count.getOrDefault(dp[i], 0)+1);
        }
        return res;
    }


}