class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
     if(nums.length == 0 || k == 0)
         return  false;
        
      int sum = 0;
        for(int num: nums)
            sum += num;
        
        if(sum%k != 0)
            return false;
        boolean[] vis = new boolean[nums.length];
        int t_sum =  sum/k;
      //  Arrays.sort(nums);
       return  solve(nums, 0, 0, t_sum, k, vis);
        
    }
    
    public boolean solve(int[] nums, int i, int csum, int sum, int k, boolean[] vis){
        
        if(k == 0 )
            return true;
        
        if(csum > sum){
            return  false;
        }
        if(csum == sum){
            return solve(nums, 0, 0, sum, k-1, vis);
        }
        
        for(int p = i;p<nums.length;p++){
            
            if(!vis[p]){
                vis[p] = true;
                if(solve(nums, p+1, csum+nums[p], sum, k, vis))
                    return true;
                vis[p] = false;
            }
        }
        
        return false;
    }
}