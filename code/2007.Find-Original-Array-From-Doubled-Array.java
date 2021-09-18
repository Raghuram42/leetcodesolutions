class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(n%2 != 0)
            return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int change: changed)
            map.put(change, map.getOrDefault(change, 0)+1);
        Arrays.sort(changed);
        int n = changed.length;
        int[] res = new int[n/2];
        
        int i = 0;
        for(int change: changed){
          if(map.containsKey(change)) {
              res[i++] = change;
              map.get(change)--;
              
               if(map.get(change) == 0)
                   map.remove(change);
          }
          
           
            
            
        }
    }
}
