class Solution {
    public boolean isIsomorphic(String s, String t) {
        String genericS = getGeneric(s);
        String genericT = getGeneric(t);
        
        return genericS.equals(genericT);
    }
    
    
    public String getGeneric(String s){
        int[] map = new int[128];
        
        int p = 1;
        
        int i = 0;
        int n = s.length();
        StringBuilder res = new StringBuilder();
        while( i< n){
            if(map[s.charAt(i)] == 0)
                map[s.charAt(i)] = p++;
            int c = 0;
            char curr = s.charAt(i);
            while(i< n && s.charAt(i) == curr ){
                c++;
                i++;
            }
            
            res.append(map[curr]).append("$"+c);
        }
        
        
        return res.toString();
    }
}