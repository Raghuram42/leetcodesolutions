class Solution {
    public int numTrees(int n) {
        
        return (int)(binomialcoeficient(2*n, n)/(n+1));
    }
    
    public long binomialcoeficient(int n, int k){
        long res = 1;
        if(k>n-k)
            k = n-k;
        
        
        for(int i=0;i<k;i++){
            res *= (n-i);
            res /=(i+1);
        }
        
        return res;
    }
}