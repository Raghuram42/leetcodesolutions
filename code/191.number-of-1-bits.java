public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == Integer.MIN_VALUE)
            return 1;

       boolean countz = false;

        int res = 0;
        int itr = 32;
        while(itr != 0){
            if((countz && (n&1) == 0 ) || (!(countz) && (n&1) == 1))
            res++;
            n = n>>>1;
            itr--;
            
            
        }
     return res;   
    }
}