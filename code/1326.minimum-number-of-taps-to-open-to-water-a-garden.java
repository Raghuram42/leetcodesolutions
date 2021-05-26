class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[][] pairs = new int[ranges.length][2];
        
        int i=0;
        
        for(int range: ranges){
            int leftPoint = i-range < 0 ? 0 : i-range;    
            int rightPoint = i+range > n ? n : i+range;    
            
            pairs[i++] = new int[]{leftPoint, rightPoint};
        }
        
        
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] firstPoint, int[] secondPoint){
                if(firstPoint[0] == secondPoint[0])
                    return  secondPoint[1]-firstPoint[1];
                
                return firstPoint[0]-secondPoint[0];
            }
        });
        
        
        int[] currpair = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] prev = new int[]{0,0};
        int res = 0;
        for(int[] pair: pairs){
        
            if(currpair[0] == Integer.MAX_VALUE && currpair[1] == Integer.MAX_VALUE){
                prev = new int[]{currpair[0], currpair[1]};
                currpair = pair;
                res++;
            }else{
                if(currpair[0] <= pair[0] && currpair[1] >= pair[1]){
                    continue;
                }else if(currpair[0] <= pair[0] && currpair[1] < pair[1] && currpair[1] >= pair[0]){
                    
                    if(!(prev[1] >= pair[0] && prev[1] <= pair[1])){
                    res++;
                    prev = new int[]{currpair[0], currpair[1]};
                    }
                    currpair[1] = pair[1];
                    // prev = pair;
                }else return -1;
            }
        // System.out.println(pair[0]+" "+pair[1]+" "+res);    
        }
        
        // System.out.println(res);
        return res;
    }
}