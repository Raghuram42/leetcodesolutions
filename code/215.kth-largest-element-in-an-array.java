class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int num: nums)
            pq.offer(num*-1);
        
        
        while(k>1){
            pq.poll();
            k--;
        }
        
        return pq.poll()*-1;
    }
}