class Solution {
    int i=0;
    public int calculate(String s) {
        int res = 0;
        int n = s.length();
     
        while(i<n){
            if(s.charAt(i) == ')'){
                i++;
                return res;
            }else{
            int integr = getInt(s);       
            res += integr;
            }
        }
        
        return res;
        
    }
    
    public int getInt(String s){
        int n = s.length();
        long res = 0;
        boolean sign = false;
        
        while(i<n && s.charAt(i) == '-' || s.charAt(i) == '+') 
        {
            sign = (s.charAt(i) == '-') ^ sign;
            i++;
        }
        
        while(i<n && s.charAt(i) >= '0' && s.charAt(i) <= '9')
        {
            res= res*10+(s.charAt(i)-'0');
            i++;
        }
        while(i<n && s.charAt(i) == ' '){
                i++;
        }
        if(i<n && s.charAt(i) == '('){
            i++;
            res += calculate(s);
        }
        
        if(sign)
            return (int)(-1 * res);
        return (int)res;
        
    }
}
