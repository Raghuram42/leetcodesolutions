class TimeMap {
    class Pair{
        String value;
        Integer time;
        
        Pair(String value, int t){
            this.value = value;
            this.time = t;
        }
        
        @Override
        public String toString(){
            return this.value+" "+time;
        }
    }
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());        
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        return search(key, timestamp);
    }
    
    private String search(String key, int timestamp){
        if(!map.containsKey(key))
            return "";
        
        List<Pair> p = map.get(key);
        
        
        int l = 0;
        int r = p.size()-1;
        
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(p.get(mid).time <= timestamp){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        // System.out.println(p+" "+ans+" "+timestamp);
        return ans == -1 ? "" : p.get(ans).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */