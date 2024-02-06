class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,  List<String>> map = new HashMap<>();
        
        for(String s: strs){
            String ky = getKey(s);
            
            if(!map.containsKey(ky))
                map.put(ky, new ArrayList<>());
            
            map.get(ky).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public String getKey(String s){
        int[] map =new int[256];
        
        for(int i=0;i<s.length();i++)
            map[s.charAt(i)]++;
        
        StringBuilder ky = new StringBuilder();
        
        for(int i=0;i<256;i++){
            while(map[i] > 0){
                ky.append((char)(i));
                map[i]--;
            }
        }
        return ky.toString();
    }
}