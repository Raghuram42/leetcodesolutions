class Solution {
    int[][] memo;
    public int findLength(int[] nums1, int[] nums2) {
        int maxres = 0;
        memo = new int[1001][1001];
        
        for(int i=0;i<1001;i++)
        Arrays.fill(memo[i], -1);
        
        for(int i=0;i<nums1.length;i++)
            for(int j=0;j<nums2.length;j++)
            maxres = nums2[j] == nums1[i] ? Math.max(solve(nums1, nums2, i, j), maxres) : maxres;
        
        
        
        return maxres;
        
    }
    
    public int solve(int[] nums1, int[] nums2, int i, int j){
        // int num2Index = 0;
        int n = nums1.length;
        int m = nums2.length;
        
        if(i >= n || j >= m)
            return 0;
        
        if(nums1[i] != nums2[j])
            return 0;
        
        if(memo[i][j] != -1)
            return memo[i][j];
        int res = 0;
        
    
        return memo[i][j] = 1+ solve(nums1, nums2, i+1, j+1);
            
    }
}
