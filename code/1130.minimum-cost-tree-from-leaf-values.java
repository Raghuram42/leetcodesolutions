class Solution {
    public int findMax(int l, int h, int[]arr){
        int tmp = -1;
        for (int i = l; i <= h; i++) tmp = Math.max(tmp, arr[i]);
        return tmp;
    }
    
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        
        int[][] dp = new int[arr.length][arr.length];
        
        for (int j = 0; j < arr.length; j++){
            for (int i = j; i >= 0; i--){
                for (int k = i; k < j; k++){
                    int tmp = dp[i][k] + dp[k+1][j] + findMax(i,k,arr) * findMax(k+1,j,arr);
                    if (dp[i][j] == 0) 
                        dp[i][j] = tmp;
                    else 
                        dp[i][j] = Math.min(dp[i][j], tmp);
                }
            }
        }
        
        return dp[0][arr.length - 1];
    }
}