class Solution {
    public int minOperations(int[] nums, int x) {
    
        int ans = -1;
        int l = 0;
        int r = nums.length-1;
        int sum = 0;
        for(l=0;l<=r && sum < x; l++)
            sum += nums[l];
        
        if(sum == x){
            ans = l;
           
        }
        l--;
        while(l<r && r >= 0 && l >=0){
            if(sum+nums[r] > x)
                sum -= nums[l--];
            while(l<r && r >=0 && sum < x) {
                sum += nums[r--];
            }
                if(sum == x){
                    if(ans == -1){
                        ans = l+nums.length-r;
                    }else 
                        ans = Math.min(ans, l+nums.length-r);
                }
            }
        
        return ans;
        
    }
    public int solve(int[] nums, int i, int j, int sum, int c){
        
          
        if(sum == 0)
            return c;
        
        if(i>=nums.length || j < i || j < 0 || sum < 0)
            return Integer.MAX_VALUE;
      
        
        return Math.min(solve(nums, i+1,j, sum-nums[i], c+1), solve(nums, i,j-1, sum-nums[j], c+1));
            
    }
}