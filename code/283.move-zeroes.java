class Solution {
    public void moveZeroes(int[] nums) {
        int nc = 0;
        int[] res = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(nums[i] != 0){
                res[nc] = nums[i];
             nc++;
            }
        }
        
        for(int i=0;i<nums.length;i++)
        nums[i] =res[i];
    }
}