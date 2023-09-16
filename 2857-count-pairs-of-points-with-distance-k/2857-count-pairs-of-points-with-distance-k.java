class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        
        for(int i=0;i<=k;i++){
            int k1 = i;
            int k2 = k-i;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        
        for(List<Integer> cod: coordinates)
        {
            int a = cod.get(0);
            int b = cod.get(1);
            
            int c = a ^ k1;
            
            if(map.containsKey(c)){
                
                // for(int d: map.get(c))
                //     ans += ((b ^ d) == k2)? 1: 0;
                int d = b^k2;
                ans += map.get(c).getOrDefault(d, 0);
                
            }
            
            
            if(!map.containsKey(cod.get(0)))
                map.put(cod.get(0), new HashMap<Integer, Integer>());
            
            map.get(cod.get(0)).put(cod.get(1), map.get(cod.get(0)).getOrDefault(cod.get(1), 0)+1);
        }
        
        
        }
    return ans;
    }
}