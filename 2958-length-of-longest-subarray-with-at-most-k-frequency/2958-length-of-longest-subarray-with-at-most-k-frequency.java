class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int st = 0;
        int n = nums.length;
        int end = 0;
        
        int ans = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(end < n){
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            if(map.get(nums[end]) > k){
                while(map.get(nums[end]) > k)
                    map.put(nums[st], map.getOrDefault(nums[st++], 0)-1);    
            }
            ans= Math.max(ans, end-st+1);
            end++;
            
        }
        
        return ans;
    }
}


