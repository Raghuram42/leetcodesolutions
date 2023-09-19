class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        
        int n = nums.length;
        
        
        while(i<n){
            
            if(nums[i] == i+1)
                i++;
            else {
                int t = nums[nums[i]-1];
                if(t == nums[i])
                    return t;
                
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            }
        }
        
        return 0;
    }
}