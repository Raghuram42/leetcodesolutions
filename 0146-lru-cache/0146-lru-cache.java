class LRUCache {
    
    class Node{
        int val;
        Node next;
        Node prev;
        int key;
        Node(int val, int key){
            this.val = val;
            this.key = key;
        }
        
        @Override
        public String toString(){
            
            int v1 = this.next == null ? 0 : this.next.val;
            
            int v2 = this.prev == null ? 0 : this.prev.val;
            return this.val+" "+v1+" "+v2;
        }
    }
        
    HashMap<Integer, Node> map;
    int cap;
    Node first;
    Node last;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        
    }
    
    public int get(int key) {
        Node curr = map.getOrDefault(key, null);
        
        if(curr == null)
            return -1;
        
        Node prev = curr.prev;
        Node next = curr.next;
        
        if(last == curr)
            return curr.val;
        else if(prev == null) {
            next.prev = null;
            curr.next = null;
           
            first = next;
        }else{
            prev.next = next;
            next.prev = prev;
        }
        
         last.next = curr;
            curr.prev = last;
            last = curr;
        
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            get(key);
            return;
        }else if(map.size() == cap){
            // System.out.println(first+" "+key+" "+value);
            map.remove(first.key);
            if(first.next != null)
                first.next.prev = null;
            first = first.next;
            
            if(first == null)
                last = null;
        } 
        
        if(first == null){     
            map.put(key, new Node(value, key));
            first = map.get(key);
            last = first;
        }else{     
            Node curr = new Node(value, key);
            
            last.next = curr;
            curr.prev = last;
                                    // System.out.println(key+" "+value+" "+map.size()+" "+map+" "+curr);

            map.put(key, curr);

            last = curr;

        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// LinkedList <val , next> sz first  , last 