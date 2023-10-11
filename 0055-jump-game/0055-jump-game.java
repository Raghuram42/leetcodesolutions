class Solution {
    public boolean canJump(int[] nums) {
        int i =1;
        int n = nums.length;
        int p = nums[0];
        while(i<n){
            if(p == 0)
                return false;
            p--;
            if(nums[i] > p)
                p=nums[i];
            i++;
        }
        
        return true;
    }
}