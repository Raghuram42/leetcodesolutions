class Solution {
    public int minOperations(int[] nums) {
        int minop = 0;
        
        
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] >= nums[i]){
                int inc = nums[i-1]+1 - nums[i];
                
                nums[i] += inc; 
                minop += inc;
            }
        }
        
        return minop;
    }
}