class Solution {
    public int maximumProduct(int[] nums, int k) {
        long ans = 1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        int i = 0;
        int n = nums.length;
        
        while(i<n)
            pq.offer(nums[i++]);
        
        while(k>0){
            pq.offer(pq.poll()+1);
            k--;
        }
        long md = 1000000007;
        while(!pq.isEmpty()){
            if(pq.peek() == 0)
                return 0;
            ans = (ans*pq.poll())%md;
        }
        
        return (int)(ans%md);
    }
}
