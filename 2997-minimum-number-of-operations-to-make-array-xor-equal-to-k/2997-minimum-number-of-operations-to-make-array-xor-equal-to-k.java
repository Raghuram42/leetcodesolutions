class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int[] map = new int[32];
        int[] map2 = new int[32];
        setBinary(k, map2);
        int i = 0;
        for(int num: nums)
            setBinary(num, map);
        
        int ans = 0;
        for(i=0;i<32;i++){
            if(map2[i] != map[i]%2)
                ans++;
        }
        
        return ans;
    }
    
    public void setBinary(int n, int[] m){
        int i=0;
        
        while(i<32){
            m[i] +=(n & (1<<i)) == (1<<i) ? 1: 0;
            i++;
        }
        
    }
}