class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hsm = new HashMap<Character, Integer>();
        
     boolean res = true;
        for(char i: magazine.toCharArray()){
            if(hsm.containsKey(i))
            hsm.put(i, hsm.get(i)+1);
            else
                hsm.put(i,1);
        }
        
        
        for(char i : ransomNote.toCharArray()){
            if(hsm.containsKey(i) && hsm.get(i)>=1)
                hsm.put(i, hsm.get(i)-1);
            else    
                res = false;
        }
        return res;
    }
}