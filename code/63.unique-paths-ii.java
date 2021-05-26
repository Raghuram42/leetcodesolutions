class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
         if(m == 0)
           return 0;
        int n = obstacleGrid[0].length;
        if(m == 1 && n == 0)
           return 1;
       // if(m >= 1 && n >= 1 &&  obstacleGrid[0][0] == 1)
       //     return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        
         for(int i=0;i<m;i++){
                if(obstacleGrid[i][0] == 1)
                    break;
         
                      dp[i][0] = 1;
            
            //System.out.println(i+" "+j+" "+ obstacleGrid[i][j]+" "+dp[i][j]);
            }
        
        
      for(int j=0;j<n;j++){
                if(obstacleGrid[0][j] == 1)
                    break;
                dp[0][j] = 1;
            }
         
    
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
   //      System.out.println(i+" "+j+" before "+dp[i][j]);
                if(obstacleGrid[i][j] != 1){
                    if(obstacleGrid[i][j-1] != 1)
                   dp[i][j] += dp[i][j-1];
                    if(obstacleGrid[i-1][j] != 1)
                        dp[i][j] += dp[i-1][j];
                }
          //    System.out.println(i+" "+j+" after "+dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}


// class Solution {
//     int res;
//    // int pp;
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         res = 0;
//      //   pp = 0;
//         if(obstacleGrid.length == 1 && obstacleGrid[0].length == 0)
//             return 1;
//         uniq(obstacleGrid, 0, 0);
//         System.out.println(pp);
//         return res;
//     }
//     public void uniq(int[][] grid, int i, int j){
  
//         if(i < grid.length && i>=0 && j >=0 && j < grid[0].length){
//        //     pp++;
//             if(grid[i][j] == 1)
//                 return;
//         if(i == grid.length-1 && j == grid[0].length-1){
//                 res++;
//             return;
//         }
//          //   System.out.println(i+" "+j+" "+res);
//             uniq(grid, i, j+1);
//             uniq(grid, i+1, j);
//         }
//     }
// }