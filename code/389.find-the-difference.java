class Solution {
    public char findTheDifference(String s, String t) {
        int[] ary = new int[26];
        
        for(int i=0;i<s.length();i++)
            ary[s.charAt(i)-'a']++;
        
        
        for(int i=0;i<t.length();i++){
            ary[t.charAt(i)-'a']--;
            if(ary[t.charAt(i)-'a'] < 0)
                return t.charAt(i);
        }
        return 'a';
    }
}