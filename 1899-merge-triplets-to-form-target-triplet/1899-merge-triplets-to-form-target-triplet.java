class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Arrays.sort(triplets, (a,b)-> a[0]==b[0] ? a[1] == b[1] ? a[2]-b[2] : a[1]-b[1]:a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> a[1]==b[1] ? a[2] - b[2] : a[1]-b[1]);
        int i = 0;
        int n = triplets.length;
        // int[] curr = new int[3];
        int st = -1;
        while(i<n){
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1])
                pq.offer(triplets[i]);
            i++;
        }
            while(!pq.isEmpty() && pq.peek()[2] > target[2]){
                pq.poll();
            }
        
        if(pq.isEmpty())
            return false;
        int[] prev = pq.poll();
        if(Arrays.equals(prev, target))
            return true;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[2] <= target[2]){
                prev = new int[]{Math.max(prev[0], curr[0]), Math.max(prev[1], curr[1]), Math.max(prev[2], curr[2])};
                
        if(Arrays.equals(prev, target))
            return true;
            }
        }
        return false;
    }
}