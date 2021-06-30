class Solution {
    boolean power = true;
    public boolean validPalindrome(String s) {
       
        int i = 0;
        int n = s.length()-1;
        while(i<=n){
          if(s.charAt(i) != s.charAt(n)){
              if(power){
                   power = false;
                   return validPalindrome(s.substring(i,n)) || validPalindrome(s.substring(i+1,n+1));
                       }
                return false;
            }
            i++;
            n--;
        }
        
        return true;
        
    }
}
