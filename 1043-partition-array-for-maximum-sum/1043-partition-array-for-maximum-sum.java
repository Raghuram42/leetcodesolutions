class Solution {
    Integer[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new Integer[501];
        
        return s(arr, 0, k);
    }
    
    
    public int s(int[] a, int i, int k){
        if(i >= a.length)
            return 0;
        if(dp[i] != null)
            return dp[i];
        int ans = a[i];
        int maxans = 0;
        int j = 0;
        for(j=0;j<k && i+j < a.length;j++){
            ans = Math.max(ans, a[i+j]);
            maxans = Math.max(maxans, ans*(j+1)+s(a, i+j+1, k));
        }
        // System.out.println(i+" "+k+" "+maxans+" "+ans+" "+j);
        return dp[i] = maxans;
    }
}