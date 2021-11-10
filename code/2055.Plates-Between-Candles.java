class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] dp = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        
        
        for(int i=0;i<n;i++){
            int curr = i-1 >= 0 ? dp[i-1] : 0;
            if(s.charAt(i) == '*')
                dp[i] = curr+1;
            else
                dp[i] = curr;
        }
        int prev = -1;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '|')
                prev = i;
            left[i] = prev;
        }
        
        prev = -1;
        
        
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '|')
                prev = i;
            right[i] = prev;
        }
        int m = queries.length;
        int[] res = new int[m];
        for(int i=0;i<m;i++){
            if(right[queries[i][0]] >= 0 && left[queries[i][1]] >= 0 && right[queries[i][0]] < left[queries[i][1]]){
                res[i] = dp[left[queries[i][1]]]-dp[right[queries[i][0]]];
            }
        }
        return res;
    }
}
