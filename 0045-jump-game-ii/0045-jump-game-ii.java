class Solution {
    public int jump(int[] nums) {
        int curr = 0;
        int next = 0;
        int ans = 0;
        int n = nums.length;
        if(n == 1)
            return ans;
        int i = 0;
        while(i<n){
            next = Math.max(next, i+nums[i]);
            
            if(i==curr && curr < n-1)
            {
                curr = next;
                ans++;
            }
            i++;
        }
        return ans;
    }
}