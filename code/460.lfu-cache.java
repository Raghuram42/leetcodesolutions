// class LFUCache {
//     HashMap<Integer, Node> hsm;
//     Node start;
//     Node end;
//     int cap;
//     public LFUCache(int capacity) {
//         this.cap = capacity;
//         hsm = new HashMap<Integer, Node>();
//     }
//     public int get(int key) {
//         if(hsm.containsKey(key)){
//             Node curr  = hsm.get(key);
//             curr.freq += 1; 
//             MovetoRight(curr);
//             return  curr.val;
//             }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         if(hsm.containsKey(key)){
//             Node curr = hsm.get(key);
//             curr.val = value;
//             curr.freq = 1;
//             MovetoRight(curr);
//         }
//         else{
//             if(hsm.size() == cap){
//                 deleteleastfreq();
//             }
            
//             Node new_n = new Node(key, value, 1);
//             hsm.put(key, new_n);
            
//             if(start == null){
//                 start = new_n;
//                 end = new_n;  
//               }
//           else{
//             Node tmp = end;
//             while(tmp != null && tmp.freq> 1){
//                 tmp = tmp.prev;
//             }
//             if(tmp == null){
//                 new_n = start.next;
//                 start.prev = new_n;
//                 start = new_n;
//             }
//             else{
                
//             new_n = tmp.next;
//                 tmp.next.prev = new_n;
//             new_n.prev = tmp;    
//                 tmp.next = new_n;
//             }
//         }
//     }
//     }
    
//     public void MovetoRight(Node curr){
//         if(curr == end)
//             return;
        
//         if(start == curr){
//             Node trav_start = start;
            
//             while(trav_start != null && trav_start.next != null && trav_start.freq <= curr.freq){
//                 trav_start = trav_start.next;
//             }
//             if(trav_start.freq <= curr.freq){
//             trav_start.next = curr;
//             curr.prev = trav_start;
//             start = start.next;
//             }
//             else{
//                 curr.prev = trans_start.prev;
//                 trans_start.prev.next = curr;
//                 curr.next = trans_start;
//                 trans_start.prev = curr;
//             }
//             start = start.next;
//             continue;
//         }
//         Node trav_end = end;
        
//         while(trav_end != null && trav_end.freq > curr.freq){
//             trav_end = end.prev;
//         }
//         curr.next.prev = curr.prev;
//         curr.prev.next = curr.next;
        
//         curr.next = trav_end.next;
//         trav_end.next.prev = curr;
//         curr.prev = trav_end;
//         }
    
//     public void deleteleastfreq(){
        
//         if(start == end)
//         {
//             start = null;
//             end = null;
//         }
//         else{
//             start.next.prev = null;
//             start = start.next;
//         }
//     }
//     class Node{
//         Node next;
//         Node prev;
//         int val;
//         int key;
//         int freq;
        
//         Node(int key, int value, int freq){
//             this.key = key;
//             this.val = value;
//             this.freq = freq;
//         }
            
//     }
    
// }

// /**
//  * Your LFUCache object will be instantiated and called as such:
//  * LFUCache obj = new LFUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */
class LFUCache {
    
    class LinkedNode{
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
        int count = 0;
    }
    
    private Map<Integer, LinkedNode> nodeMap;
    private int capacity;
    private LinkedNode head, tail;
    private PriorityQueue<LinkedNode> heap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>();
        heap = new PriorityQueue<>((a, b) -> (a.count - b.count));
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        LinkedNode curNode = nodeMap.get(key);
        curNode.count++;
        updateHeap(curNode);
        moveToHead(curNode);
        return curNode.value;
    }
    
    private void removeLast() {
        List<LinkedNode> minList = new ArrayList<>();
        if (nodeMap.isEmpty() || heap.isEmpty()) return;
        int min_count = heap.peek().count;

        while (!heap.isEmpty() && heap.peek().count == min_count) minList.add(heap.poll());
        if (minList.size() == 1) {
            System.out.println(minList.get(0).key);
            LinkedNode minNode = minList.get(0);
            deleteNode(minNode);
            nodeMap.remove(minNode.key);
        } else {
            LinkedNode cur = tail.prev;
            // find the one nearest to tail
            while(cur != head) {
                if (minList.contains(cur)) {
                    deleteNode(cur);
                    nodeMap.remove(cur.key);
                    // remember to add other nodes back into heap
                    for (LinkedNode n: minList) {
                        if (n != cur) heap.offer(n);
                    }
                    break;
                } else {
                    cur = cur.prev;
                }
            }
            
        }
    }
    
    private void moveToHead(LinkedNode node) {
        deleteNode(node);
        addToHead(node);
    }
    
    private void addToHead(LinkedNode node) {
        if (node == null) return;
        LinkedNode oldHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldHead;
        oldHead.prev = node;
    }
    
    private void deleteNode(LinkedNode node) {
        if (node == null) return;
        LinkedNode next = node.next;
        node.prev.next = next;
        next.prev = node.prev;
    }
    
    // must update heap explicitly because it will not monitor on 'count' changes to update itself automatically.
    private void updateHeap(LinkedNode node) {
        if (node == null) return;
        heap.remove(node);
        heap.offer(node);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (!nodeMap.containsKey(key) && heap.size() == capacity) removeLast();
        if (nodeMap.containsKey(key)) {
            LinkedNode curNode = nodeMap.get(key);
            curNode.value = value;
            curNode.count++;
            updateHeap(curNode);
            moveToHead(curNode);
        } else {
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;
            nodeMap.put(key, newNode);
            addToHead(newNode);
            heap.offer(newNode);
        }
    }
}