class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        
        if(points.length == 1)
            return 1;
        
        
        Arrays.sort(points, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] p1, int[] p2){
                if(p1[0] == p2[0]){
                  //  System.out.println(p1[1]+" "+p2[1]);
                    return p1[1]>p2[1]?1:-1;
                }
                return p1[0]>p2[0]?1:-1;
            }
        });
        // for(int ii =0;ii<points.length;ii++)
        //     System.out.println(points[ii][0]+" "+points[ii][1]);
        int[] prev = points[0];
        int res = 1;
        int i =1;
        while(i<points.length){
            if(prev[1]>=points[i][0])
            {
         //       System.out.println(prev[1]+" "+points[i][0]+" "+i);
                prev[1] = Math.min(prev[1], points[i][1]);
            }else{
                res++;
                prev = points[i];
            }
            
            i++;
        }
        
        return res;
    }
}
           