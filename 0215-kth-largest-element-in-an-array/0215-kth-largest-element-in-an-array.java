class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int next: nums)
            pq.offer(next);
        
        while(k > 1){
            pq.poll();
            k--;
        }
        
        return pq.poll();
    }
}