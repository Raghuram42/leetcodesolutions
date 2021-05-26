class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0)
            return 0;
    if(isapalin(s))
        return 1;
        return 2;
    }
    public boolean isapalin(String s){
        int i =0;
        int j = s.length()-1;
        
        
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else return false;
        }
        return true;
    }
}