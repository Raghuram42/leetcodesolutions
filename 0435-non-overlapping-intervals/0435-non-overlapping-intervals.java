class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int overLapping = 0;
        
        int i = 1;
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[] prev = intervals[0];
        
        while(i<n){
            if(prev[1] > intervals[i][0]){
                prev[1] = Math.min(prev[1], intervals[i][1]);
                overLapping++;
            }else{
                prev = intervals[i];
            }
            i++;
        }
        
        return overLapping;
    }
}