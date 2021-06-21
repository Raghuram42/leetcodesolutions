class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long l = 0;
        long r = (long) n * (long) (Math.min(a,b));
        
        long lcm = (a*1l*b)/gcd(a,b);
        // System.out.println(lcm);
        long ans = 0;
        while(l<=r){
            long mid = (l+r)/2;
            
            if(((mid/a) + (mid/b) - (mid/lcm)) < n ){
                l = mid+1;
            }else{
                ans = mid;
                r = mid-1;
            }
        }
        return (int)(ans%1000000007);
    }
    public int gcd(int a, int b){
        if(a>b)
            return gcd(b, a);
        if(a == 0)
            return b;
        if(b == 0)
            return a;
        
        return gcd(b%a, a);
            
    }
}