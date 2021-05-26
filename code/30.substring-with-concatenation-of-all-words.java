class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        
        int len = words[0].length();
        
        
        for(int i=0;i<s.length();i++){
            int j = i;
            int maxlen = words.length;
            boolean vis[] = new boolean[words.length];
         
        HashMap<String, Integer> hashedwords = new HashMap<>();
        
        for(String w: words)
            hashedwords.put(w, hashedwords.getOrDefault(w, 0)+1);
            
            while(j<s.length()){
                String curr = s.substring(j, Math.min(j+len, s.length()));
                  int o=0;
                
//                 for(int p=0;p<words.length;p++){
//                     o=0;
//                     while(o<words[p].length() && o< curr.length() && words[p].charAt(o) == curr.charAt(o) && !vis[p])
//                         o++;
                    
//                     if(o == len){
//                         maxlen--;
//                         vis[p] = true;
//                         break;
//                     }
//                 }
                       if(hashedwords.containsKey(curr) && hashedwords.get(curr) > 0){
                    j+=len;
                     maxlen--;
                    hashedwords.put(curr, hashedwords.get(curr)-1);
                } else
                    break;
                      if(maxlen == 0){
                    res.add(j-((words.length-1)*len)-len);
                    break;
                }
          
         
            }
            
                // hashedwords = hashedwords2;
        }
        
        return res;
    }
}