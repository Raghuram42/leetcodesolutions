class Solution {
    public boolean halvesAreAlike(String s) {
        int[] map = new int[26];
        
        int i = 0;
        int n = s.length();
        
        while(i<n){
            char c = Character.toLowerCase(s.charAt(i));
            if(i < n/2){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    map[c-'a']++;
            }else{
                 if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    map[c-'a']--;
            }
            i++;
        }
        
        return map[0]+map['e'-'a']+map['i'-'a']+map['o'-'a']+map['u'-'a'] == 0 ;
    }
}