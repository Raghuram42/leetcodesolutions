class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0)+1);
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->b[1]-a[1]);
        
        for(int k: map.keySet())
            pq.offer(new int[]{k, map.get(k)});
        int ans = 0;
        while(pq.size() > 1){
            int[] f = pq.poll();
            int[] s = pq.poll();
            
            f[1]--;
            s[1]--;
            
            if(f[1] > 0)
                pq.offer(f);
            if(s[1] > 0)
                pq.offer(s);
        }
        
        
        while(!pq.isEmpty())
            ans += pq.poll()[1];
        
        return ans;
        
        
    }
}