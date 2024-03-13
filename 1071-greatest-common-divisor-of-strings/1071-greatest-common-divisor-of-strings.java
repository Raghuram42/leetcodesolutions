class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int i = 0;
        int n = str1.length();
        
        int j = 0;
        int m = str2.length();
        
        
        int sm = Math.min(n, m);
        
        String t = "";
        String ans = "";
        while(i<sm){
            t+=str1.charAt(i);
            
            if(same(str1, t) && same(str2, t))
                ans = t;
            
            
            i++;
            
        }
        
        
        return ans;
    }
    
    
    public boolean same(String s, String target){
        int i = 0;
        int n = s.length();
    
        int m = target.length();
        
        
        while(i<n){
            if(s.charAt(i) != target.charAt(i%m))
                return false;
            
            i++;
        }
        
        
        return i == n && i%m == 0;
        
    }
}