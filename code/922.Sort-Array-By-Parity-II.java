class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        if(nums.length <= 1)
            return nums;
        int st = 0;
        int i = 0;
        int n = nums.length;
        
        while(i<n){
            
            if(i%2 == nums[i]%2)
                i++;
             else {
                 while(st < n && nums[st]%2 == st%2)
                     st++;
                     
                 int t = nums[i];
                 nums[i] = nums[st];
                 nums[st] = t;
                 st++;
             }
        }
        
        return nums;
        
        
    }
}
