class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() <= 2)
            return 0;
        int res = 0;
        
        int i = 0;
        int[] charmap = new int[26];
        // Arrays.fill(charmap, -1);
        
        while(i<Math.min(s.length(),3))
            charmap[s.charAt(i++)-'a']++;
    
        if(doesallsame(s, i-1, charmap))
                res++;
        int p = 0;
        while(i<s.length()){
            charmap[s.charAt(i)-'a']++;
            charmap[s.charAt(i-3)-'a']--;
            if(doesallsame(s, i, charmap))
                res++;
            i++;
        }
        return res;
    }
    public boolean doesallsame(String s, int i, int[] charmap){
        if(charmap[s.charAt(i)-'a'] == charmap[s.charAt(i-1)-'a'] && charmap[s.charAt(i-1)-'a'] == charmap[s.charAt(i-2)-'a'] && charmap[s.charAt(i)-'a']==1)
            return true;
        
        return false;
    }
}