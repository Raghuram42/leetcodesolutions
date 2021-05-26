class Solution {
    public int[] sumZero(int n) {
        
        int[] res = new int[n];
        
        int p = 0;
        
        while(p<n){
            res[p] = (p+1);
        p++;
            }
        
        res[p-1] = -1* res[p-1]*(res[p-1]-1)/2;
            
            return res;
    }
}