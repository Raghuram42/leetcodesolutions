class Solution {
    Integer[][] dp;
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        dp = new Integer[n][2];
        
        dp[0][0] = 0;
        dp[0][1] = 1;
        return Math.min(mins(nums1, nums2, n-1, 0), mins(nums1, nums2, n-1, 1));
    }
    public int mins(int[] n1, int[] n2, int i, int s){
        // if(i == 0)
        //     return 0;
        
        if(dp[i][s] != null)
            return dp[i][s];
        int ans= Integer.MAX_VALUE-1;
        if(n1[i] > n1[i-1] && n2[i] > n2[i-1])
            ans = mins(n1, n2, i-1, s);
        
        if(n2[i] > n1[i-1] && n1[i] > n2[i-1])
            ans = Math.min(ans, mins(n1, n2, i-1, 1-s));
            
        return dp[i][s] = s == 1 ? ans+1 : ans;
    }
}