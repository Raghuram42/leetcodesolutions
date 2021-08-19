class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i =0;

        int ns = s.length();
        int nt = t.length();
        if(ns>nt)
            return isOneEditDistance(t, s);
        
        while(i<ns)
        {
            if(s.charAt(i) != t.charAt(i)){
                if(nt == ns)
                    return s.substring(i+1).equals(t.substring(i+1));
                else
                    return s.substring(i).equals(t.substring(i+1));
            }
            i++;
        } 
        
        return ns+1 == nt;
    }
}
