class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0)
            return false;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h: hand)
        {
            map.put(h, map.getOrDefault(h,0)+1);
        }
        while(map.size() > 0){
            int k = 0;
            Integer firstKey = map.firstKey();
        
            while(k<groupSize){
                if(!map.containsKey(firstKey))
                    return false;
                
                map.put(firstKey, map.get(firstKey)-1);
                
                if(map.get(firstKey) == 0)
                    map.remove(firstKey);
                firstKey++;
                k++;
            }
        }
            
        return true;
    }
}