class Solution {
    public boolean increasingTriplet(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        
      int min = Integer.MAX_VALUE;
        int mint = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] < min)
                min = nums[i];
            
            
            if(min < nums[i]){
                mint = Math.min(nums[i], mint);
            }
            
            if(mint < nums[i])
                return true;
        }
        return false;
    }
}