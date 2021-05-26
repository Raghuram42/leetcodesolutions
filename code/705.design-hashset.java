class MyHashSet {
   int[] set;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new int[1000001];
    }
    
    public void add(int key) {
        set[key] = 1;
    }
    
    public void remove(int key) {
        set[key] = 0;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key] == 1 ? true : false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */