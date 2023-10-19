class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean added = false;
        
        int i = 0;
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        if(newInterval[0] == 0){
            added = true;
            res.add(newInterval);
        }
        while(i<n && !added){
            int[] curr = intervals[i];
            if(newInterval[0] <= curr[1] && newInterval[0] >= curr[0]){
                curr[0] = Math.min(curr[0], newInterval[0]);
                curr[1] = Math.max(curr[1], newInterval[1]);
                added = true;
            }else if(newInterval[0] <= curr[1]){
                res.add(newInterval);
                added = true;
                break;
            }
            res.add(curr);
            i++;
        }
        
        if(!added)
            res.add(newInterval);
        
        while(i<n){
            int[] curr = res.get(res.size()-1);
            
            if(intervals[i][0] <= curr[1]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
            else
                res.add(intervals[i]);
            
            i++;
        }
        
        int sz = res.size();
        int[][] ans = new int[res.size()][2];
        
        i = 0;
        
        while(i<sz){
            ans[i] = res.get(i);
            i++;
        }
        
        return ans;
            
    }
}