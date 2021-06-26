class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder(s);
        
        int prevs = 0;
        while(str.length() != 0){
            int ind = str.indexOf(part);
            if(ind == -1)
                return str.toString();
            
            str = str.replace(ind, ind+part.length(), "");
            
        }
        
        return str.toString();
    }
}