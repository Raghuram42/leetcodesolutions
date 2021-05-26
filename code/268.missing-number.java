class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length * (nums.length+1)/2;
        for(int num: nums)
            n -= num;
        return n;
    }
}