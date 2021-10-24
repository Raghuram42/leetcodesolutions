class Solution {
    public int countValidWords(String sentence) {
        String[] inp = sentence.trim().split(" ");
        int res = 0;
        for(String next: inp)
        {
            if(next.trim().length() > 0){
                if(notContainNumber(next.trim()) && hasOnehyphen(next.trim()) && ContainPunInBet(next.trim())){
                    res++;
                }
            }
        }
        return res;
    }
    
    public boolean hasOnehyphen(String s){
        int i = 0;
        int n = s.length();
        if(s.charAt(0) == '-' || s.charAt(n-1) == '-')
            return false;
        int h = 0;
        while(i<n){
            if(s.charAt(i) == '-'){
                if(!(s.charAt(i-1)  >= 'a' && s.charAt(i-1) <= 'z' && s.charAt(i+1)  >= 'a' && s.charAt(i+1) <= 'z'))
                    return false;
                h++;
            }
            
            i++;
        }
        
        return h<=1;
    }
    
        public boolean notContainNumber(String s){
        int i = 0;
        int n = s.length();
        
      
        while(i<n){
            if(Character.isDigit(s.charAt(i)))
                return false;
            i++;
        }
        
        return true;
    }
    
    
    public boolean ContainPunInBet(String s){
        int i = 0;
        int n = s.length();
        
      
        while(i<n-1){
            if(s.charAt(i) == '!' || s.charAt(i) == ',' || s.charAt(i) == '.')
                return false;
            i++;
        }

        return true;
    }
}
