class Solution {
    public boolean checkZeroOnes(String s) {
        int maxone = 0;
        int maxzero = 0;
        
        
        int i =0 ;
        while(i<s.length()){
            int z = s.charAt(i) == '0'  ? 1:0;
            int o = s.charAt(i) == '1'  ? 1:0;
            int p = i;
            while(p+1<s.length() && s.charAt(p) == s.charAt(p+1)){
                z += s.charAt(p) == '0'  ? 1:0;
                o += s.charAt(p) == '1'  ? 1:0;
                
                p++;
            }
            if(p == i){
                i++;
            }
            else 
                i = p;
            maxone = Math.max(maxone, o);
            maxzero = Math.max(maxzero, z);
            
            
        }
        // System.out.println(maxone+" "+maxzero);
        
        return maxone > maxzero;
    }
}