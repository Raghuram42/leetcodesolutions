class Solution {
    public String minWindow(String s, String t) {
        ArrayList<Integer> ind = new ArrayList<Integer>();
        
         HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        
        for(int i=0;i<t.length();i++)
            {
           char chr = t.charAt(i);
            freq.put(chr, freq.getOrDefault(chr, 0) + 1);
        }
        String res = "";
          
        int c = 0;
        int st = 0;
        for(int i=0;i<s.length();i++){
            
            if(freq.containsKey(s.charAt(i)) ){
                  freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                if(freq.get(s.charAt(i)) >=0)
                    c++;
            }
            while(c == t.length()){
                if(res.length() == 0 || res.length() > i-st+1)
                    res = s.substring(st, i+1);
                
                if(freq.containsKey(s.charAt(st))){
                       freq.put(s.charAt(st), freq.get(s.charAt(st)) + 1);
                    if(freq.get(s.charAt(st)) > 0)
                    c--;
                }
                st++;
            }
        }
        
               return res;

    }
               
}