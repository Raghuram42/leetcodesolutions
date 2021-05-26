class Solution {
    int Al;
    int[][] dp;
    public int maxUncrossedLines(int[] A, int[] B) {
        dp = new int[A.length][B.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                dp[i][j] = -1;
            }
        }
       return lcs(A, B, 0, 0);
    }
    public int lcs(int A[], int B[], int i,int j){
        if(A.length == i || j == B.length)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(A[i] == B[j])
            return dp[i][j] = 1 + lcs(A, B, i+1, j+1);
        else{
            
        return dp[i][j] = Math.max(lcs(A, B, i+1, j), lcs(A, B, i, j+1));
            }
        
    }
}