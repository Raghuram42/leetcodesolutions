class Solution {
    public boolean checkInclusion(String p, String s) {
    HashMap<Character, Integer> hsm = new HashMap<Character, Integer>();
          if(p.length() > s.length()) return false;
        for(int i=0;i<p.length();i++){
            hsm.put(p.charAt(i), hsm.getOrDefault(p.charAt(i),0)-1 );
            hsm.put(s.charAt(i), hsm.getOrDefault(s.charAt(i),0)+1 );
        }
        
        if(allnozero(hsm))
            return true;
        
        for(int i=p.length();i<s.length();i++){
             if(allnozero(hsm)){
                return true;
            }
          hsm.put(s.charAt(i), hsm.getOrDefault(s.charAt(i),0)+1 );
          hsm.put(s.charAt(i-p.length()), hsm.getOrDefault(s.charAt(i-p.length()),0)-1 );
        }
          if(allnozero(hsm)){
                return true;
            }
        return false;
    
    }
    public boolean allnozero(HashMap<Character, Integer> hsm){
        
        for(Map.Entry<Character, Integer> ent : hsm.entrySet()){
            if(ent.getValue() != 0) return false;
        }
        
        return true;
    }
}
