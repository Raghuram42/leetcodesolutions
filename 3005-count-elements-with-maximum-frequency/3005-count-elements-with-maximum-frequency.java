class Solution {
    public int maxFrequencyElements(int[] nums) {
        int ans = 0;
        
        int[] map = new int[101];
        int max = 0;
        for(int n: nums){
            map[n]++;
            max = Math.max(max, map[n]);
        }
        for(int n : map)
            ans += n == max ? n: 0;
        
        return ans;
    }
}