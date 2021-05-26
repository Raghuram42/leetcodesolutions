class Solution {
    public String validIPAddress(String IP) {
        if(IP.length() == 0 )
               return "Neither";
        
        String[] digits = IP.split("\\.", 0);
        if(IP.charAt(IP.length()-1) == '.' || IP.charAt(IP.length()-1) == ':')
            return "Neither";
        
        if(!digits[0].equals(IP)){
            if(digits.length != 4)
                return "Neither";
            
            for(String s: digits){
                try{
                if(s.charAt(0) == '0' && s.length() <=3 && s.length() !=1 || Integer.parseInt(s) > 255)
                    return "Neither";
                }
                catch(Exception e){
                     return "Neither";
                }
        
                for(char c : s.toCharArray()){
                    if(Character.getNumericValue(c)<0 || Character.getNumericValue(c)>9)
                          return "Neither";
                }
            }
            return "IPv4";
      }
        else{
            digits =  IP.split(":", 0);
    
          if(digits.length != 8)
                return "Neither";
           
            for(String s: digits){
                if(s.length()>4 || s.length()==0)
                    return "Neither";
                   for(char c : s.toCharArray()){
                    if(c == '-'){
                        System.out.println(c);
                          return "Neither";
                    }
                          if(Character.isDigit(c)) {
                    continue;
                }
                 if(!((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                    return "Neither";
                }
                }
            }
            
             
 
                return "IPv6";
        }

       // return "Neither4";
    }
}