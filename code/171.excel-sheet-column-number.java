class Solution {
    public int titleToNumber(String s) {

        int res = 0;
        for(int i=0;i<s.length();i++){
            res *= 26; 
            res += s.charAt(i)-'@';
        }
            
        return res;
        
    }
}