class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1)
            return true;
        
        return s(nums, 0) || s(nums, 1) ;
    }
    
    public boolean s(int[] nums, int f){
        int i = 0;
        int n = nums.length;
        
        while(i<n-1){
            if(!(f == 0 && nums[i] <= nums[i+1]) && !(f == 1 && nums[i] >= nums[i+1]))
                return false;
            i++;
        }
        
        return true;
}
}