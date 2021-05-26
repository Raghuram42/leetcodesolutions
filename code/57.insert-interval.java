class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 1 && intervals[0].length == 0 || intervals.length == 0 )
        {
            int[][] re = new int[1][2];
            re[0] = newInterval; 
            return re;
        }
        if(newInterval.length == 0)
            return intervals;
      
        ArrayList<int[]> r = new ArrayList<int[]>();
     
        int i = 0;
        for(i=0;i<intervals.length;i++){
            int[] curr = intervals[i];
            r.add(curr);
            if(curr[1]>=newInterval[0])
            {
                if(curr[0] > newInterval[0] && curr[0] > newInterval[1]){
                    r.set(r.size()-1, newInterval);
                    r.add(curr);
                }
                else{
                r.get(r.size()-1)[0] = Math.min(newInterval[0], curr[0]);
                r.get(r.size()-1)[1] = Math.max(newInterval[1], curr[1]);
                }
                i++;
                break;
            }
            if(i+1 == intervals.length)
                r.add(newInterval);
        }
        for(;i<intervals.length;i++){
            int[] prev = r.get(r.size()-1);
            int[] curr = intervals[i];
            if(prev[1] >= curr[0]){
                r.get(r.size()-1)[0] = Math.min(prev[0], curr[0]);
                r.get(r.size()-1)[1] = Math.max(prev[1], curr[1]);
            }else{
                r.add(curr);
            }
        }
        int[][] res = new int[r.size()][2];
        i = 0;
        for(int[] c: r)
            res[i++] = c;
        
        return res;
    }
}