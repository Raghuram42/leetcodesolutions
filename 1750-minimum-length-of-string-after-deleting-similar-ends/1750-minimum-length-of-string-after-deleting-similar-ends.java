class Solution {
    public int minimumLength(String s) {
        int ans = 0;
        int i = 0;
        int n = s.length()-1;
        
        while(i<n){
            if(s.charAt(i) != s.charAt(n))
                return s.length()-ans;
            
            char curr = s.charAt(i);
            
            while(i<=n && curr == s.charAt(i)){
                i++;
                ans++;
            }
            
            
            while(i<n && curr == s.charAt(n)){
                n--;
                ans++;
            }
        }
        
        
        return s.length()-ans;
    }
}