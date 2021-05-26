class Solution {
    public int numDecodings(String s) {
       
        if(s.length() == 1)
           return s.charAt(0) != '0' ? 1 : 0;
        
        if(s.charAt(0) == '0')
            return 0;
        int prev = (s.charAt(s.length()-2)-'0' )*10 + s.charAt(s.length()-1)-'0';
        int a = s.charAt(s.length()-1) != '0' ? 1 : 0;
        int b = a == 1 || prev <= 26 && s.charAt(s.length()-2) != '0' ? 1 : 0;
        int len = s.length()-1;
        
        while(len >= 0 && s.charAt(len) == '0')
            len--;
        if(len == s.length()-1)
            len--;
        for(int i=len;i>=0;i--){
             if(s.charAt(i) == '0' && s.charAt(i+1) == '0' || s.charAt(i)-'0' > 2 && s.charAt(i+1) == '0')
                 return 0;
            
            int num = (s.charAt(i)-'0')*10 +  (s.charAt(i+1)-'0') ;
            if(s.charAt(i+1) != '0' && s.charAt(i) != '0' && num <= 26)
            {
                int tmp = b;
                b = a+b;
                a = tmp;
            }
            else{
                a = b;
            }
            if(s.charAt(i+1) == '0')
                i--;
        }
        
        return b;
    }
}