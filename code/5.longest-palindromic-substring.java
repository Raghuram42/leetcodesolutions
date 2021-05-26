class Solution {
    public String longestPalindrome(String s) {
        boolean [][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        String res = "";
        
        for (int right = 0; right < s.length(); right++)
        {
            for (int left = 0; left <= right; left++)
            {
                if (left == right) dp[left][right] = true;
                else if (left == right-1 && s.charAt(left) == s.charAt(right)) dp[left][right] = true;
                else if (dp[left+1][right-1] && s.charAt(left) == s.charAt(right)) dp[left][right] = true;
                if (dp[left][right] && right-left+1 > ans)
                {
                    ans = right-left+1;
                    res = s.substring(left, right+1);
                }
            }
        }
        return res;
    }
}