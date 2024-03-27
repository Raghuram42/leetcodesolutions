class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0)
            return 0;
        int ans = 0;
        
        int st = 0;
        int end = 0;
        
        int n = nums.length;
        
        long p = 1l;
        while(end<n){
            p = p*nums[end];
            
            while(p>=k && st < end)
                p = p/nums[st++];
            if(p < k)
            ans += end-st+1;            
            end++;
        }
        
        
        return ans;
    }
}