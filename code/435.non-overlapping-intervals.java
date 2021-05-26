class Solution {
    HashMap<Integer, ArrayList<Integer>> hsm;
    HashSet<Integer> vis;
    int res;
    public int eraseOverlapIntervals(int[][] intervals) {
        hsm = new HashMap<Integer, ArrayList<Integer>>();
        vis = new HashSet<Integer>();
        res = 0;
 //       System.out.println(intervals.length);
        
        if(intervals.length == 0 || intervals.length == 1 && intervals[0].length == 0)
            return res;
        
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a, int[] b){
                
                // if(a[1] == b[1]){
                //     if(a[0] < b[0])
                //         return -1;
                //     else
                //         return 1;
                // }
                // else
                // if(a[0]+a[1] == b[0]+b[1])
                // {
                //     if(a[])
                // }
                if(a[0]+a[1] < b[0]+b[1])
                    return -1;
                 
                return 1;
            }
        });
        int prev = intervals[0][1];
        for(int[] interval: intervals){
  //       System.out.println(interval[0]+" "+interval[1]);
            
           if(prev > interval[0]){
               res++;
              if(prev <= interval[1])
              continue;
           }
               prev = interval[1];
        }
        
        return res> 0 ? res-1: res;
    }
}