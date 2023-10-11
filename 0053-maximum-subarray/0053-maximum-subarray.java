class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        int i = 0;
        int n = nums.length;
        int sum = 0;
        while(i<n){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < nums[i])
                sum = nums[i];
             max = Math.max(max, sum);

            i++;
        }
        
        return max;
    }
}