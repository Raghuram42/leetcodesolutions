class Solution {
    public int addRungs(int[] rungs, int dist) {
        // if(rungs.length == 1 && dist >= rungs[0])
        //     return 0;
        
        int min = 0;
        int n = rungs.length;
        int i = n-1;
        Stack<Integer> stk = new Stack<>();
        int left  = 0;
        while(i >= 0 ){
            
            
            if(left > rungs[i]){
                min += (left-rungs[i])%dist == 0? (left-rungs[i])/dist : ((left-rungs[i])/dist) +1;
            }
            left = rungs[i]-dist;
            i--;
        }
        // System.out.println(left);
        
            if(left > 0){
                min += (left)%dist == 0? (left)/dist : ((left)/dist) +1;
            }
        return min;
    }
}
