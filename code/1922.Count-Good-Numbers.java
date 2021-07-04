class Solution {
    HashMap<Character, List<Character>> map;
    int mod;
    int[][] dp;
    public int countVowelPermutation(int n) {
        map = new HashMap<>();
        mod = 1000000007;
        dp = new int[n+1][26];
        map.put('f', Arrays.asList('a','e','i','o','u'));
        map.put('a', Arrays.asList('e'));
        map.put('e', Arrays.asList('i', 'a'));
        map.put('i', Arrays.asList('a','e','o','u'));
        map.put('o', Arrays.asList('i', 'u'));
        map.put('u', Arrays.asList('a'));
        
        return solve(n, 'f');
    }
    
    public int solve(int n, Character cur){
        if(n==0)
            return 1;
        if(dp[n][cur-'a'] != 0)
            return dp[n][cur-'a'];
        int ans = 0;
        for(Character next: map.get(cur))
            ans = (ans+solve(n-1, next))%mod;
            
        return dp[n][cur-'a'] = ans%mod;
    }
}
