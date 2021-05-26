class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int min = Math.min(solve(A, B), solve(B, A));
        return min == Integer.MAX_VALUE ?  -1: min;
        
    }
    
    
    public int solve(int[] A, int[] B){
        int[] mapr = new int[7];
        int maxc = -1;
        int maxv = -1;
        for(int d: A){
            mapr[d]++;
            if(maxc < mapr[d])
            {
                maxc = mapr[d];
                maxv = d;
            }
        }
        int minchange = 0;
        int tot_c = 0;
        for(int i=0;i<A.length;i++){
            if(maxv == A[i]){
                tot_c++;
                continue;
            }
            else if(maxv == B[i]){
                tot_c++;
                minchange++;
            }
        }
        
        minchange = (tot_c == A.length ? minchange: Integer.MAX_VALUE);
        
        return minchange;
    }
}