class KthLargest {
    PriorityQueue<Integer> pq;
    PriorityQueue<Integer> pq1;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        pq1 = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.k = k;
        int i = 0;
        int n = nums.length;
        while(i<n){
            pq.offer(nums[i]);
            i++;
        }
        
        while(pq.size() > k)
        {
            pq1.offer(pq.poll());
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        
        while(pq.size() > k)
        {
            pq1.offer(pq.poll());
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */