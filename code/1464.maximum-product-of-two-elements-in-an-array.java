class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        Arrays.sort(nums);
        return (nums[nums.length-1]-1) * (nums[nums.length-2] - 1);
    }
}