class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int cap;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        int v = map.get(key);
        map.remove(key);
        map.put(key, v);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.size() == cap && !map.containsKey(key)){
        int fkey = -1;
        for(int k: map.keySet()){
            fkey = k;
            break;
        }
            // System.out.println(fkey);
            map.remove(fkey);
        }
        
        map.put(key, value);
        get(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */