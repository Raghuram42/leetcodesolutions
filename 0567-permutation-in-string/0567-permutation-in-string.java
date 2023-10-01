class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int ans = 0;
        
        int i = 0;
        int n = s2.length();
        
        int[] mp = new int[26];
        
        for(i=0;i<s1.length();i++)
            mp[s1.charAt(i)-'a']++;
        
        int[] map = cpy(mp);
        int tans = 0;
        int st = -1;
        boolean fir = true;
        for(i=0;i<n;){
            if(map[s2.charAt(i)-'a'] > 0){
                if(fir){
                    fir = false;
                    st = i;
                }
                ans = Math.max(ans, i-st+1);
                map[s2.charAt(i)-'a']--;
            }else if(st != -1){
                while(st < i && map[s2.charAt(i)-'a'] == 0){
                    map[s2.charAt(st)-'a']++;
                    st++;
                }
                
                if(map[s2.charAt(i)-'a'] == 1){
                    continue;
                }else{
                    st = -1;
                    fir = true;
                }
            }
            i++;
        }
        
        return ans == s1.length();
    }
    
    public int[] cpy(int[] map){
        int[] m = new int[26];
        
        for(int i=0;i<26;i++)
            m[i] = map[i];
        
        return m;
    }
}