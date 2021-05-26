class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int currsum = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
         
            
        if(currsum<nums[i] && currsum < 0){
            currsum = nums[i];
        }
            else
            currsum += nums[i];
        
            if(maxsum < currsum)
                maxsum = currsum;
        }
        
        return maxsum;
    }
}