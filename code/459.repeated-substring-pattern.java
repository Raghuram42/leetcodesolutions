class Solution {
    HashMap<Integer, Boolean> hst = new HashMap<Integer, Boolean>();
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len <= 1)
            return false;
    
        ArrayList<Integer> divs = getdivider(s.length());
        
        for(Integer div : divs){
            if(!hst.containsKey(div)){
                hst.put(div, true);
                 
        String start = s.substring(0, div);
        String end = s.substring(div, s.length());
      //          System.out.println(start+" "+end+" "+end.substring(0, div));
       if(!start.equals(end.substring(0, div))){
         hst.put(div, false);
         continue;
        }
      else if(start.equals(end.substring(0, div)) && start.length() == end.length()){
      hst.put(div, true);
      }
      else if(div != 1)
            hst.put(div, check(end, end.length()));
      else 
           hst.put(div, checkeverything(end, end.length()));
            }
            
        }
       // System.out.println(hst);
        for (Map.Entry<Integer, Boolean> set : hst.entrySet()) {
		   if(set.getValue())
               return true;
		}
        return false;
        
        
     
    }
  
    public  ArrayList<Integer> getdivider(int len){
              HashSet<Integer> res = new  HashSet<Integer>();
        res.add(1);
        for(int i=2;i<=Math.min(9,len/2);i++){
            if(len != i && len%i == 0){
                res.add(i);
                res.add(len/i);
            }
        }
        //System.out.println(res+" "+len);
        return new ArrayList<Integer>(res);
    }
    
    public Boolean check(String s, int len){
         System.out.println(s);
        int l = (len/2)-1;
        int r = len-1;
        
        while(l>=0 && r >= (len/2)){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l--;
            r--;
        }
        return true;
    }
    public boolean checkeverything(String s, int len){
        for(int i=1;i<len;i++)
        {
            if(s.charAt(i) != s.charAt(i-1))
                return false;
        }
        return true;
    }
}