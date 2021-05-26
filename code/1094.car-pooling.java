class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       HashMap<String, Integer> hsm = new HashMap<String, Integer>();
        int maxv = -1;
        for(int[] trip: trips){
            maxv = Math.max(maxv, Math.max(trip[1], trip[2]));
            hsm.put(trip[1]+"S", hsm.getOrDefault(trip[1]+"S", 0)+trip[0]);
            hsm.put(trip[2]+"E", hsm.getOrDefault(trip[2]+"E", 0)+trip[0]);
        }
        System.out.println(hsm);
        
        for(int i=0;i<=maxv;i++){
            String start = i+"S";
            String end = i+"E";
            if(hsm.containsKey(start))
                capacity -= hsm.get(start);
                  if(hsm.containsKey(end))
                capacity += hsm.get(end);
            
            if(capacity < 0)
                return false;
        }
        return true;
    }
}