class Solution {
    public boolean isSubsequence(String s, String t) {
           int i = 0;
           int j = 0;
        int ch_c = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                ch_c++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        
        return ch_c == s.length();
    }
}