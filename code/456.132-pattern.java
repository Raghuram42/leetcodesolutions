class Solution {
    public boolean find132pattern(int[] nums) {
     int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(min>nums[i]){
                min = nums[i];
                continue;
            }
            
            
            for(int k= nums.length-1;k>i;k--){
                if(min < nums[k] && nums[k] < nums[i])
                    return true;
                                              }
        }
        return false;
    }
}