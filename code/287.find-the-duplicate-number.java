class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=nums.length/2;j++){
                if(i != j && nums[i] == nums[j] || i != nums.length-1-j && nums[i] == nums[nums.length-1-j])
                    return nums[i];
            }
        }
        return -1;
    }
}