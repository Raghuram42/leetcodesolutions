class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0;i<dist.length;i++)
            pq.offer(Math.max(1, dist[i]%speed[i] == 0 ? dist[i]/speed[i] : (dist[i]/speed[i])+ 1));
        
        int res = 0;
        int t = 0;
        while(!pq.isEmpty()){
            if(t<pq.peek()){
                res++;
                pq.poll();
            }
            else
                return res;
            t++;
        }
        
        return res;
    }
}
