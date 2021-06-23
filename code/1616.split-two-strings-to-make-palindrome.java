class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        
        // for(int i=0;i<a.length();i++){
        //     if(palindrome(a.substring(0, i+1)+b.substring(i+1, b.length())) || palindrome(b.substring(0, i+1)+a.substring(i+1))){
        //         System.out.println(i);
        //         return true;
        //     }
        // }
        // return false;
        
        return solve(a,b) || solve(b,a);
    }
    
    public boolean palindrome(String a){
        int i = 0;
        int j = a.length()-1;
        // System.out.println(a);
        while(i<=j){
            if(a.charAt(i) != a.charAt(j))
                return false;
            
            i++;
            j--;
        }
         // System.out.println(a);
        return true;
    }
    
    
    public boolean solve(String a, String b){
        int i = 0;
        int j = b.length()-1;
        
        while(i<j){
            if(a.charAt(i) != b.charAt(j))
                return false || palindrome(b.substring(i, j+1)) ||  palindrome(a.substring(i, j+1));
            
            i++;
            j--;
        }
        
        return true;
        
        
    }
}