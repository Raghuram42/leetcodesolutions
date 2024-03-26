class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int end = 0;
        int st = 0;
        
        int sum = 0;
        int n = nums.length;
        
        while(end < n){
            sum += nums[end];
            
            if(nums[end] == 0 && k > 0)
            {
                sum++;
                k--;
            }else if(nums[end] == 0 && k == 0){
                
                while(k == 0){
                    if(nums[st] == 0)
                        k++;
                    sum -=1;
                    st++;
                }
                k--;
                sum++;
            }
            
            ans = Math.max(sum, ans);
            end++;
        }
        
        
        return ans;
    }
}