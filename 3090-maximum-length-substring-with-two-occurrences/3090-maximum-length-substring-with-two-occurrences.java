class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        
        int st = 0;
        int end = 0;
        int[] map = new int[26];
        
        int n = s.length();
        while(end < n){
            int ind = s.charAt(end)-'a'; 
            map[ind]++;
            
            while(map[ind] > 2){
                
                int curr = s.charAt(st)-'a';
                st++;
                map[curr]--;
            }
            
            
            ans = Math.max(ans, end-st+1);
            end++;
        }
        
        return ans;
    }
}