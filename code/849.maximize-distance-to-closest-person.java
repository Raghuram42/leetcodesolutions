class Solution {
    public boolean backspaceCompare(String S, String T) {
        int p = T.length()-1;
        int i = S.length()-1;
        int s_h = 0;
        int t_h = 0;
        boolean res = true;
        while(p>=0 || i >=0){
        
            while(i>=0 ){
                     if(S.charAt(i) == '#'){
                     s_h++;
                     i--;
                                           }else if(s_h > 0){
                         s_h--;
                         i--;
                     }
                else break;
                //System.out.println(i+" 1 "+s_h);
            }
            while(p>=0 ){
                     if(T.charAt(p) == '#'){
                     t_h++;
                     p--;
                                           }else if(t_h > 0){
                         t_h--;
                         p--;
                     }
                else break;
                //System.out.println(i+" 1 "+s_h);
            }
            
            if(i>=0 && p>=0 && S.charAt(i) != T.charAt(p))
                return false;
            
            if((i>=0) != (p>=0))
                return false;
            
            i--;
            p--;
            }
            
        return res;
        
    }
}