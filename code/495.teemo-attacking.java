class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0)
            return 0;
        
     int res = duration;
        for(int i=1;i<timeSeries.length;i++){
            int c = (duration-(timeSeries[i]-timeSeries[i-1]));
            res += duration-(c>0?c:0);
        }
        
        return res;
    }
}