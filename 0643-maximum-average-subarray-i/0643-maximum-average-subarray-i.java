class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0d;
        double ans = 0d;
        
        int i = 0;
        int n = nums.length;
        
        while(i<k)
            avg += nums[i++];
        
        ans = avg;
        int st = 0;
        while(i<n){
            avg+=nums[i++]-nums[st++];
            ans = Math.max(ans, avg);
        }
        
        return ans/k;
        
    }
}