class Solution {
    public int minimumOneBitOperations(int n) {
        
        if(n<=1)
            return n;
        int nobits = 1;
        
        while((1<<nobits) <=n)
            nobits++;
        
        return (1<<nobits)-1-minimumOneBitOperations(n-(1<<(nobits-1)));
    }
}