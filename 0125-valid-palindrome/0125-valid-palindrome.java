class Solution {
    public boolean isPalindrome(String s) {
        
        int i = 0;
        int n = s.length()-1;
        
        while(i<=n){
            char curr = s.charAt(i);
            char last = s.charAt(n);
            if(!Character.isLetterOrDigit(curr)){
                i++;
                continue;
            }
            
            if(!Character.isLetterOrDigit(last)){
                n--;
                continue;
            }
            
            if(curr >= 'A' && curr <= 'Z')
                curr += (char)32;
            
            if(last >= 'A' && last <= 'Z')
                last += (char)32;
            
            if(curr != last)
                return false;
            
            i++;
            n--;
        }
        
        return true;
    }
}