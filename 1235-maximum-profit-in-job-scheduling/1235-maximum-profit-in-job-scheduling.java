class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] inp = new int[n][3];
        
        for(int i=0;i<n;i++)
            inp[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(inp, (a, b)->a[0]-b[0]);
        
        int i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        int max = 0;
        while(i<n){
           
            while(!pq.isEmpty() && inp[i][0] >= pq.peek()[0])
                max = Math.max(max, pq.poll()[1]);

            pq.offer(new int[]{inp[i][1], max+inp[i][2]});
            i++;
        }
        
            while(!pq.isEmpty())
                max = Math.max(max, pq.poll()[1]);

        
        return max;
    }
}