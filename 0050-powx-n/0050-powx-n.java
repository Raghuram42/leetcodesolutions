class Solution {
    public double myPow(double x, int n) {
        boolean neg = n < 0;
        
        
        return neg ? 1/p(x,n*-1l) : p(x,n*1l);
    }
    
    public double p(double x, long n){
        if(n == 0)
            return 1;
        double ans = p(x,n/2);
        if(n%2 == 1)
            return ans*ans*x;
        
        return ans*ans;
    }
}