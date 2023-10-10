class Solution {
    public int findDuplicate(int[] nums) {
         
        int i = 0;
        int n = nums.length;
        
        while(i<n){
            
            if(nums[i] != i+1){
                int temp = nums[nums[i]-1];
                if(temp == nums[i])
                    return temp;
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }else 
                i++;
        }
            
            return -1;
            
    }
}