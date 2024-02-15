class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        int i = 2;
        int n = nums.length;
        
        long sum = nums[0]+nums[1]+0l;
        long ans = -1;
        while(i<n){
            
            if(nums[i] < sum)
                ans = Math.max(sum+nums[i], ans);
            sum += nums[i];
            i++;
        }
        
        return ans;
    }
}