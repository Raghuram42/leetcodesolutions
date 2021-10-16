class Solution {
    int res;
    public int numberOfMatches(int n) {
        res = 0;
        solve(n);
        return res;
    }
    
    public int solve(int n){
        if(n == 1)
            return n;
        
        res += n/2;
        
        return solve(n/2 + (n%2));
    }
}
