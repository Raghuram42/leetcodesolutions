class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
     if(intervals.length == 1 && intervals[0].length <= 1)
         return intervals[0].length;
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            }
        });
        int res = intervals.length;
        System.out.println(intervals[0][0]+" "+intervals[0][1]);
        int[] prev = intervals[0];
        for(int i=1;i<intervals.length;i++){
            System.out.println("prev "+prev[0]+" "+prev[1]+" curr "+intervals[i][0]+" "+intervals[i][1]);
            if(prev[0] <= intervals[i][0] && prev[1] >= intervals[i][1]){
                res--;
                System.out.println(" res: "+res);
                //prev = intervals[i-1];
                continue;
            }
            prev = intervals[i];
        }
            
        
        return res;
    }
}