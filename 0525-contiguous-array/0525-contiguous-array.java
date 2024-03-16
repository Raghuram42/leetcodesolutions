class Solution {
    public int findMaxLength(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;
        while(i<n){
            c += nums[i] == 0 ? -1: 1;
            
            if(c == 0)
                ans = Math.max(ans, i+1);
            
            
            if(map.containsKey(c))
                ans = Math.max(ans, i-map.get(c));
            else
                map.put(c, i);
            
            i++;
                
        }
        
        return ans;
    }

} 