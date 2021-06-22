class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List[] map = new ArrayList[26];
        
        for(int i=0;i<s.length();i++){
            int ind = s.charAt(i)-'a';
            if(map[ind] == null)
                map[ind] = new ArrayList<Integer>();
            map[ind].add(i);
        }
        
        
        int res = 0;
        for(String w: words){
            int currind = -1;
            boolean found = false;
            for(int i=0;i<w.length();i++){
                int ind = w.charAt(i)-'a';
                if(map[ind] == null){
                     found  = false;
                    break;
                }
                for(int j=0;j< map[ind].size();j++){
                    if((Integer)map[ind].get(j) > currind){
                        currind = (Integer)map[ind].get(j);
                        found = true;
                        break;
                    }else
                        found  = false;
                }
                
           if(!found)
               break;
                
            }
            if(found)
                res++;
            
            
        }
        
        return res;
    }
}