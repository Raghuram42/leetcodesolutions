class Solution {
    public int characterReplacement(String s, int k) {
        int st = 0;
        int end = 0;
        int maxele = 0;
        
        int[] mapr = new int[26];
        int ans = 0;
        
        for(;end<s.length();end++){
            mapr[s.charAt(end)-'A']++;
            
            maxele = Math.max(maxele, mapr[s.charAt(end)-'A']);
            
            if(end-st+1 > maxele+k){
                mapr[s.charAt(st)-'A']--;
                st++;
            }else
                ans = Math.max(ans, end-st+1);
        }
        return ans;
        
        
        
    }
}