class Solution {
    public int trailingZeroes(int n) {
        if(n < 5)
            return 0;
        
        int res = 0;
        for(int i=5;i<=n;i*=5){
            n = n -(n%i);
            res += n%i == 0 ? n/i : 0;
        }
        
        return res;
    }
}