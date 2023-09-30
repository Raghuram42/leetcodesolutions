class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> group = new HashMap<>();
        
        for(String s: strs)
        {
            String k =get(s);
            List<String> curr = group.getOrDefault(k, new ArrayList<>());
            curr.add(s);
            group.put(k, curr);
         }
        return new ArrayList<List<String>>(group.values());
    }
    
    public String get(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}