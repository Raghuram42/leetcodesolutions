class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        int n = stones.length;
        
        while(i<n)
            pq.offer(-1*stones[i++]);
        
        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            
            if(x < y)
                pq.offer(-1*(y-x));
            
                
        }
        
        return pq.size() == 0 ? 0 : -1*pq.poll();
    }
}