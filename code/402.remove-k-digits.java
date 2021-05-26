class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k)
            return "0";
        StringBuilder nm = new StringBuilder(num);

        for(int i=0;i<k;i++){
            int p =0;
            while(p <nm.length() -1 && nm.charAt(p) <= nm.charAt(p+1))
                p++;
            nm.delete(p, p+1);    
        }
        
        while(nm.length() > 1 && nm.charAt(0) == '0')
            nm.delete(0, 1);
        
        
        return nm.length() == 0 ? "0" : nm.toString();
    }
}