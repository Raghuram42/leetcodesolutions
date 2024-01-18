class Solution {
    int[][] dp;
    public int minimumOperationsToMakeEqual(int x, int y) {
        dp = new int[5][10012];
        
        return s(x, y, 0);
    }
    
    public int s(int x, int y, int prev){
        if(x == y)
            return 0;
        
        if(x < y)
            return y-x;

        // int ans = 0;
        
        int rem11 = x%11;
        int rem5 = x%5;
        
           int ans = Math.min(1+rem11 + s(x/11, y, 1), 1+11-rem11 + s((x/11)+1, y, 1));

            int ans2 = Math.min(1+rem5 + s(x/5, y, 2), 1+5-rem5 + s((x/5)+1, y, 2));

            ans = Math.min(Math.abs(y-x), ans);
        return Math.min(ans,ans2);
    }
}