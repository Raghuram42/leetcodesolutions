class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        
        int l = 0;
        int r = nums.length-1;
        int ans = 0;
        
        while(l<r){
            
            if(nums[l]+nums[r] == k)
            {
                l++;
                r--;
                ans++;
            }else if(nums[l]+nums[r] < k)
                l++;
            else
                r--;
        }
        
        
        return ans;
    }
}