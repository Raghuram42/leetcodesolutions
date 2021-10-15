class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int st = 0;
        int end = 0;
        int n = nums.length;
        
        int ans = 0;
        int sum = 0;
        int[] map = new int[10001];
        Arrays.fill(map, -1);
        while(end < n){
            
            if(map[nums[end]] != -1)
            {
                while(st <= map[nums[end]])
                {
                    sum -= nums[st];
                    st++;
                }
                
            }
            sum += nums[end];
            ans = Math.max(sum, ans);
            map[nums[end]] = end;
            end++;
            
            
        }
        return ans;
    }
}
