class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        
        int n = s.length();
        
        int i = 0;
        
        int st = 0;
        int ans = 0;
        while(i<n){
            st = Math.max(st, map[s.charAt(i)]);
            
            ans = Math.max(ans, i-st+1);
            
            map[s.charAt(i)] = i+1;
            i++;
        }
        
        return ans;
    }
}