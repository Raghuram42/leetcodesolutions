class Solution {
     public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int mx = 0;
        for (int hi = 1, lo = 0; hi < nums.length; ++hi) {
            k -= (nums[hi] - nums[hi - 1]) * (hi - lo);
            if (k < 0) {
                k += nums[hi] - nums[lo++];
            }
            if (k >= 0) {
                mx = Math.max(mx, hi - lo + 1);
            }
        }
        return Math.max(mx, nums.length > 0 ? 1 : 0);
    }
}