class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
         s = s.substring(1, s.length() - 1);
        
        for(int i=1;i<s.length();i++){
            List<String> fir = getList(s.substring(0, i));
            List<String> sec = getList(s.substring(i, s.length()));
            
            
            for(String f: fir){
                for(String sc: sec){
                    res.add("("+f+", "+sc+")");
                }
            }
        }
        return res;
        
    }
    
    public List<String> getList(String str){
        
        List<String> res = new ArrayList<>();
        if(str.charAt(0) == '0' && str.charAt(str.length()-1) == '0'){
            if(str.length() == 1)
                res.add("0");
        
            return res;
        }
        
        
         if(str.charAt(0) == '0' && str.length() > 1)
         {
                res.add(str.charAt(0)+"."+str.substring(1, str.length()));
             return res;
         }
                 res.add(str);
         if(str.charAt(str.length()-1) == '0')
         {
          
             return res;
         }
        
        
        
        StringBuilder curr = new StringBuilder();
        for(int i=0;i<str.length()-1;i++){
            curr.append(str.charAt(i));
            res.add(curr.toString()+"."+str.substring(i+1, str.length()));
        }
        return res;
    }
}