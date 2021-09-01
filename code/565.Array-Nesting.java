class Solution {
    int[] dp;
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        int res = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == 0){
                res = Math.max(res, solve(nums, i, new HashSet<Integer>()));
            }
        }
        
        return res;
    }
    
    public int solve(int[] nums, int i, HashSet<Integer> hash){
        
        // System.out.print(i+"-"+nums[i]+", "+" "+hash);
        if(dp[i] != 0)
            return dp[i];
        
        if(hash.contains(nums[i]))
            return 0;
        
        hash.add(nums[i]);
        return dp[i] = 1+solve(nums, nums[i], hash);
        
    }
}
