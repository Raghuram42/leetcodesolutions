class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        long f1 = dividend*1l;
        long f2 = divisor*1l;
        int dividesign = 1;
        int divissign = 1;
        
        if(divisor < 0){
            divissign = -1; 
            f2  = f2 *-1;
        }
        
        
        if(dividend < 0){
            dividesign = -1; 
            f1  = f1 *-1;
        }
        
        // if(divisor )
        long res = solve(f1,f2,f2, 1);
        
        // System.out.println(res+" "+f1+" "+f2);
        res = res-1;
        res *= dividesign*divissign;
        if(res > Integer.MAX_VALUE*1l)
            res = Integer.MAX_VALUE*1l;
        if(res < Integer.MIN_VALUE*1l)
            res = Integer.MIN_VALUE*1l;
        return (int)res;
    }
    public long solve(long f1, long f2, long explodedf2, long ans){
        // long res = 0;
//         while(f1 >= f2){
//             res++;
//             f1 -= f2;
            
//         }
        
        if(2*explodedf2 <= f1)
            ans += solve(f1-2*explodedf2,f2, 2*explodedf2, 2*ans);
        else{
            while(f1 >= f2 ){
            ans++;
                f1  -= f2;
                
            }
        }
        
        return ans;
    }
}