class LRUCache {
    LinkedHashMap<Integer, Integer> hsm;
    int cap;
    public LRUCache(int capacity) {
        hsm = new LinkedHashMap<Integer, Integer>();
			// @Override
			// protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) 
			// { 
			// 	return size() > capacity; 
			// } };
    cap = capacity;
    }
    
    public int get(int key) {
        if(hsm.containsKey(key)){
           reorder(key,hsm.get(key));
            return hsm.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
  //      System.out.println(hsm);
        if(cap == hsm.size() && !hsm.containsKey(key)){
        Map.Entry<Integer, Integer> toEvict = hsm.entrySet().iterator().next();
            hsm.remove(toEvict.getKey());
        }
        //if(toEvict)
     //   hsm.removeEldestEntryM(hsm.entrySet());
        reorder(key, value);
    }
    public void reorder(int key, int val){
        if(hsm.containsKey(key)){
            hsm.remove(key);
            hsm.put(key, val);
        }
        else{
            hsm.put(key, val);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */