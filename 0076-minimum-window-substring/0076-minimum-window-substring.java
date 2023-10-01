class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int n = s.length();
        
        int siz = t.length();
        int st = 0;
        String ans = "";
        
        while(i<siz)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i++), 0)+1);
        

        i = 0;
        while(i<n){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                
                map.put(curr, map.get(curr)-1);
                
                if(map.get(curr) >= 0)
                    siz--;
            }
                                        // System.out.println(map+" in "+siz);

            
            while(siz == 0){
                if(ans.length() ==0 || ans.length() > i-st+1)
                    ans = s.substring(st, i+1);
                
                if(map.containsKey(s.charAt(st))){
                    map.put(s.charAt(st), map.get(s.charAt(st))+1);
                    // System.out.println(map+" "+s.charAt(st) );
                    if(map.get(s.charAt(st)) == 1)
                        siz++;
                }
                st++;
            }
                i++;
                
            }
            
         return ans;   
        }
        
    }