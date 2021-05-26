class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n+1];
        
        // solve2(n);
        
        return solve2(n);
    }
    
//     public int solve(int n){
//         if(n <= 1)
//             return 1;
//         int ans = 0;
//         ArrayList<Integer> lst = new ArrayList<>();
//         for(int i=1;i<=n/2;i++){
//             lst.add(i);
//             lst.add(n-i);
//             ans = Math.max(ans, i*(n-i));
//         }
        
//         for(int num: lst){
            
//         }
        
//         return ans;
//     }
    
       public int solve2(int n){
        if(n <= 1)
            return 1;
           if(dp[n] != 0)
               return dp[n];
        int ans = 0;
        // ArrayList<Integer> lst = new ArrayList<>();
        for(int i=1;i<=n/2;i++)
            ans = Math.max(ans, Math.max(i, solve2(i))*Math.max(n-i, solve2(n-i)));
        
        
        
        return dp[n] = ans;
    }
}