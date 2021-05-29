class Solution {
    int[] dp;
    int itr;
    public int minimumXORSum(int[] nums1, int[] nums2) {
        dp = new int[1<<14];
        // for(int i=0;i<nums1.length;i++)
        Arrays.fill(dp, Integer.MAX_VALUE);
        int r = solve(0,0, nums1, nums2, new boolean[nums2.length]);
        
        return r;
    }
    
    public int solve(int i, int m, int[] nums1, int[] nums2, boolean[] vis){
        if(i>= nums1.length)
            return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        if(dp[m] != Integer.MAX_VALUE)
            return dp[m];
        
        for(int j=0;j<nums2.length;j++){
            if(!vis[j]){
                // m =;
                vis[j] = true;
                int tempres = solve(i+1,  m |(1<<j), nums1, nums2, vis);
                res = Math.min(res, (nums1[i]^nums2[j]) + (tempres == Integer.MAX_VALUE ? 0 : tempres));
                // dp[i][j] = Math.min(res, dp[i][j]);
                vis[j] = false;
            }
        }
        
        return dp[m] = res;
    }
}