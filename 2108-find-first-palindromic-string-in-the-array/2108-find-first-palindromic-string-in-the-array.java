class Solution {
    public String firstPalindrome(String[] words) {
        for(String w: words)
            if(p(w))
                return w;
                
        return "";
    }
    public boolean p(String w){
        int i = 0;
        int n = w.length()-1;
        
        while(i<=n){
            if(w.charAt(i) != w.charAt(n))
                return false;
            i++;
            n--;
            
        }
        return true;
    }
}