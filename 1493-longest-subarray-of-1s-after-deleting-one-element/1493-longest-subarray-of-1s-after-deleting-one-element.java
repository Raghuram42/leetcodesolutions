class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int k = 1;
        
        int n = nums.length;
        int ans = 0;
        int tans = 0;
        int st = 0;
        while(i<n){
            if(k > 0 && nums[i] == 0){
                k--;
            }else if(k == 0 && nums[i] == 0){
                while(st < i && k == 0){
                    tans -= nums[st];
                    
                    if(nums[st] == 0)
                        k++;
                    st++;
                }
                
                if(k>0)
                    k--;
            }else if(nums[i] == 0)
            {
                st = i+1;
                tans = 0;
            }else
                 tans += nums[i];
            
            
            ans = Math.max(ans, tans);
            i++;
        }
        
        return ans == n ? ans-1: ans;
    }
}