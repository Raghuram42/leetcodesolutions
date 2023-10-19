class Solution {
    Boolean[] dp;
  
    HashMap<Character, List<String>> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n];
        map = new HashMap<>();
        
        int i = 0;
        
        for(String next: wordDict){
            if(!map.containsKey(next.charAt(0)))
                map.put(next.charAt(0), new ArrayList<>());
            
            map.get(next.charAt(0)).add(next);
        }
        return solve(s, 0);
    }
    
    public boolean solve(String s, int i){
        if(i>=s.length())
            return true;
        if(dp[i] != null)
            return dp[i];
        List<String> rest = map.getOrDefault(s.charAt(i), new ArrayList<>());
        
        boolean ans = false;
        for(String next: rest){
            if(next.equals(s.substring(i, Math.min(s.length(), i+next.length()))))
                ans = ans || solve(s, i+next.length());
        }
        
        return dp[i] = ans;
    }
}