class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        
        int i = 1;
        int n = heights.length;
        while(i<n){
            if(heights[i] >= heights[i-1]){
                pq.offer(heights[i]-heights[i-1]);
                bricks -= heights[i]-heights[i-1];
                
                if(bricks < 0 && ladders > 0){
                while(bricks < 0 && ladders > 0){
                    bricks += pq.poll();
                    ladders--;
                }
                    if(bricks < 0)
                        return i-1;
                }
                
                if(bricks < 0 && ladders <= 0)
                    return i-1;
            }
            i++;
        }
        
        return i-1;
    }
}