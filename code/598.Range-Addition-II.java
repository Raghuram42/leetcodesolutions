class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0)
            return  m*n;
        
        for(int i=0;i<ops.length;i++){
            m = Math.min(ops[i][0], m);
            n = Math.min(ops[i][1], n);
        }
        
        return m*n;
    }
}
