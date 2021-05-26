class KthLargest {
    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
    q = new PriorityQueue<>();
        this.k = k;
        for(int num:nums)
            insertIntoQ(num);
    }
    
    public int add(int val) {
        insertIntoQ(val);
        return q.peek();
    }
    
    public void insertIntoQ(int num){
        if(q.size() < k)
            q.offer(num);
        else if(num > q.peek()){
            q.poll();
            q.offer(num);
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */