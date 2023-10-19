class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        
        int i = 1;
        int n = intervals.length;
        res.add(intervals[0]);
        while(i<n){
            int[] curr = res.get(res.size()-1);
            
            if(curr[1] >= intervals[i][0]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }else{
                res.add(intervals[i]);
            }
            i++;
        }
        
        int sz = res.size();
        int[][] ans = new int[sz][2];
        i = 0;
        
        while(i<sz)
            ans[i] = res.get(i++);
        return ans;
    }
}