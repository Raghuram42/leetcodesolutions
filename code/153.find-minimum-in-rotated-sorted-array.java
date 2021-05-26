class Solution {
    public int findMin(int[] nums) {
     
        int l = 0;
        int r = nums.length-1;
        
        if(nums[l] > nums[r]){
            while(l<r){
                if(nums[l+1] > nums[l] && nums[r-1] < nums[r]){
                    l++;
                    r--;
                }else if(nums[l+1] < nums[l])
                    return nums[l+1];
                else 
                    return nums[r];
            }
        }
        else
        return nums[l];
        
        return 0;
    }
} 