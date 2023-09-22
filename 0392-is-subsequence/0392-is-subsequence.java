class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length())
            return false;
        
        
        int i = 0;
        int j = 0;
        
        int n = s.length();
        int m = t.length();
        
        while(i<n && j < m){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else
                j++;
        }
        
        return i == n;
    }
}