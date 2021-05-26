class Solution {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        
        
        for(char c : address.toCharArray()){
            if(c == '.')
                str.append("[.]");
             else
                 str.append(c);
            
        }
        
        return str.toString();
    }
}