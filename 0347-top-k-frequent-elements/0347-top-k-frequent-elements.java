class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] map = new int[20002];
        
        for(int num: nums){
            // map[num][0] = num;
            map[num+10000]++;
        }
        
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>((a, b)->map[b]-map[a]);
        int i = 0;
        for(int mp : map){
            if(mp > 0)
                pq.offer(i);
            i++;
        }
        
        int[] res = new int[k];
        i = 0;
        while(k>0){
            res[i++] = pq.poll()-10000;
            k--;
        }
        return res;
    }
}