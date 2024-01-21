class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(n == 2)
        return Math.max(nums[n-2], nums[n-1]);
        
        nums[2] += nums[0];
        for(int i=3;i<n;i++)
        {
            nums[i] += Math.max(nums[i-2],nums[i-3]); 
        }
        // System.out.println(Arrays.toString(nums));
        return Math.max(nums[n-2], nums[n-1]);
    }
}