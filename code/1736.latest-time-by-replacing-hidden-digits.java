class Solution {
    public String maximumTime(String time) {
        StringBuilder str = new StringBuilder();
        
        for(int i=0;i<time.length();i++){
            if(time.charAt(i) == ':'){
             str.append(':');
            }
            else if(time.charAt(i) == '?'){
                if(i == 0){
                    if(time.charAt(i+1) == '?')
                str.append(2);
                    else if(time.charAt(i+1) <= '3')
                        str.append(2);
                    else
                        str.append(1);
                        
                }
                else if(i>0){
                    if(i == 1 ){
                        if(str.charAt(i-1) != '2')
                        str.append(9);
                        else
                            str.append(3);
                            
                    }
                    else if(i == 3)
                        str.append(5);
                    else 
                        str.append(9);
                }
                
            }else 
                str.append(time.charAt(i));
        }
        
        return str.toString();
    }
}