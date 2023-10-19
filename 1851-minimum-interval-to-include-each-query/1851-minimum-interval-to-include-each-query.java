class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int m = queries.length;
        int[][] mapQ = new int[m][2];
        for(int i=0;i<m;i++)
            mapQ[i] = new int[]{queries[i], i};
        
        Arrays.sort(mapQ, (a,b)->a[0]-b[0]);
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[1]-a[0])-(b[1]-b[0]));
        
        int i = 0;
        int j = 0;
        int n = intervals.length;
        int[] res = new int[m];
        while(i<m){
            
            while(j<n && intervals[j][0] <= mapQ[i][0]){
                pq.offer(intervals[j]);
                j++;
            }
            
            while(!pq.isEmpty() && pq.peek()[1] < mapQ[i][0])
                pq.poll();
            
            res[mapQ[i][1]] = pq.isEmpty() ? -1 : pq.peek()[1]-pq.peek()[0]+1;
            i++;
        }
        
        return res;
        
    }
}