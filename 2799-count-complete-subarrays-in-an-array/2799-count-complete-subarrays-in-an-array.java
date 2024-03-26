class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int tot = 0;
        
        int[] map = new int[2001];
        for(int num: nums){
            if(map[num] == 0)
                tot++;
            map[num]++;
        }
        
        
        int st = 0;
        int ans = 0;
        int n = nums.length;
        int end = 0;
        int count = 0;
        map = new int[2001];
        int i = 0;
        while(i < n){
            end = i;
            map = new int[2001];
            count = 0;
        while(end<n){
            map[nums[end]]++;    
            if(map[nums[end]] == 1)
                count++;
            
            // System.out.println(count +" "+end+" "+st);
            if(count == tot)
                ans++;
            
            
            end++;
            
        }
            i++;
        }
        
        
        return ans;
        
    }
}