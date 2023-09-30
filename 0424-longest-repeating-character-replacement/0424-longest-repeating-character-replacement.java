class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] map = new int[26];
        
        int st = 0;
        int i = 0;
        int ans = 0;

        int max = 0;
        while(i<n){
            map[s.charAt(i)-'A']++;
            
             max = Math.max(max, map[s.charAt(i)-'A']);
            
            if(i-st+1 > max+k){
                map[s.charAt(st)-'A']--;
                st++;
            }
            ans = Math.max(ans, i-st+1);
            i++;
        }
        
        
        return ans;
    }
}

// AABABBA k = 1 => map[st[i]]++
// st = 0, i = 0 => i++
//               => k--
//               => w  k== 0 ? stv != s[st] k++ map[s[st]]--;
// travel map and store max ans => not needed