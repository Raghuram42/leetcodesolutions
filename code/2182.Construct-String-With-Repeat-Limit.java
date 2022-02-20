class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // int[] map = new int[26];
        TreeMap<Character, Integer> map = new TreeMap<>();
        int n = s.length();
        for(int i=0;i<n;i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            
        StringBuilder ans = new StringBuilder();
        char prev = '@';
        
        while(map.size() > 0){
            
            Character maxKey = map.lastKey();
            if(maxKey == null)
                break;
            if(maxKey == prev){
                Character getPrev = map.lowerKey(maxKey);
                if(getPrev == null)
                    return ans.toString();
                ans.append(getPrev);
                map.put(getPrev, map.getOrDefault(getPrev,0)-1);
                if(map.get(getPrev) == 0)
                    map.remove(getPrev);
                prev = getPrev;
            }else{
                int maxR = Math.min(repeatLimit, map.get(maxKey));
                int cpy = maxR;
                while(maxR >0 ){
                    ans.append(maxKey);
                    maxR--;
                }
                map.put(maxKey, map.getOrDefault(maxKey,0)-cpy);
                if(map.get(maxKey) == 0)
                    map.remove(maxKey);
                prev = maxKey;
                
            }
            
        }
        
        return ans.toString();
    }
}
