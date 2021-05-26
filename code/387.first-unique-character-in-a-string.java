class Solution {
    public int firstUniqChar(String s) {
       HashMap<Character, Integer> hsm = new LinkedHashMap<Character, Integer>();
        for(char ch : s.toCharArray())
            hsm.put(ch, hsm.getOrDefault(ch, 0)+1);
        
        for(Map.Entry<Character, Integer> entry : hsm.entrySet()) {
            if(entry.getValue() == 1)
                return s.indexOf(entry.getKey());
        }
        
        return -1;
            
            
    }
}