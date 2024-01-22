class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        while(i<n){
            int curr = nums[i];
            
            if(i+1 == curr)
                i++;
            else{
                    int movTo = nums[curr-1];
                    
                    if(curr != movTo){
                        nums[curr-1] = curr;
                        nums[i] = movTo;
                    }else
                        i++;
                }
            }
        
        i = 0;
        
        while(i<n){
            if(i+1 != nums[i])
                return new int[]{nums[i], i+1};
            
            i++;
        }
        return new int[0];
        
    }
}