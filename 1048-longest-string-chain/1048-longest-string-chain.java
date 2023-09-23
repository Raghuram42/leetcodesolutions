class Solution {
    Integer[][] dp;
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->a.length()-b.length());
        dp = new Integer[words.length+1][words.length];
        // System.out.println(Arrays.toString(words));
        return s(words, -1, 0);
    }
    
    public int s(String[] w, int i, int k){
        if(k>=w.length)
            return 0;
        int n = w.length;
        
        if(dp[i+1][k] != null)
            return dp[i+1][k];
        int ans = 1;
        
        int include = 0;
        int exclude = 0;
        if(i == -1 || d(w[i], w[k]) == 1)
            include  = 1+s(w, k, k+1);
        
        exclude = s(w, i, k+1);
        
        
        return dp[i+1][k] = Math.max(include, exclude);
    }
    
    public int d(String fi, String sec){
        if(fi.length()+1 != sec.length())
            return 0;
        
        int i = 0;
        int j = 0;
        
        int n = fi.length();
        
        while(i<n && j < n+1){
            if(fi.charAt(i) == sec.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return i == n ? 1 :0;
    }
}