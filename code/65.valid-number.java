class Solution {
    public boolean isNumber(String s) {
        s = s.trim().toLowerCase();
        
        int index = s.indexOf('e');
        
        if(index == -1)
            return solveLeft(s);
        
        return solveLeft(s.substring(0, index)) && solveRight(s.substring(index+1));
    }
    
    
    public boolean solveLeft(String s){
        if(s.length() == 0)
            return false;
        int st = 0;
        
        if(s.charAt(st) == '+' || s.charAt(st) == '-'){
            if(s.length() == 1)
                return false;
            
            st++;
        }
        
        boolean point = false;
        if(s.equals("+.") || s.equals("-.") || s.equals("."))
            return false;
        
        while(st<s.length()){
            if(s.charAt(st) == '.'){
                
                if(point)
                    return false;
                
                    point = true;
            }else if(!Character.isDigit(s.charAt(st)))
                return false;
            
            st++;
        }
        
        return true;
    }
    
    
    public boolean solveRight(String s){
        if(s.length() == 0)
            return false;
        int st = 0;
        
        if(s.charAt(st) == '+' || s.charAt(st) == '-'){
            if(s.length() == 1)
                return false;
            
            st++;
        }
        
        
        
        while(st<s.length()){
             if(!Character.isDigit(s.charAt(st)))
                return false;
            
            st++;
        }
        
        return true;
        
    }
}