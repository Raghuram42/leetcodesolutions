class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
          Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        int i = 0;
        
        while(i<n){
            pq.offer(i);
            i++;
        }
        int[] romc = new int[n];
        PriorityQueue<long[]> pq2 = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        
        i = 0;
        int m = meetings.length;
        Long max = 0l;
        for(int[] meeting : meetings){
           while(!pq2.isEmpty() && pq2.peek()[0] <= meeting[0])
           {
               int curr = (int)pq2.poll()[1];
               pq.offer(curr);
           }
            
            
            if(!pq.isEmpty()){
                Integer  cur = pq.poll();
                
                pq2.offer(new long[]{meeting[1]+0l, cur+0l});
                romc[cur]++;
          
            }else{
                long[]  curr = pq2.poll();
                
                pq2.offer(new long[]{curr[0]+meeting[1]-meeting[0], curr[1]});
                romc[ (int)curr[1]]++;
            }

        }
        
      
        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        for ( i = 0; i < n; i++) {
            if (romc[i] > maxMeetingCount) {
                maxMeetingCount = romc[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
        
        
    }
}