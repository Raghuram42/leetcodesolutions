class Solution {
    int mod = 1000000007;
    public int countGoodNumbers(long n) {
        
        
        long odd = n/2;
        long even = n%2 == 1 ? (n/2)+1: n/2;
        long res = getAns(odd, 4);
        res = (res * getAns(even, 5))%mod;
        
        return (int)(res%mod);
        
        
        
    }
    public long getAns(long val, int div){
        return ((logPow(val, div))%mod);
    }
    
    public long logPow(long val, int div){
        
        if(val == 0)
            return 1;
        long res = (logPow(val/2, div))%mod;
        long evenres = (res*res)%mod;
        if(val%2 == 0)
            return evenres;
        
        return (evenres*div)%mod;
    }
}
