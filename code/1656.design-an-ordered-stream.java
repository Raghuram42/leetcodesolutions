class OrderedStream {
    HashMap<Integer, String> hsm;
    int n;
    int ptr;
    public OrderedStream(int n) {
        hsm = new HashMap<>();
        this.n = n;
        this.ptr = 1;
        
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<String>();
        hsm.put(idKey, value);
        
        if(ptr == idKey){
        while(hsm.containsKey(ptr)){
            res.add(hsm.get(ptr));
            ptr = ptr+1;
        }
        }
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */