class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] map =new int[26];
        int n = Math.min(s.length(), t.length());
        for(int i=0;i<n;i++){
            map[s.charAt(i)-'a']++;
            
            map[t.charAt(i)-'a']--;
        }
        
        for(int next: map)
            if(next != 0)
                return false;
        
        return true;
    }
}